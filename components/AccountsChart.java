package components;

import java.awt.*;
import javax.swing.*;

/**
 * Simple line graph to show the Checking, Savings, and Joint balances and changes. 
 * 
 * @author Sean Powers
 * @version Spring 2026
 * 
 */

public class AccountsChart extends JPanel{

    //will have to input histories from CSV file


    //amount to display, will have to go back;
    private double checkingBalance;
    private double savingsBalance; 
    private double jointBalance;
    private Thread refreshThread;

    public AccountsChart(){
        setPreferredSize(new Dimension(300, 300));
        setBackground(Color.white);
        setBorder(BorderFactory.createLineBorder(Color.black));
    }
    
    public void refreshChart(){
        boolean running = true;

        refreshThread = new Thread(() -> {
        while (running){
            checkingBalance += 0; //new entryreplace with new data
            savingsBalance += 0; //new entryreplace with new data
            jointBalance += 0; //new entryreplace with new data

            SwingUtilities.invokeLater(() -> {
                repaint();
            });

            try { Thread.sleep(2000);
                
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }}
        });
    }
}

