import components.*;
import javax.swing.*;
/**
 * This is the FinaceManger tracker that keeps track of your expense
 * and income transaction ID, reason and more and incorporate that information 
 * and stores in a CSV files and used to also display graphs
 * @author Isaiah Santamaria, Sean Powers, Hayden
 * @version 5/1/2026
 */
public class FinanceManager extends JFrame {

    public FinanceManager(){
        setTitle("Personal Finance Tacker by Software Security");
        setSize(850,700);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(new ColorTheme().PRIMARY);

        setVisible(true);
        //adds JFrame
        new Intro(this).start();
    }

    public static void main(String [] args){
        new FinanceManager();   
    }
    
}
