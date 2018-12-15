package Lab10;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Window;
import static java.awt.Window.getWindows;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Tickets implements ActionListener {

    // class level member objects
    Dao dao = new Dao(); // for CRUD operations

    private JFrame mainFrame;

    JScrollPane sp = null;

    // Main menu object items
    private JMenu mnuFile = new JMenu("File");
    private JMenu mnuTickets = new JMenu("Tickets");
    private JMenu mnuAdmin = new JMenu("Admin");

    /* add any more Main menu object items below */
    // Sub menu item objects for all Main menu item objects
    JMenuItem mnuItemExit;
    JMenuItem mnuItemLogout;
    JMenuItem mnuItemOpenTicket;
    JMenuItem mnuItemViewTicket;
    JMenuItem mnuItemUpdateTicket;
    JMenuItem mnuItemDeleteTicket;

    /* add any more Sub object items below */
    // constructor
    public Tickets() {
        dao.createTable();
        createMenu();
        prepareGUI();
    }

    private void createMenu() {

        /* Initialize sub menu items **************************************/
        // initialize sub menu item for File main menu
        mnuItemExit = new JMenuItem("Exit");
        mnuItemLogout = new JMenuItem("Logout");
        // add to File main menu item
        mnuFile.add(mnuItemLogout);
        mnuFile.add(mnuItemExit);

        // initialize first sub menu item for Tickets main menu
        mnuItemOpenTicket = new JMenuItem("Open Ticket");
        // add to Ticket Main menu item
        mnuTickets.add(mnuItemOpenTicket);

        // initialize second sub menu item for Tickets main menu
        mnuItemViewTicket = new JMenuItem("View Tickets");
        // add to Ticket Main menu item
        mnuTickets.add(mnuItemViewTicket);

        // initialize third sub menu item for Tickets main menu
        mnuItemUpdateTicket = new JMenuItem("Update Tickets");
        mnuItemDeleteTicket = new JMenuItem("Delete Tickets");
        // add to Ticket Main menu item
        mnuAdmin.add(mnuItemUpdateTicket);
        mnuAdmin.add(mnuItemDeleteTicket);

        /* Add action listeners for each desired menu item *************/
        mnuItemLogout.addActionListener(this);
        mnuItemExit.addActionListener(this);
        mnuItemOpenTicket.addActionListener(this);
        mnuItemViewTicket.addActionListener(this);
        mnuItemUpdateTicket.addActionListener(this);
        mnuItemDeleteTicket.addActionListener(this);
    }

    private void prepareGUI() {
        // initialize frame object
        mainFrame = new JFrame("Tickets");

        // create jmenu bar
        JMenuBar bar = new JMenuBar();
        bar.add(mnuFile); // add main menu items in order, to JMenuBar
        bar.add(mnuTickets); // add ticket menu items in order, to JMenuBar
        bar.add(mnuAdmin); // add admin menu items in order, to JMenuBar
        // add menu bar components to frame
        mainFrame.setJMenuBar(bar);

        mainFrame.addWindowListener(new WindowAdapter() {
            // define a window close operation
            public void windowClosing(WindowEvent wE) {
                System.exit(0);
            }
        });

        // set frame display
        // create elements and set their values
        JPanel starterPanel = new JPanel();
        JLabel introductionMessage = new JLabel("Welcome to the CIA IT Help Desk");
        JLabel appDescriptionMessage = new JLabel("This application will help you receive help from CIA IT experts by allowing you to create tickets.");
        JLabel appDescriptionMessage2 = new JLabel("CIA IT experts have the ability to view, modify, and delete help desk tickets.");
        JLabel startMessage = new JLabel("Click on the 'Tickets' menu button to view your options");
        // add elements to the starter panel
        starterPanel.add(introductionMessage);
        starterPanel.add(appDescriptionMessage);
        starterPanel.add(appDescriptionMessage2);
        starterPanel.add(startMessage);
        // add the starter panel to the JFrame
        mainFrame.getContentPane().add(starterPanel, BorderLayout.CENTER);
        // set frame options
        mainFrame.setSize(600, 400);
        //mainFrame.getContentPane().setBackground(Color.LIGHT_GRAY);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }

    /*
	 * action listener fires up items clicked on from sub menus with one action
	 * performed event handler!
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        // implement actions for sub menu items
        if (e.getSource() == mnuItemExit) {
            System.exit(0);
        } else if (e.getSource() == mnuItemLogout) {
            closeAllDialogs(); // call method that closes all dialogs
            new Login(); // return user to login screen
        } else if (e.getSource() == mnuItemOpenTicket) {

            try {

                // get ticket information
                String ticketName = JOptionPane.showInputDialog(null, "Enter your name");

                if (ticketName == null) {
                    System.out.println("No data was inserted!");
                } else {
                    String ticketDesc = JOptionPane.showInputDialog(null, "Enter a ticket description");

                    if (ticketDesc != null) {
                        // insert ticket information to database

                        Statement statement = dao.getConnection().createStatement();

                        int result = statement
                                .executeUpdate("Insert into jalva_tickets(ticket_issuer, ticket_description) values(" + " '"
                                        + ticketName + "','" + ticketDesc + "')", Statement.RETURN_GENERATED_KEYS);

                        // retrieve ticket id number newly auto generated upon record
                        // insertion
                        ResultSet resultSet = null;
                        resultSet = statement.getGeneratedKeys();
                        int id = 0;
                        if (resultSet.next()) {
                            id = resultSet.getInt(1); // retrieve first field in table
                        }
                        // display results if successful or not to console / dialog box
                        if (result != 0) {
                            System.out.println("Ticket ID : " + id + " created successfully!!!");
                            JOptionPane.showMessageDialog(null, "Ticket id: " + id + " created");
                        } else {
                            System.out.println("Ticket cannot be created!!!");
                        }
                    }

                }

            } catch (SQLException ex) {
                // TODO Auto-generated catch block
                ex.printStackTrace();
            }
        } else if (e.getSource() == mnuItemViewTicket) {

            // retrieve ticket information for viewing in JTable
            try {

                Statement statement = dao.getConnection().createStatement();

                ResultSet results = statement.executeQuery("SELECT * FROM jalva_tickets");

                // Use JTable built in functionality to build a table model and
                // display the table model off your result set!!!
                JTable jt = new JTable(TicketsJTable.buildTableModel(results));

                // create elements and set their values
                JPanel dataPanel = new JPanel();

                // method that listens for selected row from JTable (listens for both mouse press and keyboard selection)
                jt.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                    public void valueChanged(ListSelectionEvent event) {

                        // the following conditional prevents code from executing twice
                        if (!event.getValueIsAdjusting() && jt.getSelectedRow() != -1) {
                            System.out.println(jt.getValueAt(jt.getSelectedRow(), 0).toString());

                            // initialize variables
                            int rowSelected = jt.getSelectedRow();
                            String retrievedTicketID = jt.getModel().getValueAt(rowSelected, 0).toString();
                            String retrievedTicketName = jt.getModel().getValueAt(rowSelected, 1).toString();
                            String retrievedTicketDescription = jt.getModel().getValueAt(rowSelected, 2).toString();

                            JFrame frame = new JFrame("JOptionPane showMessageDialog example"); // initialize and declare JFrame object

                            JOptionPane.showMessageDialog(frame, "Ticket ID: " + retrievedTicketID + "\nTicket Name: " + retrievedTicketName + "\nTicket Description: " + retrievedTicketDescription + " \n", "Ticket Information - ID #" + retrievedTicketID, JOptionPane.INFORMATION_MESSAGE); // display information in a message box
                        }
                    }
                });

                jt.setBounds(30, 40, 200, 300);
                sp = new JScrollPane(jt);
                mainFrame.getContentPane().removeAll(); // remove all components on the frame before adding JTable
                mainFrame.add(sp); // add JTable to mainFrame
                mainFrame.setVisible(true); // displays frame on dialog display
                statement.close(); // close connection to the database

            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        } else if (e.getSource() == mnuItemUpdateTicket) {

            try {
                
                // initialize variables
                String ticketSelected;
                String optionSelected;
                
                // retrieve tickets from database
                Statement statement = dao.getConnection().createStatement();
                ResultSet results = statement.executeQuery("SELECT * FROM jalva_tickets");

                // create dropdown selector
                JComboBox<String> ticketDropdownSelector = new JComboBox<String>();
                JComboBox<String> updateSelector = new JComboBox<String>();
                
                updateSelector.addItem("Update ticket issuer name");
                updateSelector.addItem("Update ticket description");
                
                // create panel to place dropdown selector
                JPanel panel = new JPanel();

                // add retrieved tickets to dropdown selector
                while (results.next()) {
                    int ticketID = results.getInt("ticket_id"); // retrieve ticket ID from sql results
                    String ticketName = results.getString("ticket_issuer"); // retrieve ticket name from sql results
                    String ticketDescription = results.getString("ticket_description"); // retrieve ticket description from sql results

                    ticketDropdownSelector.addItem("#" + Integer.toString(ticketID) + " - " + ticketName + " - " + ticketDescription);
                }
                
                // add elements to JPanel and mainFrame
                JLabel message = new JLabel("Please select which ticket you want to update.");
                JLabel message2 = new JLabel("Please select an action:");
                panel.add(message);
                panel.add(ticketDropdownSelector);
                panel.add(message2);
                panel.add(updateSelector);
                mainFrame.getContentPane().removeAll(); // remove all components on the frame before adding JTable
                mainFrame.add(panel); // add JTable to mainFrame
                mainFrame.setVisible(true); // displays frame on dialog display
                statement.close(); // close connection to the database
                

            } catch (SQLException ex) {
                // TODO Auto-generated catch block
                ex.printStackTrace();
            }

        }

    }

    // method that closes all dialog GUI boxes
    private void closeAllDialogs() {
        Window[] windows = getWindows();

        for (Window window : windows) {
            if (window instanceof JFrame) {
                window.dispose();
            }
        }
    }

}
