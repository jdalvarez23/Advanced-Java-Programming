/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab6;

import java.util.ArrayList;
import java.util.Iterator;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author jalvarez343
 */
public class ArrayListQueue {

    static ArrayList<String> list = new ArrayList<String>(); // initialize ArrayList-type list
    static StringBuilder sb = new StringBuilder(); // store the queue elements in a StringBuilder object
    static Iterator<String> itr = list.iterator(); // initialize and declare an iterator object
    static Object[] buttonOptions = {"Add customer", "View queue"};

    // main method begins execution of Java application
    public static void main(String args[]) {

        displayMainMenu(); // call method that displays the main menu

    }

    // method that adds an element to the rear of the queue (ArrayList)
    public static void enqueue() {
        JFrame inputDialog = new JFrame("Input Customer Dialog"); // initialize and declare JFrame object

        String customerName = JOptionPane.showInputDialog(inputDialog, "What is the customer name?", "Add customer", JOptionPane.INFORMATION_MESSAGE); // display "add customer" input dialog box
        
        // execute if the customer name is null or empty
        if (customerName == null || (customerName == null && ("".equals(customerName)))) {
            displayMainMenu(); // call method that displays the main menu
        // execute if the customer name is greater than two characters
        } else if (customerName.length() > 2) {
            list.add(customerName); // add customer to list
            displayMainMenu(); // call method that displays the main menu
        }

    }

    // method that removes an element from the front of the queue (ArrayList)
    public static void dequeue() {
        Object obj = new Object(); // initialize and declare object

        // execute if ArrayList size is greater than zero
        if (list.size() > 0) {
            obj = list.remove(0); // set object to element removed from ArrayList
            System.out.println(obj + " is removed from ArrayList");
            // execute if list size is zero
        } else {
            System.out.println("Cannot remove top element because list is empty!");
        }
    }

    // method that determines the element on top of the queue (ArrayList)
    public static String topElement() {
        // execute if ArrayList size is greater than zero
        if (list.size() > 0) {
            String topElement = list.get(0); // initialize and declare string that retrieves top element value
            System.out.println(topElement + " is the next element in line");
            return topElement; // return top element value
            // execute if list size is zero
        } else {
            System.out.println("Cannot retrieve top element because list is empty!");
            return "invalid element"; // return error element value
        }
    }

    // method that determines if the queue (ArrayList) is empty
    public static boolean isEmpty() {
        // execute if ArrayList size is zero
        if (list.size() == 0) {
            System.out.println("The list is empty!");
            return true; // return true
            // execute if ArrayList size is greater than zero
        } else {
            System.out.println("The list is not empty!");
            return false; // return false
        }
    }

    // method that displays main menu message box
    public static void displayMainMenu() {
        JFrame frame = new JFrame("Main Menu Dialog"); // initialize and declare JFrame object

        int result = JOptionPane.showOptionDialog(
                frame,
                "Welcome to ADT Customer Service Queue Operations.\n\nBelow are your options.",
                "ADT Customer Service Main Menu",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                buttonOptions,
                null); // display menu in option dialog box
        
        // execute if user selects the "add customer" option  
        if (result == JOptionPane.YES_OPTION) {
            enqueue(); // call method that displays "add customer" input dialog box
        // execute if user selects the "view queue" option
        } else if (result == JOptionPane.NO_OPTION) {
            displayInformation(); // call method that displays message box with information
        // execute if user exits the main menu box
        } else {
            System.exit(0); // stop the program
        }

    }

    // method that displays information in a message box
    public static void displayInformation() {

        itr = list.iterator(); // initialize and declare an iterator object

        System.out.println("Iterating through elements in ArrayList...");

        // loop that iterates elements in ArrayList
        while (itr.hasNext()) {
            String clientMessage = "• " + itr.next() + "\n";
            sb.append(clientMessage); // append elements to StringBuilder object
        }

        System.out.println("Displaying information in message box...");

        showMessage(); // call method that displays message box
    }

    // method that displays message box with information
    public static void showMessage() {
        Date myDate = new Date(); // initialize and declare date object
        String myDateFormat = "MM/dd/yyyy"; // initialize and declare date format string variable
        SimpleDateFormat dtToday = new SimpleDateFormat(myDateFormat); // initialize and declare formatted date object
        JFrame frame = new JFrame("JOptionPane showMessageDialog example"); // initialize and declare JFrame object
        String titleMessage = "ADT Client Queue - " + dtToday.format(myDate); // initialize titleMessage for prompt box
        int selectedOption = 1; // initialize and declare selectedOption variable

        // execute if queue is not empty
        if (!isEmpty()) {
            selectedOption = JOptionPane.showConfirmDialog(frame, "Customers in queue: \n" + sb + "\n Do you want to serve " + topElement() + "?", titleMessage, JOptionPane.YES_NO_OPTION); // display information in a message box
        // execute if queue is empty
        } else {
            JOptionPane.showMessageDialog(frame, "No more customers in queue!", titleMessage, JOptionPane.ERROR_MESSAGE);
            displayMainMenu(); // call method that displays the main menu
        }

        sb.setLength(0); // clear the StringBuilder object

        // execute if user selects the "yes" option
        if (selectedOption == JOptionPane.YES_OPTION) {
            dequeue(); // call method that removes the top element from the queue
            displayInformation(); // call method that displays the message box
        // execute if user selects the "no" option or exits the message box
        } else {
            displayMainMenu(); // call method that displays the main menu
        }
    }
}
