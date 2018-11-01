/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab7;

import java.util.Scanner;

/**
 *
 * @author jalvarez343
 */
public class ArraySearchingAndSorting {

    static Scanner userInput = new Scanner(System.in); // initialize Scanner class object to be used to retrieve user input
    
    static String[] myClientsArray = new String[8]; // initialize and declare array of strings with 8 elements
    
    static int[] myClientNumbers = new int[8]; // initialize and declare array of integers with 8 elements

    // main method begins execution of Java application
    public static void main(String args[]) {

        // populate array of strings at specific indexes
        myClientsArray[0] = "Butler";
        myClientsArray[1] = "Samuels";
        myClientsArray[2] = "Bond";
        myClientsArray[3] = "Chang";
        myClientsArray[4] = "Baker";
        myClientsArray[5] = "Davis";
        myClientsArray[6] = "Zheng";
        myClientsArray[7] = "Joe";

        // populate array of integers at specific indexes
        myClientNumbers[0] = 108;
        myClientNumbers[1] = 121;
        myClientNumbers[2] = 188;
        myClientNumbers[3] = 107;
        myClientNumbers[4] = 122;
        myClientNumbers[5] = 111;
        myClientNumbers[6] = 203;
        myClientNumbers[7] = 135;

        System.out.println("Successfully populated arrays...");

        System.out.printf("--------------------------------------------------------------%n");

        System.out.print("Search client names here: ");

        String input = userInput.nextLine(); // obtain user input

        // execute if the string is length is greater than one
        if (input.length() > 1) {
            String searchQuery = input.substring(0, 1).toUpperCase() + input.substring(1); // initialize and uppercase first character

            System.out.println("Searching for: " + searchQuery + "...");

            strSearch(myClientsArray, searchQuery); // call method that searches for a name in myClientsArray list
        }

        System.out.printf("--------------------------------------------------------------%n");

        System.out.print("Search client numbers here: ");

        int numInput = userInput.nextInt(); // obtain user input

        System.out.println("Searching for: " + numInput + "...");

        intSearch(myClientNumbers, numInput); // call method that searches for a number in myClientNumbers list

        System.out.printf("--------------------------------------------------------------%n");
        
        System.out.println("Successfully populated arrays...");
        
        System.out.printf("--------------------------------------------------------------%n");

        aSort(myClientsArray, myClientNumbers);// call method that sorts both arrays (myClientsArray & myClientNumbers) in parallel
        
        System.out.printf("--------------------------------------------------------------%n");
    }

    // method that linearly searches for an element in myClientsArray list
    public static void strSearch(String strArray[], String item) {
        int i = 0; // initialize for-loop index counter
        int flag = 0; // initialize variable

        // loop that searches each item in array
        for (i = 0; i < 8; i++) {
            // execute if item parameter matches value at specified index in array
            if (item.equals(strArray[i])) {
                flag = 1; // set value to 1
                break; // exit the loop method
            }
        }

        // execute if flag variable value is equal to 1
        if (flag == 1) {
            System.out.println("SUCCESS: Item found at position: " + (i + 1));
            // execute if flag variable value is not equal to 1
        } else {
            System.out.println("ERROR: Item not found! Try again.");
        }
    }

    // method that linearly searches for an element in myClientNumbers list
    public static void intSearch(int intArray[], int number) {
        int i = 0; // initialize for-loop index counter
        int flag = 0; // initialize variable

        // loop that searches each item in array
        for (i = 0; i < 8; i++) {
            // execute if item parameter matches value at specified index array
            if (number == intArray[i]) {
                flag = 1; // set value to 1
                break; // exit the loop method
            }
        }

        // execute if flag variable value is equal to 1
        if (flag == 1) {
            System.out.println("SUCCESS: Number found at position: " + (i + 1));
            // execute if flag variable value is not equal to 1
        } else {
            System.out.println("ERROR: Number not found! Try again.");
        }
    }

    // method that sorts arrays in parallel and displays them to the user
    public static void aSort(String stringArray[], int intArray[]) {
        // perform a bubble sort
        for (int i = 0; i < 7; i++) {
            // Last j elements are already in place 
            for (int j = 0; j < 7 - i; j++) {
                if ((stringArray[j].compareTo(stringArray[j + 1])) > 0) {
                    /* Swap string values if true */
                    String strSwap = stringArray[j];
                    stringArray[j] = stringArray[j + 1];
                    stringArray[j + 1] = strSwap;
                    /* Swap int values if true */
                    int intSwap = intArray[j];
                    intArray[j] = intArray[j + 1];
                    intArray[j + 1] = intSwap;
                }
            }
        }
        
        System.out.printf("%-15s %-15s\n", "Client Name:", "Client Number:");
        
        // loop that displays elements
        for (int i = 0; i < 8; i++) {
           System.out.printf("%-15s %-15s\n", myClientsArray[i], myClientNumbers[i]);
        }

    }
}
