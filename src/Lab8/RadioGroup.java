/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab8;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author jalvarez343
 */
public class RadioGroup extends JFrame {

    private static final long serialVersionUID = 1L;
    private ButtonGroup group;

    // main method begins execution of Java application
    public static void main(String[] arg) {
        new RadioGroup(1); // call method that creates and displays the radio group dialog GUI
    }

    // method that creates and displays the radio dialog GUI
    public RadioGroup(int task) {
        super("Executive Decision Making Application");

        // Stage 1: Introductory stage of decision-making app
        if (task == 1) {
            // create elements and set their values
            JPanel starterPanel = new JPanel();
            JLabel introductionMessage = new JLabel("Welcome to the Executive Decision Making Application for employees like you!");
            JLabel appDescriptionMessage = new JLabel("This application will help train you, new managers, on how decisions can affect the firm’s stance as a successful enterprise");
            JLabel startMessage = new JLabel("Click the button below to start this journey by opening Door 1.");
            // add elements to the starter panel
            starterPanel.add(introductionMessage);
            starterPanel.add(appDescriptionMessage);
            starterPanel.add(startMessage);
            // add the starter panel to the JFrame
            getContentPane().add(starterPanel, BorderLayout.CENTER);
            // create button element and set its values
            JPanel buttonPanel = new JPanel();
            JButton startButton = new JButton("Start");
            startButton.addActionListener(new ShowDialogListener());
            startButton.addActionListener(e -> this.dispose());
            buttonPanel.add(startButton);
            // add the button panel to the JFrame
            getContentPane().add(buttonPanel, BorderLayout.SOUTH);
            // set JFrame properties
            setSize(800, 150);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setVisible(true);

            // Stage 2: Decision making process of Room A    
        } else if (task == 2) {
            // create elements and set their values
            JPanel radioPanel = new JPanel();
            JLabel descriptionMessage = new JLabel("You are now in Room A. Door 1 has closed forever. Carefully select a door to open.");
            group = new ButtonGroup();
            JRadioButton two = new JRadioButton("Door 2", true);
            JRadioButton seven = new JRadioButton("Door 7");
            JRadioButton six = new JRadioButton("Door 6");
            // set action commands for radio buttons
            two.setActionCommand("2");
            six.setActionCommand("6");
            seven.setActionCommand("7");
            // add button elements to the button group
            group.add(two);
            group.add(six);
            group.add(seven);
            // add elements to the radio panel
            radioPanel.add(descriptionMessage);
            radioPanel.add(two);
            radioPanel.add(six);
            radioPanel.add(seven);
            // add the radio panel to the JFrame
            getContentPane().add(radioPanel, BorderLayout.CENTER);
            // create button element and set its values
            JPanel buttonPanel = new JPanel();
            JButton showDialog = new JButton("Open Door (Room A)");
            showDialog.addActionListener(new ShowDialogListener());
            buttonPanel.add(showDialog);
            // add tge button panel to the JFrame
            getContentPane().add(buttonPanel, BorderLayout.SOUTH);
            // set JFrame properties
            setSize(500, 200);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setVisible(true);

            // Stage 2: Decision making process of Room A   
        } else if (task == 2) {
            // create elements and set their values
            JPanel starterPanel = new JPanel();
            JLabel introductionMessage = new JLabel("Welcome to the Executive Decision Making Application for employees like you!");
            JLabel appDescriptionMessage = new JLabel("This application will help train you, new managers, on how decisions can affect the firm’s stance as a successful enterprise");
            JLabel startMessage = new JLabel("Click the button below to start this journey by opening Door 1.");
            // add elements to the starter panel
            starterPanel.add(introductionMessage);
            starterPanel.add(appDescriptionMessage);
            starterPanel.add(startMessage);
            // add the starter panel to the JFrame
            getContentPane().add(starterPanel, BorderLayout.CENTER);
            // create button element and set its values
            JPanel buttonPanel = new JPanel();
            JButton startButton = new JButton("Start");
            startButton.addActionListener(new ShowDialogListener());
            startButton.addActionListener(e -> this.dispose());
            buttonPanel.add(startButton);
            // add the button panel to the JFrame
            getContentPane().add(buttonPanel, BorderLayout.SOUTH);
            // set JFrame properties
            setSize(800, 150);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setVisible(true);

            // Stage 2: Decision making process of Room A    
        } else if (task == 3) {
            // create elements and set their values
            JPanel radioPanel = new JPanel();
            JLabel descriptionMessage = new JLabel("You are now in Room B. Door 1 & Room A have closed forever. Carefully select a door to open.");
            group = new ButtonGroup();
            JRadioButton three = new JRadioButton("Door 3", true);
            JRadioButton four = new JRadioButton("Door 4");
            JRadioButton five = new JRadioButton("Door 5");
            // set action commands for radio buttons
            three.setActionCommand("3");
            four.setActionCommand("4");
            five.setActionCommand("5");
            // add button elements to the button group
            group.add(three);
            group.add(four);
            group.add(five);
            // add elements to the radio panel
            radioPanel.add(descriptionMessage);
            radioPanel.add(three);
            radioPanel.add(four);
            radioPanel.add(five);
            // add the radio panel to the JFrame
            getContentPane().add(radioPanel, BorderLayout.CENTER);
            // create button element and set its values
            JPanel buttonPanel = new JPanel();
            JButton showDialog = new JButton("Open Door (Room B)");
            showDialog.addActionListener(new ShowDialogListener());
            buttonPanel.add(showDialog);
            // add tge button panel to the JFrame
            getContentPane().add(buttonPanel, BorderLayout.SOUTH);
            // set JFrame properties
            setSize(575, 200);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setVisible(true);
        }
    }

    // method that listens for events from the dialog GUI
    private class ShowDialogListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            String msg1 = "Oops! You have fallen into the clutches of Baron Evil ...";
            String msg2 = "Oh no! You have entered the forbidden abyss ...";
            String msg3 = "Good! You are now entering the mysterious Room B ...";

            String buttonPressed = e.getActionCommand();

            System.out.println(buttonPressed);

            // execute if initial start button is pressed
            if (buttonPressed == "Start") {
                System.out.println("Start button was pressed!"); // log message to the console
                new RadioGroup(2); // call method that creates and displays the radio group dialog GUI 
                // execute if room A button is pressed
            } else if (buttonPressed == "Open Door (Room A)") {

                String door = group.getSelection().getActionCommand(); // initialize and set variable value to selected radio button

                JOptionPane.showMessageDialog(RadioGroup.this,
                        "You are now opening door " + door + " ...");

                if (door == "2") {
                    JOptionPane.showMessageDialog(RadioGroup.this,
                            msg1 + " Game over!");

                } else if (door == "6") {
                    JOptionPane.showMessageDialog(RadioGroup.this,
                            msg2 + " Game over!");

                } else if (door == "7") {
                    JOptionPane.showMessageDialog(RadioGroup.this,
                            msg3 + " Be cautious!");
                    closeAllDialogs();
                    new RadioGroup(3); // call method that creates and displays the radio group dialog GUI 
                    //show or go to panel B
                } else {
                    JOptionPane.showMessageDialog(RadioGroup.this,
                            "Select a door!");
                }
            }
        }
    }

    // method that closes all dialog GUI boxes
    private void closeAllDialogs() {
        Window[] windows = getWindows();

        for (Window window : windows) {
            if (window instanceof JFrame) {
                window.dispose();
            }
        }
    }

}
