/*
 * classe pour les credentials de la connection a la base de donnees mysql
 */
package serveur;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConnectionDB {
	private final String url = "jdbc:mysql://dmilinux.uqtr.ca:3309/mi954db";
	private final String user = "mi954";
	private final String pwd = "thekhil4";
	private static Connection conn;
	private static ConnectionDB InstanceDB = null;
	
	private ConnectionDB(){
		try 
		{
			conn = DriverManager.getConnection(url, user, pwd);
			if (conn != null) 
			{
				System.out.println("Connected");
			}
	    } 
		catch (SQLException ex) { ex.printStackTrace();}
	}
	
	public static Connection getConnection(){
		if (InstanceDB ==  null )
			InstanceDB = new ConnectionDB();
		return conn;
		
	}
	
	
	
	public void closeConnection() throws SQLException
	{
		conn.close();
	}
}