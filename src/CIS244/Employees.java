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
public class Employees {
    
    String name; // initialize employee name variable
    int rank; // initialize employee rank variable
    
    // constructor method
    public Employees(String n, int r) {
        name = n;
        rank = r;
    }
    
    // main method begins execution of Java application
    public static void main(String[] args) {
        
        List<Employees> list = new ArrayList();
        list.add(new Employees("Jose Alvarez", 1));
        list.add(new Employees("James Williams", 3));
        list.add(new Employees("David Hayes", 2));
        list.add(new Employees("Howard Wolowitz", 3));
        
        //Collection.sort(list);
        
        // output the list
        list.stream().filter((e) -> (e.rank == 3)).forEachOrdered((e) -> {
            System.out.println(e.name + " " + e.rank);
        });
        
    }
    
}
