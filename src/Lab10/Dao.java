package Lab10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Dao {
    // instance fields

    static Connection connect = null;
    Statement statement = null;

    // constructor
    public static Connection getConnection() {
        // Setup the connection with the DB
        try {
            connect = DriverManager
                    .getConnection("");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connect;
    }

    // method that creates table in database
    public void createTable() {
        // variables for SQL Query table creations
        final String createTicketsTable = "CREATE TABLE jalva_tickets(ticket_id INT AUTO_INCREMENT PRIMARY KEY, "
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

    // method that updates ticket information in database
    public void update(int id, int option, String data) {

        String query = null; // initialize string for update query

        // execute if user wants to update ticket issuer name
        if (option == 1) {
            query = "UPDATE jalva_tickets SET ticket_issuer = '" + data + "' WHERE ticket_id = '" + id + "'";
            // execute if user wants to update ticket description
        } else if (option == 2) {
            query = "UPDATE jalva_tickets SET ticket_description = '" + data + "' WHERE ticket_id = '" + id + "'";
        }

        try {

            // create statement
            statement = getConnection().createStatement();
            statement.executeUpdate(query);

            System.out.println("SUCCESSFULLY executed query!");
            
            JFrame frame = new JFrame("JOptionPane showMessageDialog success"); // initialize and declare JFrame object

            JOptionPane.showMessageDialog(frame, "Successfully updated ticket in database!", "SUCCESS", JOptionPane.INFORMATION_MESSAGE); // display success message

            statement.close(); // close the statement
            connect.close(); // close connection to database
        } catch (Exception e) {
            System.out.println(e.getMessage());
            
            System.out.println("ERROR when executing query!");
            
            JFrame frame = new JFrame("JOptionPane showMessageDialog error"); // initialize and declare JFrame object

            JOptionPane.showMessageDialog(frame, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE); // display success message
            
        }
    }
    
    // method that deletes ticket from database
    public void delete (int id) {
        
        String query = "DELETE FROM jalva_tickets WHERE ticket_id ='" + id + "'"; // initialize and declare string for delete query

        try {

            // create statement
            statement = getConnection().createStatement();
            statement.executeUpdate(query);

            System.out.println("SUCCESSFULLY executed query!");
            
            JFrame frame = new JFrame("JOptionPane showMessageDialog success"); // initialize and declare JFrame object

            JOptionPane.showMessageDialog(frame, "Successfully deleted ticket from database!", "SUCCESS", JOptionPane.INFORMATION_MESSAGE); // display success message

            statement.close(); // close the statement
            connect.close(); // close connection to database
        } catch (Exception e) {
            System.out.println(e.getMessage());
            
            System.out.println("ERROR when executing query!");
            
            JFrame frame = new JFrame("JOptionPane showMessageDialog error"); // initialize and declare JFrame object

            JOptionPane.showMessageDialog(frame, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE); // display success message
            
        } 
    }
    
}
