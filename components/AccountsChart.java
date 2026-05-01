package components;

import java.awt.*;
import javax.swing.*;

/**
 * Simple line graph to show the Checking, Savings, and Joint balances and changes. 
 * 
 * @author Sean Powers & Hayden Ralston
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

    private boolean running = false;

    public AccountsChart(){
        setPreferredSize(new Dimension(300, 300));
        setBackground(Color.white);
        setBorder(BorderFactory.createLineBorder(Color.black));
    }
    
    public void refreshChart(){
        if (running) return;

        running = true;

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
                break;
            }}
        });
        refreshThread.start();
    }

    public void stopChart() {
        running = false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLUE);
        g.drawString("Checking: " + checkingBalance, 20, 50);

        g.setColor(Color.GREEN);
        g.drawString("Savings: " + savingingsBalance, 20, 100);

        g.setColor(Color.RED);
        g.drawString("Joint: " + JointBalance, 20, 150);
    }
}

