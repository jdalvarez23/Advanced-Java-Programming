/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileCSV;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author jalvarez343
 */
public class FileCSV {

    // main method begins execution of Java application
    public static void main(String args[]) throws IOException {
        //create rw objects
        BufferedReader in = null;
        BufferedWriter out = null;

        try {
            in = new BufferedReader(new FileReader("src/FileCSV/TSLA.csv"));
            // out = new BufferedWriter(new FileWriter("src/fileio/output.txt"));

            String line = null;
            String[] tokens = null;
            while ((line = in.readLine()) != null) {
                //System.out.println(line);
                tokens = line.split(",");  //use comma delimeter

                //print tokens in a columnar fashion by month, 
                //open price, close price, gain or loss
               
                for (int i = 0; i < tokens.length; i++) {
                    if (i < 4) {
                        System.out.printf("%-15s %-15s %-15s %-15s %-15s\n", tokens[i], tokens[i+1], tokens[i+2] , tokens[i+3], tokens[i+4]);
                    }
                }
                
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

}
