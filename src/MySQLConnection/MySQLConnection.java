package MySQLConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnection {

	public static Connection getMySQLConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/qlhh","root","");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
