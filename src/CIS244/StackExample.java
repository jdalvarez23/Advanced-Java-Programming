/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CIS244;

import java.util.Collections;
import java.util.Stack;

/**
 *
 * @author jalvarez343
 */
public class StackExample {

    // main method begins execution of Java application
    public static void main(String[] args) {
        // Creating a Stack
        Stack<String> list = new Stack<>();

        // Pushing new items to the Stack
        list.push("Jack");
        list.push("Queen");
        list.push("King");
        list.push("Ace");

        Collections.reverse(list); // show as LIFO order
        System.out.println("Original Stack => " + list);

        // Popping items from the Stack
        String cardAtTop = list.remove(0);
        System.out.println("Stack.pop() => " + cardAtTop);
        System.out.println("Current Stack => " + list);
        System.out.println();

        // Get the item at the top of the stack without removing it
        cardAtTop = list.peek();
        System.out.println("Stack.peek() => " + cardAtTop);
    }

}
