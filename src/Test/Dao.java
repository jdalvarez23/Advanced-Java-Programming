package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao {
	// instance fields
	static Connection connect = null;
	Statement statement = null;

	// constructor
	public static Connection getConnection() {
		// Setup the connection with the DB
		try {
			connect = DriverManager
					.getConnection("jdbc:mysql://www.papademas.net:3307/wcc?autoReconnect=true&useSSL=false"
							+ "&user=userdb&password=pass");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connect;
	}

	public void createTable() {
		// variables for SQL Query table creations
		final String createTicketsTable = "CREATE TABLE jpapa_tickets(ticket_id INT AUTO_INCREMENT PRIMARY KEY, "
                                                + "ticket_issuer VARCHAR(30), ticket_description VARCHAR(200))";
	 
		try {

			// create table

			statement = getConnection().createStatement();

			statement.executeUpdate(createTicketsTable);
		 
			System.out.println("Created table in given database...");

			// end create table
			// close connection/statement object
			statement.close();
			connect.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		 
		 
	}

	
	// add other desired CRUD methods needed like for updates, deletes, etc.
}
