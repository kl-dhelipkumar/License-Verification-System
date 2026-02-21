package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import exception.DatabaseException;
import model.AadhaarCard;
import util.DB;

public class AadhaarDAO {
	public AadhaarCard findByAadhaarNum(Long aadhaarNum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		String query = "SELECT `aadhaar_name`, `dob`, `aadhaar_address` FROM aadhaarcard WHERE `aadhaar_num`=?";

		try {
			con = DB.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setLong(1, aadhaarNum);
			res = pstmt.executeQuery();
			if (res.next()) {
				String aadhaarName = res.getString("aadhaar_name");
				Date aadhaarDob = res.getDate("dob");
				String aadhaarAddress = res.getString("aadhaar_address");
				AadhaarCard ac = new AadhaarCard(aadhaarNum, aadhaarName, aadhaarAddress, aadhaarDob);
				return ac;
			}

		} catch (SQLException e) {
			throw new DatabaseException("Error fetching Aadhaar data", e);
		}finally {
			try {
				res.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
