/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDialogs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author jalvarez343
 */
public class MainFrame extends JFrame {
    public MainFrame(){
        this.setTitle("Dialog demo");
        this.setSize(400,300);
        this.setLocationRelativeTo(null);
        
        JPanel panel=new JPanel();
        JButton btn=new JButton("Open dialog");
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                new Dialog(MainFrame.this,"Hello",true);
                System.exit(1);
            }
        });
        panel.add(btn);
        this.getContentPane().add(panel);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args){
        new MainFrame().setVisible(true);
    }
}
