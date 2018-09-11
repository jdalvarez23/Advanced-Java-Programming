/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CIS244;

import java.util.Scanner;

/**
 *
 * @author jalvarez343
 */

/*bypass newline character that is not discarded when reading some input */

public class Skip {
    public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter numerical value");    
		int option;
		option = sc.nextInt(); // Read numerical value from input
		System.out.println("Enter 1st string");
                sc.nextLine();  // Consume newline left-over    
		String string1 = sc.nextLine();  
		System.out.println("Enter 2nd string");
		String string2 = sc.nextLine(); // Read 2nd string (now not skipped)
                
                System.out.println("String 1 " + string1);
		System.out.println("String 2 " + string2);
                
		//or parse data taken in as string!
		System.out.println("Enter numerical value again");
                option = Integer.parseInt(sc.nextLine());
		
		
	}
}
