package components;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 * JFrame that displays everything
 * the only thing that should be touched in class is the 
 * set size method in line 17, otherwise leave everything else alone
 * @author Isaiah Santamaria 
 * @version 4/19/2026
 */
public class UITester extends JFrame {

    public UITester(){
        setTitle("Personal Finance Tacker by Software security");
        setSize(850,700);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(new ColorTheme().PRIMARY);
        
        add(new Root());
        
        setVisible(true);
    }

    public static void main(String [] args){
        new UITester();
    }

    
    


    
}
