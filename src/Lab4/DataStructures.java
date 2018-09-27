/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab4;

import java.util.Scanner;
import java.io.*;

/**
 *
 * @author jalvarez343
 */
public class DataStructures {

    // main method begins execution of Java application
    public static void main(String args[]) throws IOException {
        Scanner scan = new Scanner(System.in); // declare a Scanner class object

        // initialization phase
        String myFile = "src/Lab4/data.txt"; // initialize and declare file path variable
        FileWriter file = new FileWriter(myFile); // initialize and declare input file object
        PrintWriter outFile = new PrintWriter(myFile); // initialize and declare outfile file object
        int numRecords = 0; // initialize variable for the number of records in the file
        String strName = ""; // initialize variable for name field of data table
        double dblCost = 0; // initialize variable for cost field of data table
        int intQuantity = 0; // initialize variable for quantity field of data table
        char chrLocation = '\0'; // initialize variable for location field of data table

        // processing phase
        System.out.print("How many records are for processing? Answer: "); // display that asks user for number of records to be processed
        numRecords = scan.nextInt(); // input the number of records to be processed
        System.out.printf("%n");

        // loop to process records in data table file
        for (int i = 0; i < numRecords; i++) {

            // obtain user input
            System.out.print("Enter item description: ");
            scan.nextLine();
            strName = scan.nextLine();
            System.out.print("Enter item cost: $");
            dblCost = scan.nextDouble();
            System.out.print("Enter item quantity: ");
            intQuantity = scan.nextInt();
            System.out.print("Enter item location code: ");
            chrLocation = scan.next().charAt(0);

            System.out.printf("%n"); // display an empty line

            // write the data to the file
            outFile.print(strName + ",");
            outFile.print(dblCost + ",");
            outFile.print(intQuantity + ",");
            outFile.println(chrLocation);
        }

        scan.close(); // close connection to the scanner
        file.close(); // close connection to the input file
        outFile.close(); // close connection to the output file

        // declare the file objects
        String line = ""; // initialize variable for file line
        String csv = ","; // initialize and declare variable for split method delimeters
        FileReader fileIn = new FileReader(myFile); // initialize and declare input file object
        BufferedReader br = new BufferedReader(fileIn); // initialize and declare file reader object

        try {
            System.out.printf("%n--------------------------------------------------------------%n");
            System.out.printf("%-15s %-15s %-15s %-15s\n", "Item", "Cost", "Quantity", "Location Code");
            System.out.println("--------------------------------------------------------------");

            // loop that executes when file line exists
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csv); // initialize and declare array with file data separated at comma
                System.out.printf("%-15s $%-15s %-15s %-15s\n", data[0], data[1], data[2], data[3]);
                System.out.printf("--------------------------------------------------------------%n");
            }
            System.out.printf("%n"); // display an empty line

        } catch (IOException e) {
            e.printStackTrace();
        }

        br.close(); // close connection to buffered reader
    }

}
