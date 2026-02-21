package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

import dao.LicenceDAO;
import model.AadhaarCard;
import model.LicenceApplication;
import model.PanCard;
import util.DB;

public class LicenceService {

	public VerificationResult verify(PanCard pc, AadhaarCard ac) {

		if (pc == null)
			return new VerificationResult(false, "PAN not found");

		if (ac == null)
			return new VerificationResult(false, "Aadhaar not found");

		try (Connection con = DB.getConnection()) {

			con.setAutoCommit(false); // 🔥 START TRANSACTION

			int age = Period.between(pc.getPanDob().toLocalDate(), LocalDate.now()).getYears();

			if (age < 18)
				return new VerificationResult(false, "Applicant must be 18+");

			if (age > 60)
				return new VerificationResult(false, "Applicant above allowed age");

			if (!pc.getPanName().equalsIgnoreCase(ac.getAadhaarName()))
				return new VerificationResult(false, "Name mismatch");

			if (!pc.getPanDob().equals(ac.getAadhaarDob()))
				return new VerificationResult(false, "DOB mismatch");

			if (!pc.getPanAddress().equalsIgnoreCase(ac.getAadhaarAddress()))
				return new VerificationResult(false, "Address mismatch");
			
			LicenceApplication la = new LicenceApplication(pc.getPanName(), pc.getPanDob(), pc.getPanAddress(),
					pc.getPanId(), ac.getAadhaarNum());
			LicenceDAO lDAO = new LicenceDAO();
			lDAO.insertAppliaction(la);
			con.commit();
			return new VerificationResult(true, "Application Verified Successfully");

		} catch (SQLException e) {
			return new VerificationResult(false, "Duplicate por database error");
		}

	}
}
