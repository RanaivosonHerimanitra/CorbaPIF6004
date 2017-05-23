package ClientServeur;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConnectionDB {
	private final String url = "jdbc:mysql://dmilinux.uqtr.ca:3309/mi954db";
	private final String user = "mi954";
	private final String pwd = "thekhil4";
	public ConnectionDB()
	{
		try {
			Connection conn = DriverManager.getConnection(url, user, pwd);
			if (conn != null) {
				System.out.println("Connected");
				}
	} 
	catch (SQLException ex) {
	    ex.printStackTrace();
	}

}
	public static void main (String[] args )
	{
		ConnectionDB a= new ConnectionDB();
		
	}
}