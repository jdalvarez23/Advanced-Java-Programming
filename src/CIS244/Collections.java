/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CIS244;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author jalvarez343
 */
public class Collections {
    // main method begins execution of Java application
    public static void main(String args[]) {
        // create an array of strings
        String a[] = new String[]{"abc", "klm", "xyz", "pqr"};
        String a2[] = new String[]{"abc", "klm", "xyz", "pqr"};
        ArrayList<String> list1 = new ArrayList<>();
        list1.addAll(Arrays.asList(a));
        list1.addAll(Arrays.asList(a2));
        // printing the list
        System.out.println("The list is:" + list1.size());
        int count = 0;
        for (String s : list1) {
            System.out.println(++count + " " + s);
        }
    }
}
