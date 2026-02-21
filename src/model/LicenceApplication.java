package model;

import java.sql.Date;

public class LicenceApplication {
	private String ApplicantId;
	private String ApplicantName;
	private Date applicantDOB;
	private String ApplicantAddress;
	private String panId;
	private long AadhaarNum;

	// Constructor
	public LicenceApplication() {

	}

	public LicenceApplication(String ApplicantName, Date applicantDOB, String ApplicantAddress,
			String panId, long AadhaarNum) {
		this.ApplicantName = ApplicantName;
		this.applicantDOB = applicantDOB;
		this.ApplicantAddress = ApplicantAddress;
		this.panId = panId;
		this.AadhaarNum = AadhaarNum;
	}

	// Getter for ApplicantId
	public String getApplicantId() {
		return ApplicantId;
	}

	// Getter for ApplicantName
	public String getApplicantName() {
		return ApplicantName;
	}

	// Getter for ApplicantAddress
	public String getApplicantAddress() {
		return ApplicantAddress;
	}

	// Getter for Applicant PanId
	public String getPanId() {
		return panId;
	}

	public long getAadhaarNum() {
		return AadhaarNum;
	}

	public Date getDob() {
		return applicantDOB;
	}

}
