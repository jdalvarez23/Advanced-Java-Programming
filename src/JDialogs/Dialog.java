/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDialogs;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author jalvarez343
 */
public class Dialog extends JDialog {
    public Dialog(){
        super();
        JPanel panel=new JPanel();
        panel.add(new JLabel("Hello dialog"));
        this.getContentPane().add(panel);
        
         
    }
    
    public Dialog(MainFrame mf,String title,boolean modal){
        super(mf,title,modal);
        this.setSize(400,300);
        this.setLocationRelativeTo(null);
        JPanel panel=new JPanel();
        panel.add(new JLabel("Hello dialog"));
        this.getContentPane().add(panel);
        this.setVisible(true);
        
    }
}
