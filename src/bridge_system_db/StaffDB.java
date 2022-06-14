package bridge_system_db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class StaffDB {
	private static String tableName = "sql11499237.staffs";
	private String staff_name;
	private String password;
	private StaffType type; 
	
	public StaffDB(String staff_name,String password,StaffType type) {
		this.staff_name = staff_name;
		this.password = password;
		this.type = type;	
	}
	
	
	public static void getAllStaff(Connection connection) throws SQLException {
		try {
			String sql = "select * from "+tableName;
			ResultSet result =  connection.prepareStatement(sql).executeQuery();
			while(result.next()) {
				System.out.println(new StaffDB(result.getString(1), result.getString(2),StaffType.fromInteger(result.getInt(3))));
			}
		} catch (SQLException e) {
			throw e;
		}
	}
	public static boolean addStaff(StaffDB staff,Connection connection) throws SQLException{
		try {
			String sql = "insert into "+tableName+" values( ? , ? , ? )";
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, staff.staff_name);
			st.setString(2, staff.password);
			st.setFloat(3, StaffType.toInteger(staff.type));
			int result = st.executeUpdate();
			if(result > 0) return true;
		} catch (SQLException e) {
			throw e;
		}
		return false;
	}
	
	public static boolean changePassword(String staff_name,String new_password, Connection connection) throws SQLException {
		try {
			String sql = "update "+ tableName+" set password = ? where staff_name = ? ";
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, new_password);
			st.setString(2, staff_name);
			int result = st.executeUpdate();
			if(result > 0) return true;
		} catch (SQLException e) {
			throw e;
		}
		return false;
	}
	
	public static boolean deleteUser(String staff_name,Connection connection) throws SQLException {
		try {
			String sql = "delete from "+tableName+" where staff_name = ? ";
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, staff_name);
			int result = st.executeUpdate();
			if(result > 0) return true;
		} catch (SQLException e) {
			throw e;
		}
		return false;
	}
	
	public static void getStaff(StaffType type,Connection connection) throws SQLException {
		String sql = "select * from "+tableName+" where type = ?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, type.ordinal());
			ResultSet result = st.executeQuery();
			while(result.next()) {
				System.out.println(new StaffDB(result.getString(1), result.getString(2),StaffType.fromInteger(result.getInt(3))));
			}
		} catch (Exception e) {
			throw e;
		}

	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("name : "+ this.staff_name);
		sb.append("\tpassword: "+this.password);
		sb.append("\trole : "+this.type.name());
		return sb.toString();
	}
	
	
}
