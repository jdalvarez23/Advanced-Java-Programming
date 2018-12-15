/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CIS244;

import java.text.NumberFormat;
import java.util.Scanner;

/**
 *
 * @author jdalv
 */
public class Lab2 {

    // main method begins execution of Java application
    public static void main(String[] args) {
        // create a Scanner to obtain input from the command window
        Scanner input = new Scanner(System.in);

        // declare an object that will display two decimal digits
        NumberFormat nf = NumberFormat.getCurrencyInstance();

        // initialization phase
        String employeeName, payType; // initialize string type variables
        int numItems = 0; // initialize integer type variable
        double ratePerItem = 0; // initialize double type variable
        double grossPay = 0; // initialize double type variable
        double netPay = 0; // initialize double type variable
        double medicareRate = 0.0145; // initialize double type variable
        double ficaRate = 0.0620; // initialize double type variable
        double federalTaxRate = 0.25; // initialize double type variable

        // process phase
        System.out.print("Employee name: ");
        employeeName = input.nextLine(); // sets value to name obtained from input

        System.out.print("Number of items produced: ");
        numItems = input.nextInt(); // sets value to number obtained from input

        input.nextLine();  // Consume newline left-over

        System.out.print("Type of pay (flat or differential): ");
        payType = input.nextLine(); // sets value to pay type obtained from input

        // calculate net pay
        // execute if pay type is flat
        if (payType.equals("flat")) {
            ratePerItem = 7.50; // declare pay rate per item

            grossPay = (double) numItems * ratePerItem; // calculate net pay by multiplying number of items by rate per item price
            // execute if pay type is not flat (assuming it is "differential")
        } else {
            // execute if the items produced are between 001 and 112
            if ((numItems > 0) && (numItems <= 112)) {
                ratePerItem = 7.15; // declare pay rate per item
                // execute if the items produced are between 113 and 150
            } else if ((numItems > 112) && (numItems <= 150)) {
                ratePerItem = 7.45; // declare pay rate per item
                // execute if the items produced are between 151 and 217
            } else if ((numItems > 150) && (numItems <= 217)) {
                ratePerItem = 7.95; // declare pay rate per item
                // execute if the items produced are over 217
            } else {
                ratePerItem = 8.40; // declare pay rate per item
            }

            System.out.println("Pay Rate: " + ratePerItem);
            grossPay = (double) numItems * ratePerItem; // calculate net pay by multiplying number of items by rate per item price
        }

        // calculate net pay (with tax deductions)
        double taxDeduction = (grossPay * medicareRate) + (grossPay * ficaRate) + (grossPay * federalTaxRate); // initialize and set variable to total tax deduction calculation

        netPay = grossPay - taxDeduction; // set value to calculation of gross pay minus tax deductions

        // display information
        System.out.printf("%nProcessing employee data...%n");
        System.out.printf("-------------------------------------%n");
        System.out.printf("Employee Name: %s%n", employeeName);
        System.out.printf("Units Produced: %d%n", numItems);
        System.out.printf("Type of Pay Schedule: %s%n", payType);
        System.out.printf("-------------------------------------%n");
        System.out.println("Gross Pay (without tax deduction): " + nf.format(grossPay));
        System.out.println("Taxes: " + nf.format(taxDeduction));
        System.out.println("Net Pay (with tax deduction): " + nf.format(netPay));
    }
}
