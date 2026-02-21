package com.dhelip;

import java.util.Scanner;

import dao.AadhaarDAO;
import dao.PanDAO;
import exception.DatabaseException;
import model.AadhaarCard;
import model.PanCard;
import service.LicenseService;
import service.VerificationResult;

public class Main {

	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			System.out.println("Enter your Pan id: ");
			String panId = sc.next();

			System.out.println("Enter your Aadhaar Number: ");
			Long aadhaarNum = sc.nextLong();

			PanDAO panDAO = new PanDAO();
			AadhaarDAO aadhaarDAO = new AadhaarDAO();
			LicenseService ls = new LicenseService();

			PanCard pc = panDAO.findByPanId(panId);
			AadhaarCard ac = aadhaarDAO.findByAadhaarNum(aadhaarNum);

			VerificationResult result = ls.verify(pc, ac);
			System.out.println(result.getMessage());

		} catch (Exception e) {
			throw new DatabaseException("Input mismatch", e);
		} finally {
			sc.close();
		}

	}
}
