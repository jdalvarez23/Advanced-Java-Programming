/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author jalvarez343
 */
public class ArrayListStack {
    
    static ArrayList<String> list = new ArrayList<String>(); // initialize ArrayList-type list
    static StringBuilder sb = new StringBuilder(); // store the stack elements in a StringBuilder object
    static Iterator<String> itr = list.iterator(); // initialize and declare an iterator object

    // main method begins execution of Java application
    public static void main(String args[]) {

        push("James"); // call method that places an element on stack
        push("Erick"); // call method that places an element on stack
        push("Adam"); // call method that places an element on stack
        push("William"); // call method that places an element on stack
        
        Collections.reverse(list); // reverse element order in ArrayList
        
        displayInformation(); // call method that displays information in message box

    }
    
    // method that places an element on top of the stack (ArrayList)
    public static void push(String clientName) {
        list.add(clientName); // add element to ArrayList
    }
    
    // method that removes the top element from the stack (ArrayList)
    public static void pop() {
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
    
    // method that determines the element on top of the stack (ArrayList)
    public static String top() {
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
    
    // method that determines if the stack (ArrayList) is empty
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
        String titleMessage = "Client Information Folders - " + dtToday.format(myDate); // initialize titleMessage for prompt box
        int selectedOption = 1; // initialize and declare selectedOption variable
        
        // execute if stack is not empty
        if (!isEmpty()) {
            selectedOption = JOptionPane.showConfirmDialog(frame, "Customers in queue: \n" + sb + "\n Do you want to process client " + top() + "?", titleMessage, JOptionPane.YES_NO_OPTION); // display information in a message box
        // execute if stack is empty
        } else {
            JOptionPane.showMessageDialog(frame, "No more customers in queue!", titleMessage, JOptionPane.ERROR_MESSAGE);
        }
        
        
        sb.setLength(0); // clear the StringBuilder object
        
        // execute if user selects the "yes" option
        if (selectedOption == JOptionPane.YES_OPTION) {
            pop(); // call method that removes the top element from the stack
            displayInformation(); // call method that displays information
        }
    }
}
