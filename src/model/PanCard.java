package model;

import java.sql.Date;

public class PanCard {
	private String PanId;
	private String PanName;
	private String PanAddress;
	private Date panDob;

	public PanCard() {
	}

	// Constructor
	public PanCard(String PanId, String PanName, String PanAddress, Date panDob) {
		this.PanId = PanId;
		this.PanName = PanName;
		this.PanAddress = PanAddress;
		this.panDob = panDob;
	}

	// Getter for Pan_id
	public String getPanId() {
		return PanId;
	}

	// Getter for Pan_name
	public String getPanName() {
		return PanName;
	}

	public String getPanAddress() {
		return PanAddress;
	}

	public Date getPanDob() {
		return panDob;
	}


}