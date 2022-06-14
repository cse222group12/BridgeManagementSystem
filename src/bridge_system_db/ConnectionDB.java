package bridge_system_db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11499237";
	private static String user = "sql11499237";
	private static String password = "RUi51RGnLd";
	
	public static Connection connect() throws ClassNotFoundException, SQLException {
		try {
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(url, user, password);
			return connection;
		} catch (SQLException e) {
			throw e;
		}
	}
}
