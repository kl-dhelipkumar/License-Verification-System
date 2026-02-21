package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import exception.DatabaseException;
import model.PanCard;
import util.DB;

public class PanDAO {

	public PanCard findByPanId(String panId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		String query = "SELECT `pan_name`, `pan_address`,`dob` FROM pancard WHERE `pan_id`=?";
		try {
			con = DB.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, panId);
			res = pstmt.executeQuery();
			if (res.next()) {
				Date panDob = res.getDate("dob");
				String panName = res.getString("pan_name");
				String panAddress = res.getString("pan_address");
				PanCard pc = new PanCard(panId, panName, panAddress, panDob);
				return pc;
			}

		} catch (SQLException e) {
			throw new DatabaseException("Error fecting PanCard data", e);
		} finally {
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