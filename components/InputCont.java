package components;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import backend.*;

/**
 * This is an interactive conatiner where it prompts
 * users to put in transaction input or not
 * @author Isaiah Santamaria
 * @version 4/19/2026
 */
public class InputCont extends JPanel{
    /** Display transaction variables */
    /** Color theme object used for UI styling */
    private static final ColorTheme COLOR_THEME = new ColorTheme();

    /** Button components used to select transaction type */
    public JButton income_btn;
    public JButton expense_btn;
    public JButton submit = new JButton("Submit");

    /** Amount used for income or expense transactions */
    public JSpinner amount = new JSpinner(new SpinnerNumberModel(0.0,0.00, Double.MAX_VALUE,1));;

    /** Date selector for transaction input */
    public JSpinner dateSpinner = new JSpinner(new SpinnerDateModel());

    /** Text field used to enter the transaction reason/description */
    public JTextField reason = new JTextField(20);

    /** Text field used to enter item details (shopping/grocery transactions) */
    public JTextField items = new JTextField(20);

    /** Tracks the selected category from radio button options */
    private String selectedCategory;

    /** Tracks the selected income source from radio buttons */
    private String selectedSource;

    /** Tracks the selected account from radio buttons */
    private String selectedAccount;

    /** Available account names used in selection UI */
    private String [] accountNames = {"Checking","Savings","Joint"};

    /** Available transaction categories used in selection UI */
    private String [] categoryNames = {"Bills", "Shopping", "Groceries"};

    /** Available income sources used in selection UI */
    private String [] sourceNames = {"work", "gift", "lottery"};

    /** Backend transaction history manager */
    TransactionHistory transactionHistory = new TransactionHistory();

    /** Reference to recent transaction panel for UI updates */
    public RecentTransactionCont recentTransactionCont;

    /** Reference to accounts panel for balance updates */
    public AccountsCont accountsCont;

    /** Reference to total transaction panel for summary display */
    TotalTransaction totalTransaction;
       

    public InputCont(DefaultTableModel tableModel, TotalTransaction totalTransaction){ 
        this(tableModel, null, null, totalTransaction);
    }

