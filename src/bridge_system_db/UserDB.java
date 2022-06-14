package bridge_system_db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




/**
 * this class is the blueprint class for the users of the database
 * @author sarwar
 */
public class UserDB {
	private static String tableName = "sql11499237.users";
	private String name;
	private String password;
	private String label;
	private double debt;
	private double balance;
	
	
	/**
	 * constructor 
	 * @param name is the name of the user, is of type {@linkplain String}
	 * @param label is the role / label of the user, is of type {@linkplain String}
	 * @param password is the password of the user, is of type {@linkplain String}
	 * @param balance is the current balance of the user, is of type {@linkplain Double}
	 * @param debt is the debt of the user, is of type {@linkplain Double}
	 */
	public UserDB(String name,String label,String password,double balance,double debt) {
		this.name = name;
		this.password = password;
		this.label = label;
		this.debt = debt;
		this.balance = balance;
	}
	
	/**
	 * this is another constructor 
	 * @param name is the name of the user, is of type {@linkplain String}
	 * @param label is role/label of the user, is of type {@linkplain String}
	 * @param password is password of the user, is of type {@linkplain String}
	 */
	public UserDB(String name,String label,String password) {
		this.name = name;
		this.password = password;
		this.label = label;
		this.debt = 0;
		this.balance = 0;
	}
	
	public static boolean hasUser(String name,Connection connection) throws SQLException {
		String sql = "select name from "+tableName+" where name = ?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1, name);
		ResultSet result = st.executeQuery();
		return result.next();
	}
	
	/**
	 * this function will add a user to the database
	 * @param user is of type {@linkplain UserDB}
	 * @return returns true if the user is added in the database successfully else false
	 * @throws SQLException is of type {@linkplain SQLException}
	 */
	public static boolean addUserDB(UserDB user,Connection connection) throws SQLException {
		try {
			if(hasUser(user.name, connection)) {
				connection.close();
				return false; //if user with same name is already in database
			}
			String sql = ("INSERT INTO sql11499237.users values(?,?,?,?,?)");//name , label,password,balance,debt
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, user.name);
			statement.setString(2, user.label);
			statement.setString(3, user.password);
			statement.setDouble(4, user.balance);
			statement.setDouble(5, user.debt);
			int result = statement.executeUpdate();
			if(result > 0) return true;
			else return false;
		} catch (SQLException e) {
			throw e;
		}
	}
	
	/**
	 * updates the password of a user
	 * @param name is the name of the user
	 * @param password is the new password of the user
	 * @return returns true if the password updates successfully else false
	 * @throws SQLException is of type {@linkplain SQLException}
	 */
	public static boolean updatePasswordDB(String name,String password,Connection connection) throws  SQLException {
		try {
			String sql = "update sql11499237.users set password = ? where name = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, password);
			statement.setString(2, name);
			int result = statement.executeUpdate();
			if(result > 0) return true;
			else return false;
		} catch (SQLException e) {
			throw e;
		}
	}
	
	
	/**
	 * returns the password of a user
	 * @param name is the name of the user
	 * @return returns the password of the user if success else false
	 * @throws SQLException is of type {@linkplain SQLException}
	 */
	public static String getPasswordDB(String name,Connection connection) throws SQLException {
		try {
			String sql = "select password from sql11499237.users where name = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, name);
			ResultSet result = statement.executeQuery();
			if(result.next()) {
				return result.getString(1);
			}
		} catch (SQLException e) {
			throw e;
		}
		return null;
	}
	
	/**
	 * function to get the current balance of a user
	 * @param name is the name of the user, is of type {@linkplain String}
	 * @return returns the balance of the user if retrieved successfully else -1
	 * @throws SQLException is of type {@linkplain SQLException}
	 */
	public static double getBalanceDB(String name,Connection connection) throws SQLException {
		try {
			String sql = "select balance from sql11499237.users where name = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, name);
			ResultSet result = statement.executeQuery();
			if(result.next()) {
				return result.getDouble(1);
			}
		} catch (SQLException e) {
			throw e;
		}
		return -1;
	}
	
	/**
	 * this function will set the balance of a user to a new balance
	 * @param name is the name of the user
	 * @param updatedBalance is the new balance of the user (if new balance  is 100 and old balance is 50, the new balance will be 100, not 150)
	 * @return returns true if the balance updates successfully else false
	 * @throws SQLException is of type {@linkplain SQLException}
	 */
	public static boolean updateBalanceDB(String name,double new_balance,Connection connection) throws SQLException {
		try {
			String sql = "update sql11499237.users set balance = ? where name = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setDouble(1, new_balance);
			statement.setString(2, name);
			int result = statement.executeUpdate();
			System.out.println(result);
			if(result > 0) return true;
		} catch (SQLException e) {
			throw e;
		}
		return false;
	}
	
	/**
	 * this method will return the all the users from the database
	 * @throws SQLException is of type {@linkplain SQLException}
	 */
	public static void getAllUserDB(Connection connection) throws  SQLException {
		try {
			String sql = "select * from  "+tableName;
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet result = st.executeQuery();
			while(result.next()) {
				System.out.println(new UserDB(result.getString(1), result.getString(2), result.getString(3),result.getDouble(4),result.getDouble(5)));
			}
		} catch (SQLException e) {
			throw e;
		}
	}
	
	public static boolean updateDebtDB(double debt, String name,Connection connection) throws SQLException {
		try {
			String sql =  "update "+tableName+" set debt = ? where name = ?";
			PreparedStatement st = connection.prepareStatement(sql);
			st.setDouble(1, debt);
			st.setString(2, name);
			int result = st.executeUpdate();
			if(result > 0 ) return true;
		} catch (Exception e) {
			throw e;
		}
		return false;
	}
	
	
	/**
	 * function to get the debt of a user
	 * @param name is the name of the user
	 * @param connection is of type {@linkplain Connection}
	 * @return returns the current debt of the user if success, else return -1
	 * @throws SQLException is of type {@linkplain SQLException}
	 */
	public static double getDebtDB(String name,Connection connection) throws SQLException {
		try {
			String sql  = "select debt from "+tableName+" where name = ?";
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, name);
			ResultSet result = st.executeQuery();
			while(result.next()) {
				return result.getDouble(1);
			}
		} catch (SQLException e) {
			throw e;
		}
		return -1;
	}
	
	public static boolean deleteUserDB(String name,Connection connection) throws SQLException{
		try {
			String sql = "delete from sql11499237.users where name = ? ";
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, name);
			int result = st.executeUpdate();
			if(result > 0) return true;
		} catch (Exception e) {
			throw e;
		}
		return false;
	}
	
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("name: "+this.name);
		sb.append("\tpass: "+this.password);
		sb.append("\trole: "+this.label);
		sb.append("\tdebt: "+this.debt);
		sb.append("\tbalance: "+this.balance);
		return sb.toString();
	}
}
