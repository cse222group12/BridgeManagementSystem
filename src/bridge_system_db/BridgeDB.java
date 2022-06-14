package bridge_system_db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BridgeDB {
	private static String tableName = "sql11499237.bridges";
	private String bridge_name;
	private String staff_name;
	private String plate_number;
	
	public BridgeDB(String bridge_name,String staff_name,String plate_number){
		this.bridge_name = bridge_name;
		this.staff_name = staff_name;
		this.plate_number = plate_number;
	}
	
	
	public static boolean addBridge(BridgeDB bridge,Connection connection) throws SQLException {
		try {
			String sql = "insert into "+tableName+" values(?, ?, ?)";
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, bridge.bridge_name);
			st.setString(2, bridge.staff_name);
			st.setString(3, bridge.plate_number);
			int result = st.executeUpdate();
			if(result > 0) return true;
		} catch (SQLException e) {
			throw e;
		}
		return false;
	}
	
	
	public void getStaffs(String bridge_name,Connection connection) throws SQLException{
		try {
			String sql = "select staff_name from "+tableName+" where bridge_name = ?";
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, bridge_name);
			ResultSet result = st.executeQuery();
			while(result.next()) {
				System.out.println(new BridgeDB(result.getString(1), result.getString(2), result.getString(3)));
			}
		} catch (SQLException e) {
			throw e;
		}
	}
	
	public void getPassHistory(String bridge_name,Connection connection) throws SQLException{
		try {
			String sql = "select plate_number from "+tableName+" where bridge_name = ?";
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, bridge_name);
			ResultSet result = st.executeQuery();
			while(result.next()) {
				System.out.println(new BridgeDB(result.getString(1), result.getString(2), result.getString(3)));
			}
		} catch (SQLException e) {
			throw e;
		}
	}
	
	public static void getAllBridge(Connection connection) throws SQLException {
		try {
			String sql = "select * from "+tableName;
			PreparedStatement st = connection.prepareStatement(sql);

			ResultSet result = st.executeQuery();
			while(result.next()) {
				System.out.println(new BridgeDB(result.getString(1), result.getString(2), result.getString(3)));
			}
		} catch (SQLException e) {
			throw e;
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("bridge name: "+this.bridge_name+"\tstaff_name: "+this.staff_name+"\tplate_number: "+this.plate_number);
		return sb.toString();
	}
}
