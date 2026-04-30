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


    public AccountsChart(){
        setPreferredSize(new Dimension(300, 300));
        setBackground(Color.white);
        setBorder(BorderFactory.createLineBorder(Color.black));
    }
    



}
