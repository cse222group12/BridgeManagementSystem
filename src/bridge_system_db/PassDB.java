package bridge_system_db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PassDB {
	private static String tableName = "sql11499237.staffs";
	private String plate_number;
	private Date checkin_time;
	private Date checkout_time;
	public PassDB(String plate_number,Date checkin_time, Date checkout_time) {
		this.plate_number = plate_number;
		this.checkin_time = checkin_time;
		this.checkout_time = checkout_time;
	}
	
	public static boolean createPass(PassDB pass,Connection connection) throws SQLException {
		try {
			String sql = "insert into "+tableName+" values(?,?,?)";
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, pass.plate_number);
			st.setDate(2, pass.checkin_time);
			st.setDate(3, pass.checkout_time);
			int result = st.executeUpdate();
			if(result > 0) return true;
		} catch (SQLException e) {
			throw e;
		}
		return false;
	}
	
	public static void getPass(String plate_number, Connection connection) {
		try {
			String sql = "select * from "+tableName+" where plate_number = ? ";
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, plate_number);
			ResultSet result = st.executeQuery();
			while(result.next()) {
				System.out.println(new PassDB(result.getString(1), result.getDate(2), result.getDate(3)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("plate : "+ this.plate_number);
		sb.append("\tcheckin: "+this.checkin_time);
		sb.append("\tcheckout : "+this.checkout_time);
		return sb.toString();
	}
}
