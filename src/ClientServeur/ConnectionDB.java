package ClientServeur;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConnectionDB {
	private final String url = "jdbc:mysql://dmilinux.uqtr.ca:3309/mi954db";
	private final String user = "mi954";
	private final String pwd = "thekhil4";
	private Connection conn;
	public ConnectionDB()
	{
		
	}
	public Connection getConnection()
	{
		try 
		{
			conn = DriverManager.getConnection(url, user, pwd);
			if (conn != null) 
			{
				System.out.println("Connected");
			}
			return conn;
	    } 
		catch (SQLException ex) { ex.printStackTrace(); return null; }
   
	
    }
	public void closeConnection() throws SQLException
	{
		conn.close();
	}
}