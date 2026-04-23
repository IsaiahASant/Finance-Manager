package UserInterface;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import backend.ExpenseTransaction;

/**
 * main container of root
 * actionlistener for each buttons will be put HERE
 * 
 * big highlighted comments are the code you uys will be working with
 * @author Isaiah Santamaria
 * @version 4/16/2025
 */
public class Root extends JPanel {
    public RecentTransactionCont recentTransaction;
    public Banner BANNER;
    public InputCont inputCont;
    public AccountsCont accountsCont;
    public JContainer contentCont;

    /** setting up buttons to be mainupliated here */
    JButton csvButton = new JButton("Print");
    

    /** Temporary holder for transaction */
    


    public static final ColorTheme COLOR_THEME = new ColorTheme();
    public Root(){
        
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(0, 40, 40, 40)); // makes Root have auto padding
        setBackground(COLOR_THEME.PRIMARY);
        


        /**
         *  ACTION LISTENER FOR csvButton, needs to capabilities to interpet and make a csv
         * file of the Database/array
        */
        csvButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ExpenseTransaction transaction = new ExpenseTransaction();
                System.out.println("Income btn Clicked in root !");
            }
        });




        recentTransaction = new RecentTransactionCont(csvButton); 
        BANNER = new Banner();
        inputCont = new InputCont();
        accountsCont = new AccountsCont();
        setBackground(COLOR_THEME.PRIMARY);

        contentCont = new JContainer(); //in charge of hosting rest of content
     
        contentCont.setLayout(new BorderLayout());
        contentCont.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); //giving padding
        contentCont.add(inputCont,"West");
        contentCont.add(recentTransaction, "East");




        /** adding components to main JPanel */
        add(new JContainer(){{
            
            setLayout(new BorderLayout());
            add(BANNER, "North");
            
            add(accountsCont, "South");
        }}, BorderLayout.NORTH);

        
        add(contentCont, BorderLayout.CENTER); // stretches to fill remaining space

        
        
        
        
        
        setVisible(true);
        
    }

    public static void main(String []args){
        new Root();
    }

    
}
