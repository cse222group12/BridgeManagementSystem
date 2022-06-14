package bridge_system_db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PenaltyDB {
	
	private static String tableName = "sql11499237.penalties";
	private String user_name;
	private String plate_number;
	private double debt = 0;
	private String reason;
	
	public PenaltyDB(String user_name,String plate_number,double debt,String reason) {
		this.user_name = user_name;
		this.plate_number = plate_number;
		this.debt = debt;
		this.reason = reason;
	}
	
	public static boolean addPenaltyDB(PenaltyDB penalty,Connection connection) throws SQLException {
		if(!VehicleDB.validUserPlate(penalty.user_name, penalty.plate_number, connection))
			throw new SQLException("invalid plate/user name");
		try {
			String sql = "insert into "+tableName+" values(?, ?, ?, ?)";
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, penalty.user_name);
			st.setString(2, penalty.plate_number);
			st.setDouble(3, penalty.debt);
			st.setString(4, penalty.reason);
			int result = st.executeUpdate();
			if(result > 0) return true;
		} catch (SQLException e) {
			throw e;
		}
		return false;
	}
	
	public static boolean deletePenaltyDB(PenaltyDB penalty,Connection connection)throws SQLException {
		if(!VehicleDB.validUserPlate(penalty.user_name, penalty.plate_number, connection))
			throw new SQLException("invalid plate/user name");
		try {
			String sql = "delete from "+tableName+" where user_name = ? and plate_number = ? and debt = ? , reason = ?  ";
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, penalty.user_name);
			st.setString(2, penalty.plate_number);
			st.setDouble(3, penalty.debt);
			st.setString(4, penalty.reason);
			int result = st.executeUpdate();
			if(result > 0) return true;
		} catch (SQLException e) {
			throw e;
		}
		return false;
	}
	
	public static void getAllPenaltyByUserPlate(String plate_number,Connection connection) throws SQLException {
		String sql = "select * from "+tableName+" where plate_number = ? ";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, plate_number);
			ResultSet result = st.executeQuery();
			while(result.next()) {
				System.out.println(new PenaltyDB(result.getString(1), result.getString(2), result.getDouble(3), result.getString(4)));
			}
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	/**
	 * this function will return all the penalties by the plate number
	 * @param user_name
	 * @param connection
	 * @throws Exception
	 */
	public static void getAllPenaltyByUser(String user_name,Connection connection) throws Exception {
		String sql = "select * from "+tableName+" where user_name = ? ";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, user_name);
			ResultSet result = st.executeQuery();
			while(result.next()) {
				System.out.println(new PenaltyDB(result.getString(1), result.getString(2), result.getDouble(3), result.getString(4)));
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("user: "+this.user_name);
		sb.append("\tplate: "+this.plate_number);
		sb.append("\tdebt: "+this.debt);
		sb.append("\treason: "+this.reason);
		return sb.toString();
	}
}
