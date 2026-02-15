package EmployeeDatabase;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionOfDatabse {
	
	public static Connection con;

	public static Connection databaseConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3307/Employee_Management","username","Password");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
}
