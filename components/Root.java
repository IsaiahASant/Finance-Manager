package components;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
    public JButton graphButton = new JButton("Print");
    public JTable table = new JTable();

    /** needed to keep track of transactionCont, needs to reference back to pointer */
    public DefaultTableModel tableModel = new DefaultTableModel(0, 0); ;
    

    /** used for coloring */
    public static final ColorTheme COLOR_THEME = new ColorTheme();

    /** this will be use to keep track how much expense and income will be displayed in graph */
    private TotalTransaction totalTransaction = new TotalTransaction();

    public Root(){
        
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(0, 40, 40, 40)); // makes Root have auto padding
        setBackground(COLOR_THEME.PRIMARY);
        
        

        /**
         *  This action listener is used to start a new JFrame with the char
        */
        graphButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                JFrame secondFrame = new JFrame("Second Window");
                secondFrame.setSize(600, 400);
                secondFrame.setResizable(false);
                //sets up the graph
                secondFrame.add(new GraphChart(totalTransaction.getIncome(),totalTransaction.getExpense()));

                secondFrame.setVisible(true);
                System.out.println("Income btn Clicked in root !");
                
            }
        });


        recentTransaction = new RecentTransactionCont(graphButton, tableModel); 
        BANNER = new Banner();
        /** tableModel will be used to update TableCont and totalTransaction will be used to update graph */
        inputCont = new InputCont(tableModel,totalTransaction);
        accountsCont = new AccountsCont();

        // Inject sibling references into InputCont so it can update the other panels on submit
        inputCont.recentTransactionCont = recentTransaction;
        inputCont.accountsCont = accountsCont;
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