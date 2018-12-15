package CIS244;


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jdalv
 */
public class Homework1 {

    public static void main(String[] args) {
        
        StringBuilder sb = new StringBuilder("a toyota");
        sb.insert(2, "landrover");
        sb.delete(11, 16);
        sb.insert(11, " ");
        
        System.out.println(sb);
        
        String r = "a toyota";
        String r1 = r.replace("toyot", "TOYOT");
        
        System.out.println(r1);
        
        String c = "Hello. She sells sea shells";
        int i = c.indexOf("ll");
        int j = c.lastIndexOf("ll");
        
        System.out.println(i);
        System.out.println(j);
        
        String s1 = "art is awesomer!";
        System.out.println(s1.regionMatches(true, 0, "art", 0, 3));
        

    }

}
