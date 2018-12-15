package Lab9;

import java.awt.*;
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
    public String correctUsername = "admin";
    public JPasswordField passwordInput = null;
    public String correctPassword = "admin";
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
                
                // execute if username and passwords match correct credentials
                if ((usernameValue.equals(correctUsername)) && (passwordValue.equals(correctPassword))) {
                    JOptionPane.showMessageDialog(this, msg1); // display success dialog
                    setVisible(false); // hide login display
                    new Tickets(); // start application
                // execute if username and passwords do not match correct credentials
                } else {     
                    JOptionPane.showMessageDialog(this, msg2 + " Attempt number: " + x); // display message dialog
                    
                    // execute if number of attempt is equal to 3
                    if (x == 3) {
                        JOptionPane.showMessageDialog(this, msg3); // display message dialog
                        System.exit(0); // exit the application
                    }
                }
            } 
        });
    }

    // main method begins execution of Java application
    public static void main(String args[]) {
        new Login();  // start login dialog
    }
}
