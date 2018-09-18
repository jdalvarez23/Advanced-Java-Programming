/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileSer;

// Java code for serialization and deserialization of a Java object 
import java.io.*; 
/**
 *
 * @author jalvarez343
 */

class Emp implements Serializable { 
//private static final long serialversionUID = 129348938L;  //optional

	private String name; 
	// transient definition:
        private static transient int age;
        
	// Default constructor 
        public Emp(String name, int age)  { 
		this.name = name; 
		this.age = age; 
	} 

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the age
     */
    public static int getAge() {
        return age;
    }

    /**
     * @param aAge the age to set
     */
    public static void setAge(int aAge) {
        age = aAge;
    }
}

