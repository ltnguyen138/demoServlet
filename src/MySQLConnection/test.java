package MySQLConnection;

import java.sql.Connection;

public class test {

	public test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection c = MySQLConnection.getMySQLConnection();
		System.out.print(c);
	}

}
