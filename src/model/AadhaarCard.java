package model;

import java.sql.Date;

public class AadhaarCard {
	private long aadhaarNum;
	private String aadhaarName;
	private String aadhaarAddress;
	private Date aadhaarDob;

	// Constructor
	public AadhaarCard(long AadhaarNum, String AadhaarName, String AadhaarAddress, Date aadhaarDob) {
		this.aadhaarNum = AadhaarNum;
		this.aadhaarName = AadhaarName;
		this.aadhaarAddress = AadhaarAddress;
		this.aadhaarDob = aadhaarDob;
	}

	public AadhaarCard() {

	}

	// Getter for aadhaar Name
	public String getAadhaarName() {
		return aadhaarName;
	}

	// Getter for aadhaar Number
	public long getAadhaarNum() {
		return aadhaarNum;
	}

	// Getter for aadhaar Address
	public String getAadhaarAddress() {
		return aadhaarAddress;
	}

	// Getter for aadhaar DOB
	public Date getAadhaarDob() {
		return aadhaarDob;
	}
}