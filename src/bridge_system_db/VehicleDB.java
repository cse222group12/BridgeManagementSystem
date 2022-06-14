package bridge_system_db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * this class holds the blueprint of a vehicle
 * @author sarwar
 *
 */
public class VehicleDB {
	
	
	private static String tableName = "sql11499237.vehicles";
	private String plate_number;
	private String user_name;
	private int type;
	
	
	/**
	 * constructor for database vehicle class
	 * @param plate_number is the number plate of a vehicle
	 * @param user_name is the owner of the vehicle
	 * @param type is the type of vehicle is of {@linkplain Enum} type
	 */
	public VehicleDB(String plate_number,String user_name,int type) {
		this.plate_number = plate_number;
		this.user_name = user_name;
		this.type = type;
		
	}
	
	
	/**
	 * this function will add a vehicle a vehicle to the system and register it to a user
	 * @param vehicle is of type {@linkplain VehicleDB}
	 * @param connection is of type {@linkplain Connection}
	 * @return returns true if the vehicle is added successfully else false
	 * @throws SQLException is of type {@linkplain SQLException}
	 */
	public static boolean addVehicle(VehicleDB vehicle,Connection connection) throws SQLException {
		//checking if user is a user of system
		if(UserDB.hasUser(vehicle.user_name, connection)) { // if user is present
			try {
				String sql = "insert into "+tableName+" values(?,?,?,?)" ;
				PreparedStatement st = connection.prepareStatement(sql);
				st.setString(1, vehicle.plate_number);
				st.setString(2, vehicle.user_name);
				st.setInt(3, vehicle.type);
				int result = st.executeUpdate();
				if(result > 0) return true;
			} catch (SQLException e) {
				throw e;
			}
		}else {
			throw new SQLException("vehicle user invalid");
		}
		return false;
	}
	
	/**
	 * this function will validate a user against a plate number
	 * @param user_name is the name of the user
	 * @param plate_number is the plate number of the user
	 * @param connection is of type {@linkplain Connection}
	 * @return returns true if valid else false
	 * @throws SQLException is of type {@linkplain SQLException}
	 */
	public static boolean validUserPlate(String user_name,String plate_number,Connection connection) throws SQLException{
		String sql = "select user_name from "+tableName+" where plate_number = ? ";
		
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, plate_number);
			ResultSet result = st.executeQuery();
			while(result.next()) {
				return result.getString(1).equals(user_name);
			}
		} catch (SQLException e) {
			throw e;
		}

		return false;
	}
	/**
	 * function to delete a vehicle from the system, using user_name and plate no.
	 * @param user_name
	 * @param plate_number
	 * @param connection
	 * @return
	 * @throws SQLException
	 */
	public static boolean deleteVehicleDB(String user_name,String plate_number,Connection connection) throws SQLException{
		try {
			String sql = " delete from "+tableName+" where plate_number = ? and user_name = ?";
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, plate_number);
			st.setString(2, user_name);
			int result = st.executeUpdate();
			if(result > 0) {
				return true;
			}
		} catch (SQLException e) {
			throw e;
		}
		return false;
	}
	
	
	public static VehicleDB getVehicleDB(String plate_number,Connection connection) throws SQLException {
		try {
			String sql = "select * from "+tableName +" where plate_number = ?";
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, plate_number);
			ResultSet result = st.executeQuery();
			while(result.next()) {
				return new VehicleDB(result.getString(1), result.getString(2), result.getInt(3));
			}
		} catch (Exception e) {
			throw e;
		}
		return null;
	}
	
	public static void getPlatesByUserName(String user_name,Connection connection) throws SQLException {
		String sql = "select plate_number from "+tableName+" where user_name = ?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, user_name);
			ResultSet result = st.executeQuery();
			while(result.next()) {
				System.out.println(result.getString(1));
			}
		} catch (SQLException e) {
			throw e;
		}

	}
	/**
	 * this function will return all the vehicles of the system
	 * @param connection is of type {@linkplain Connection}
	 * @throws SQLException is of type {@linkplain SQLException}
	 */
	public static void getAllVehiclesDB(Connection connection) throws SQLException {
		try {
			String sql = "select * from "+tableName;
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet result = st.executeQuery();
			while(result.next()) {
				System.out.println(new VehicleDB(result.getString(1), result.getString(2), result.getInt(3)));
			}
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("plate no: "+this.plate_number);
		sb.append("\tuser: "+this.user_name);
		sb.append("\ttype: "+this.type);
		return sb.toString();
	}

	
}
