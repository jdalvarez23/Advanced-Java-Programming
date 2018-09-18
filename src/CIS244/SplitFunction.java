/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CIS244;

/**
 *
 * @author jalvarez343
 */
public class SplitFunction {
    public static void main(String[] args) {
        String str = "alpha beta game.gone";
        String[] tokens = str.split(" ");

        // for enhanced to show tokens
        for (String token : tokens) {
            System.out.println(token);
        }

        // standard for loop
        // display the array
        for (int i = 0; i < tokens.length; i++) {
            System.out.println(tokens[i]);
        }
    }
}
