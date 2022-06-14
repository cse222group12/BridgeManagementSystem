package bridge_system_db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CityDB {
	private static String tableName = "sql11499237.cities";
	private static String tname = "sql11499237.citytobridge";
	private String city_name;
	private String admin;
	
	public CityDB(String city_name , String admin) {
		this.city_name = city_name;
		this.admin = admin;
	}
	
	public static boolean addCity(CityDB city, Connection connection) throws SQLException{
		try {
			String sql = "insert into "+tableName+" values(?, ?, ?)";
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, city.city_name);
			st.setString(2, city.admin);
			int result = st.executeUpdate();
			if( result > 0) return true;
		} catch (SQLException e) {
			throw e;
		}
		return false;
	}
	

	
	
	public static boolean addBridge(String city_name, String bridge_name,Connection connection) throws SQLException{
		try {
			String sql = "insert into "+tname+" values (?, ?)";
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, city_name);
			st.setString(2, bridge_name);
			int result = st.executeUpdate();
			if(result > 0) return true;
		} catch (Exception e) {
			throw e;
		}
		return false;
	}
	
	public static boolean deleteBridge(String city_name ,  String bridge_name,Connection connection) throws SQLException{
		try {
			String sql = "delete from "+tname+" where city_name = ? and bridge_name =  ?";
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, city_name);
			st.setString(2, bridge_name);
			int res = st.executeUpdate();
			if(res > 0) return true;
		} catch (SQLException e) {
			throw e;
		}
		return false;
	}
	
	public void getBridges(String city_name,Connection connection) throws SQLException {
		try {
			String sql = "select bridge_name from "+tname+" where city_name = ? ";
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, city_name);
			ResultSet res = st.executeQuery();
			while(res.next()) {
				System.out.println(res.getString(1));
			}
		} catch (SQLException e) {
			throw e;
		}
	}
	
	public static void getALLCity(Connection connection) throws SQLException{
		try {
			String sql = "select * from "+tableName;
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet result = st.executeQuery();
			while( result.next()) {
				System.out.println(new CityDB(result.getString(1), result.getString(2)));
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("city name: "+this.city_name+"\tadmin: "+this.admin);
		return sb.toString();
	}
}
