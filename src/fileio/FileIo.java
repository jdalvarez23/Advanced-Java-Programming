/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileio;

import java.io.*;

/**
 *
 * @author jalvarez343
 */
public class FileIo {

    /**
     * @param args the command line arguments
     */
public static void main(String args[]) throws IOException {  
      //create rw objects
      BufferedReader in = null;
      BufferedWriter out = null;

      try {
         in = new BufferedReader(new FileReader("src/fileio/input.txt"));
         out = new BufferedWriter(new FileWriter("src/fileio/output.txt"));
         
         String line = null;
         String [] tokens = null;
         while ((line = in.readLine()) != null) {
            // write to console
            System.out.println(line);
            tokens = line.split(" ");
            // write to file
            out.write(tokens[0] + "\n" + tokens[1] +"\n");
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
