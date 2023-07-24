package ConnectDB;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
	static Connection con = null;
	public void getConnectDB() {
		try {
			String URL = "jdbc:sqlserver://localhost:1433;databasename=karaoke";
			String user = "sa";
			String password = "123456789";
			con = DriverManager.getConnection(URL, user, password);
			if(con != null) {
				System.out.println("kết nối thành công");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public static Connection getConnection() {
		return con;
	}
}
