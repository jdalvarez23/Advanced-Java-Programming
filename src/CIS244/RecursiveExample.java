/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CIS244;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jalvarez343
 */
public class RecursiveExample {
    public static long fibonacci(long n) {
        
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
        
    }
    
    // main method begins execution of Java application
    public static void main(String[] args) {
        
        long preTime = System.currentTimeMillis();
        
        System.out.println("Value of 30th number in fibonacci series --> " + fibonacci(30));
        
        long postTime = System.currentTimeMillis();
        
        System.out.println("Time taken to compute in milliseconds --> " + (postTime - preTime));
        
    }
    
}
