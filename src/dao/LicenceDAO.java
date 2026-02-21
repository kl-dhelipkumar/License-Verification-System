package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import exception.DatabaseException;
import model.LicenceApplication;
import util.DB;

public class LicenceDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet res = null;

	public boolean exists(String panId, long aadhaarNum) {

		String query = "SELECT 1 FROM application WHERE pan_id = ? AND aadhaar_num = ?";

		try {
			con = DB.getConnection();
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, panId);
			pstmt.setLong(2, aadhaarNum);

			res = pstmt.executeQuery();
			return res.next();

		} catch (SQLException e) {
			throw new DatabaseException("Error checking application", e);
		}finally {
			try {
				res.close();
				pstmt.close();
				con.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void insertAppliaction(LicenceApplication la) {
		String query = "INSERT INTO application (`applicant_name`,`applicant_dob`,`applicant_address`,`pan_id`,`aadhaar_num`) VAlUES (?,?,?,?,?)";
		try {
			con = DB.getConnection();

			pstmt = con.prepareStatement(query);
			pstmt.setString(1, la.getApplicantName());
			pstmt.setDate(2, la.getDob());
			pstmt.setString(3, la.getApplicantAddress());
			pstmt.setString(4, la.getPanId());
			pstmt.setLong(5, la.getAadhaarNum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DatabaseException("Error inserting application", e);
		}finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
