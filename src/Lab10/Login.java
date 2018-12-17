package Lab10;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author jalvarez343
 */
public class Login extends JFrame {

    // initialize and declare text/password fields and panels
    public JPanel logPanel = null;
    public JTextField usernameInput = null;
    public JPasswordField passwordInput = null;
    public int x = 0;

    // method that creates the login display
    public Login() {
        super("Log In Screen");

        usernameInput = new JTextField();
        JLabel ID = new JLabel("Username");
        passwordInput = new JPasswordField();
        JLabel PSWD = new JLabel("Password");
        logPanel = new JPanel(); //panel A
        logPanel.setLayout(new FlowLayout());

        //set textfield size
        usernameInput.setLayout(new BoxLayout(usernameInput, BoxLayout.X_AXIS));
        usernameInput.setPreferredSize(new Dimension(250, 20));
        passwordInput.setLayout(new BoxLayout(passwordInput, BoxLayout.X_AXIS));
        passwordInput.setPreferredSize(new Dimension(250, 20));

        //adds the input fields
        logPanel.add(ID);
        logPanel.add(usernameInput);
        logPanel.add(PSWD);
        logPanel.add(passwordInput);

        getContentPane().add(logPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton showDialog = new JButton("Submit");

        buttonPanel.add(showDialog);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);

        showDialog.addActionListener(e -> {
            // initialize and declare messages
            String msg1 = "Permission granted you may continue.";
            String msg2 = "Incorrect User ID or Password has been entered "
                    + "please try again.";
            String msg3 = "You have exhausted your maximum attempt. Please contact "
                    + "your System Administration to unlock your account.";

            x++; // increment number of attempts

            // execute when number of attempts is less than or equal to 3
            if (x <= 3) {

                String usernameValue = usernameInput.getText(); // initialize and set value to username textfield value

                String passwordValue = new String(passwordInput.getPassword()); // initialize and set value to password field value

                // connect to the database
                Connection connect = Dao.getConnection();
                // initialize and declare query statement
                String query = "SELECT admin FROM user WHERE username = ? and password = ?";
                // initialize query result variables
                PreparedStatement ps;
                ResultSet results = null;
                Boolean isAdmin = false;

                try {

                    ps = (PreparedStatement) connect.prepareStatement(query);  // set value to execute query string cleanly and safely
                    ps.setString(1, usernameValue); // set username string value in query to username from input
                    ps.setString(2, passwordValue); // set password string value in query to password from input
                    results = ps.executeQuery(); // execute mySQL query

                    // execute if a record exists in database
                    if (results.next()) {
                        System.out.println("Username and password exist in database.");
                        
                        // execute if user has admin access
                        if (results.getInt("admin") == 1) {
                            isAdmin = true;
                        // execute if user does not have admin access
                        } else {
                            isAdmin = false;
                        }

                        JOptionPane.showMessageDialog(this, msg1); // display success dialog
                        setVisible(false); // hide login display
                        new Tickets(isAdmin); // start application

                    // execute if a record does not exist in database
                    } else {
                        JOptionPane.showMessageDialog(this, msg2 + " Attempt number: " + x); // display message dialog

                        // execute if number of attempt is equal to 3
                        if (x == 3) {
                            JOptionPane.showMessageDialog(this, msg3); // display message dialog
                            System.exit(0); // exit the application
                        }
                    }

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    // main method begins execution of Java application
    public static void main(String args[]) {
        new Login();  // start login dialog
    }
}
