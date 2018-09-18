/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileSer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 *
 * @author jalvarez343
 */
public class TestSer { 
public static void printdata(Emp object1) { 

		System.out.println("name = " + object1.getName()); 
		System.out.println("age = " + object1.getAge()); 
} 

public static void main(String[] args)  { 
		Emp object = new Emp("Jose Alvarez", 19); 
		String filename = "emp.txt"; 

		// Serialization 
		try { 
			// Saving of object in a file 
			FileOutputStream file = new FileOutputStream (filename); 
			ObjectOutputStream out = new ObjectOutputStream (file); 

			// Method for serialization of object 
			out.writeObject(object); 

			out.close(); 
			file.close(); 

			System.out.println("Object has been serialized\n"
					 + "Data before Deserialization."); 
			printdata(object); 

			// value of static variable changed 
			object.setAge(21); 
		} 

		catch (IOException ex) { 
			System.out.println("IOException is caught"); 
		} 

		object = null; 

		// Deserialization 
		try { 

			// Reading the object from a file 
			FileInputStream file = new FileInputStream (filename); 
			ObjectInputStream in = new ObjectInputStream (file); 

			// Method for deserialization of object 
			object = (Emp)in.readObject(); 

			in.close(); 
			file.close(); 
			System.out.println("Object has been deserialized\n" +
				           "Data after Deserialization."); 
			printdata(object); 

		} 
		catch (IOException ex) { 
			System.out.println("IOException is caught"); 
		} 
                // 
		catch (ClassNotFoundException ex) { 
			System.out.println("ClassNotFoundException is caught"); 
		} 
	} 
} 