    public InputCont(DefaultTableModel tableModel, RecentTransactionCont recentTransactionCont, AccountsCont accountsCont, TotalTransaction totalTransaction){
        this.recentTransactionCont = recentTransactionCont;
        this.accountsCont = accountsCont;
        this.totalTransaction = totalTransaction;
        setOpaque(false);
        setPreferredSize(new Dimension(350, 400));
        //setLayout(new GridBagLayout()); //helps center components automaticallly
    
        /** Styling Buttons */
        income_btn = new JButton("Income"){{
            setPreferredSize(new Dimension(100,50));
            setBackground(COLOR_THEME.QUATERNARY);
            setForeground(COLOR_THEME.PRIMARY);
        }};
        expense_btn = new JButton("Expense"){{
            setPreferredSize(new Dimension(100,50));
            setBackground(COLOR_THEME.QUATERNARY);
            setForeground(COLOR_THEME.PRIMARY);
        }};

        /**adding interactive buttons */
        income_btn.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                displayIncome();
                System.out.println("Income btn Clicked!");
            }
        });

        expense_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayExpense();
                System.out.println("expense btn Clicked!");
            }
        });
        
        displayOptions();

        setVisible(true);
    }


    
    /**
     * 
     * makes components rounded corners
     * copied code from Stack Overflow
     */
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        // Smooth edges
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // Set color BEFORE drawing
        g2.setColor(COLOR_THEME.SECONDARY);
        // fillRoundRect paints the background — drawRoundRect only draws the outline
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 50, 50);
    }
    
    /**
     * displays the income inputs, when
     * submit button is clicked, it goes back to the 
     * menu options
     */
    private void displayIncome(){
        clearPanel();
        setLayout(new GridLayout(7,1));
        setBorder(BorderFactory.createEmptyBorder(0,20,40,20)); //10 pixels of padding in each side of container

        add(new JLabel("Income Transaction"){{
            setFont(new Font("Brush Script MT", Font.PLAIN, 20));
            setForeground(COLOR_THEME.QUINARY);

        }});

        add(new JContainer(){{
            
            amount.setPreferredSize(new Dimension(100,25));
            add(new JLabel("Amount: "){{
                setFont(new Font("Serif", Font.BOLD, 16));
                setForeground(COLOR_THEME.QUINARY);
            }});
               
            add(amount);
            
        }});
        /****************Radio section that currently has a problem */
        add(new JContainer(){{
            amount.setPreferredSize(new Dimension(100,25));
            add(new JLabel("Account: "){{
                setFont(new Font("Serif", Font.BOLD, 16));
                setForeground(COLOR_THEME.QUINARY);
            }});
            //add(amount);
            /** expresses all the choice you get from the category {checking, Savings, Joint}*/
            add(new JComponent(){{
                setLayout(new FlowLayout());
                ButtonGroup group = new ButtonGroup(); //prevents from more that one radio is being selected
                for(String str : accountNames){
                    JRadioButton radio = new JRadioButton(str);
                    group.add(radio);
                    radio.addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e){
                            selectedAccount = str;
                            System.out.println("Selcted radio: " + selectedAccount);
                            System.out.println(str + " Button is pressed: ");

                        }
                    });

                    add(radio);
                }
            }});
            
            
        }});
        /***** Getting the Source*/
        add(new JContainer(){{
            
            amount.setPreferredSize(new Dimension(100,25));
            add(new JLabel("Source: "){{
                setFont(new Font("Serif", Font.BOLD, 16));
                setForeground(COLOR_THEME.QUINARY);
            }});
           
            ///add(items);
            add(new JComponent(){{
                setLayout(new FlowLayout());
                ButtonGroup group = new ButtonGroup(); //prevents from more that one radio is being selected
                for(String str : sourceNames){
                    JRadioButton radio = new JRadioButton(str);
                    group.add(radio);
                    radio.addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e){
                            selectedSource = str;
                            //selectedCategory = str;
                            System.out.println("Selcted source radio: " + selectedSource);
                            System.out.println(str + " Button is pressed: ");

                        }
                    });

                    add(radio);
                }
            }});
            
            
        }});

        add(new JContainer(){{
            add(new JLabel("Date: "){{
                setFont(new Font("Serif", Font.BOLD, 16));
                setForeground(COLOR_THEME.QUINARY);
            }});
            JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "MM/dd/yyyy");
            dateSpinner.setEditor(dateEditor);
            dateSpinner.setPreferredSize(new Dimension(120, 25));
            add(dateSpinner);
        }});

        add(new JContainer(){{
            
            // Remove any previously attached listeners to prevent duplicate firings
            for (ActionListener al : submit.getActionListeners()) {
                submit.removeActionListener(al);
            }

            // income transaction action listener
            submit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Double storedAmount = Double.parseDouble(amount.getValue().toString());
                    String storedSource = (selectedSource != null) ? selectedSource : "work";
                    String account = (selectedAccount != null) ? selectedAccount : "Checking";
                    Date storedDate = (Date) dateSpinner.getValue();

                    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                    String formattedDate = sdf.format(storedDate);
                    

                    System.out.println("Income Amount: "  + storedAmount);
                    System.out.println("Income Items: "   + storedSource);     
                    System.out.println("Income Account: " + account);
                    System.out.println("Income Date: " + formattedDate);

                    IncomeTransaction income = new IncomeTransaction(storedAmount, storedSource, account, storedDate);

                    totalTransaction.addIncome(storedAmount); // will be used to store amount 
                    transactionHistory.addIncome(income); // added for graph

                    // Update RecentTransactionCont table
                    if (recentTransactionCont != null) {
                        recentTransactionCont.addIncomeTransaction(storedAmount, account, storedSource);
                    }

                    // Update AccountsCont balance
                    if (accountsCont != null) {
                        accountsCont.updateBalance(account, storedAmount);
                    }

                    System.out.println("Income Object: " + income);
                    clearInputs();
                    displayOptions();
                    System.out.println("submit income btn Clicked!");
                }
            });          
            add(submit);         
        }});

        

    }

    /**
     * display expense transaction inputs
     * when submit button is clicked, it goes back to menu 
     * options
     */
    private void displayExpense(){       
        clearPanel();
        setLayout(new GridLayout(7,1));
        setBorder(BorderFactory.createEmptyBorder(0,10,10,10)); //10 pixels of padding in each side of container

        add(new JLabel("Expense Transaction\\"){{
            setFont(new Font("Brush Script MT", Font.PLAIN, 20));
            setForeground(COLOR_THEME.QUINARY);

        }});

        add(new JContainer(){{    
            amount.setPreferredSize(new Dimension(100,25));
            add(new JLabel("Amount: "){{
                setFont(new Font("Serif", Font.BOLD, 16));
                setForeground(COLOR_THEME.QUINARY);
            }});
                
            add(amount);    
        }});
        
        /****************Radio section that currently has a problem */
        add(new JContainer(){{
            amount.setPreferredSize(new Dimension(100,25));
            add(new JLabel("Category: "){{
                setFont(new Font("Serif", Font.BOLD, 16));
                setForeground(COLOR_THEME.QUINARY);
            }});
            //add(amount);

            add(new JComponent(){{
                setLayout(new FlowLayout());
                ButtonGroup group = new ButtonGroup(); //prevents more that one button is being clicked


                for(String str : categoryNames){
                    JRadioButton radio = new JRadioButton(str);
                    group.add(radio);
                    radio.addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e){
                            selectedCategory = str;
                            System.out.println("Selcted radio: " + selectedCategory);
                            System.out.println(str + " Button is pressed");
                        }
                    });

                    add(radio);
                }
            }});
            
            
        }});
        /****************Radio section that currently has a problem */
        add(new JContainer(){{
            
            amount.setPreferredSize(new Dimension(100,25));
            add(new JLabel("Items: "){{
                setFont(new Font("Serif", Font.BOLD, 16));
                setForeground(COLOR_THEME.QUINARY);
            }});
           

            add(items);
            
        }});
        add(new JContainer(){{
            
            amount.setPreferredSize(new Dimension(100,25));
            add(new JLabel("Reason: "){{
                setFont(new Font("Serif", Font.BOLD, 16));
                setForeground(COLOR_THEME.QUINARY);
            }});
            
            add(reason);
            
        }});

        add(new JContainer(){{
            add(new JLabel("Date: "){{
                setFont(new Font("Serif", Font.BOLD, 16));
                setForeground(COLOR_THEME.QUINARY);
            }});
            JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "MM/dd/yyyy");
            dateSpinner.setEditor(dateEditor);
            dateSpinner.setPreferredSize(new Dimension(120, 25));
            add(dateSpinner);
        }});

        


        add(new JContainer(){{
            // Remove any previously attached listeners to prevent duplicate firings
            for (ActionListener al : submit.getActionListeners()) {
                submit.removeActionListener(al);
            }

            submit.addActionListener(new ActionListener() {   
                @Override
                public void actionPerformed(ActionEvent e) {
                    Double storedAmount = Double.parseDouble(amount.getValue().toString());
                    String storedItems = items.getText();
                    String storedReason = reason.getText();
                    String category = (selectedCategory != null) ? selectedCategory : "Others";
                    Date storedDate = (Date) dateSpinner.getValue();

                    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                    String formattedDate = sdf.format(storedDate);

                    Transaction transaction;

                    if(category.equals("Bills")){
                        transaction = new BillTransaction(storedAmount, storedReason, storedDate);

                    }else if(category.equals("Groceries")){
                        transaction = new GroceryTransaction(storedAmount, storedReason, storedDate,storedItems);

                    }else if(category.equals("Shopping")){
                        transaction = new ShoppingTransaction(storedAmount, storedReason, storedDate, storedItems);

                    }else{
                        transaction = new BillTransaction(storedAmount, storedReason, storedDate);
                    }
                    
                    System.out.println("Expense Amount: "  + storedAmount);
                    System.out.println("Expense Items: "   + storedItems);
                    System.out.println("Expense Reason: "  + storedReason);
                    System.out.println("Expense Category: " + category);
                    System.out.println("Date: " + formattedDate);
                    System.out.println("Transaction Object Object: " + transaction);
                    
                    totalTransaction.addExpense(storedAmount); //used to update graph
                    transactionHistory.addExpense(transaction); //used for csv files

                    // Update RecentTransactionCont table
                    if (recentTransactionCont != null) {
                        recentTransactionCont.addExpenseTransaction(storedAmount, category, "Checking", category);
                    }

                    // Update AccountsCont balance (expense = subtract from Checking by default)
                    if (accountsCont != null) {
                        accountsCont.updateBalance("Checking", -storedAmount);
                    }

                    clearInputs();
                    displayOptions();
                    System.out.println("submit expense btn Clicked!");
                }
            });
            
            add(submit);
               
        }});
 
    }




    /**
     * clears main panel
     */
    private void clearPanel(){
        removeAll(); //clears all child component
        revalidate(); //tells the layout manager to re-layout
        repaint(); //repaint the panel
    }

    /**
     * display options inputs
     */
    private void displayOptions(){
        clearPanel();
        setLayout(new GridBagLayout());

        add(new JContainer(){{
            add(income_btn);
            add(expense_btn);  
        }});
        

    }

    private void clearInputs(){
        items.setText("");
        reason.setText("");
        amount.setValue(1.0);
    }
    

}