/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 /*
Description: Game program that uses repetitive control structures to simulate a
*            game play scenerio where the opponents have captured the railway
             transportation system and you are tasked to seize and secure it.
 */
package Lab3;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author jalvarez343
 */
public class SeizeTheStation {

    // main method begins execution of Java application
    public static void main(String args[]) {
        // declare a Scanner class object and Random class object 
        Scanner scan = new Scanner(System.in);
        Random randomGen = new Random();

        int distRemaining = 300; // variable to track distance remaining to target
        int distToMove = 0; // variable to decrease distance to target
        int randInteract = 0; // variable to use to supplement player / game interaction 		  
        char interact = '\0'; // variable to define player obstacle
        char again = '\0'; // variable to allow player to proceed to target
        int goal = 300; // variable to set initial distance to goal
        int health = 100; // variable to set initial player health
        int numAttempts = 0; // variable to track number of attempts to reach goal
        boolean addedCompanion = false; // variable to track if companion is added or not
        int randomDistanceLimit = 0; // variable to set max limit on distance to move forward
        int randomBeginningLimit = 0; // variable to set beginning limit on distance to move forward

        // define a loop for at most twenty actions
        for (int count = 1; count <= 20; count++) {
            // signal the intention of the player
            System.out.println("\n-----------------------------------");
            System.out.println("Are you ready to proceed? ( Y or N )");
            again = scan.next().charAt(0);
            if (again != 'Y') {
                break;
            }

            // execute if the attempt count is greater than 5 and a companion was not added
            if ((count > 5) && (addedCompanion != true)) {
                randInteract = randomGen.nextInt(100);
                // execute if random number is in between 5 and 10
                if (randInteract >= 5 && randInteract <= 10) {
                    addedCompanion = true;
                    System.out.println("\n\nNOTICE: Adding companion to assist you in reaching the goal...");
                }
            } else if ((count > 5) && (addedCompanion == true)) {
                randomDistanceLimit = 100; // set value to 100 (allows "companion" to move forward faster)
                randomBeginningLimit = 50; // set value to 50 (allows "companion" to take more distance
            } else {
                randomDistanceLimit = 20; // set value to default 20
                randomBeginningLimit = 1; // sets value to default 1
            }

            // define an obstacle
            interact = (char) (randomGen.nextInt(26) + 'a');
            if (interact >= 'a' && interact <= 'm') {
                distToMove = randomBeginningLimit + randomGen.nextInt(randomDistanceLimit); // random number sets distance to move toward the objective
                distRemaining -= distToMove; // number sets distance reamining before reaching goal
                System.out.println("\nGOOD! Move forward " + distToMove + " ft");
            } else {
                health -= 10;
                System.out.println("\nMISS! Circumvent the next obstacle");
            }

            numAttempts++; // increment number of attemps to reach goal
            System.out.println("Current health: " + health + "%"); // display health information
            System.out.println("Attemp number: " + count);

            // execute if the health reaches 0
            if (health <= 0) {
                System.out.println("\n\nMission Failed! You lost all your health before reaching the goal.");
                break;
            }

            // execute if the health reaches 0
            if ((distRemaining <= 0) && (health != 0)) {
                System.out.println("\n\nMission Success! You reached the goal.");
                distRemaining = 0;
                break;
            }

            System.out.println("Remaining distance: " + distRemaining + " ft"); // display remaining distance information

        }

        // execute if number of attempts exceeds or meets 20
        if (numAttempts >= 20) {
            System.out.println("\n\nMission Failed! You exceeded the max number of attempts before reaching the goal.");
        }

        // display information
        System.out.printf("%nGame over...%n");
        System.out.printf("%nProcessing gamer data...%n");
        System.out.printf("-----------------------------------%n");
        System.out.println("Number of attemps made: " + numAttempts);
        System.out.println("Current health: " + health + "%");
        System.out.println("Remaining distance: " + distRemaining + " ft");

        addedCompanion = false; // reset boolean value

    }

}
