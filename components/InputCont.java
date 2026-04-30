package components;
import backend.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Date;

/**
 * This is an interactive conatiner where it prompts
 * users to put in transaction input or not
 * @author Isaiah Santamaria
 * @version 4/19/2026
 */
public class InputCont extends JPanel{
        /** display transaction variables */
        
        /**color Theme Object */
        private static final ColorTheme COLOR_THEME = new ColorTheme();

        /** Buttons components */
        public JButton income_btn;
        public JButton expense_btn;
        public JButton submit = new JButton("Submit");

        /**Amount that is used for income or expense */
        public JSpinner amount = new JSpinner(new SpinnerNumberModel(0.0,0.00, Double.MAX_VALUE,1));;

        // near your other field declarations
        public JSpinner dateSpinner = new JSpinner(new SpinnerDateModel());

        /** text field for reasoning */
        public JTextField reason = new JTextField(20);

        /** text field for reasoning */
        public JTextField items = new JTextField(20);

        /** keeps track of what radio button is being selected for creating income/expense objects */
        private String selectedCategory;

        /** Keeps track of radio button is being selected for creating the object*/
        private String selectedSource;

        /** keeps track of radio button that is being selected for creating the object */
        private String selectedAccount;
        

        /** temporary account list */
        private String [] accountNames = {"Checking","Savings","Joint"};

        /** String */
        private String [] categoryNames = {"Bills", "Shopping", "Groceries"};

        private String [] sourceNames = {"work", "gift", "lottery"};

        /** back end components  */
        TransactionHistory transactionHistory = new TransactionHistory();

        /** References to sibling panels for cross-component updates */
        public RecentTransactionCont recentTransactionCont;
        public AccountsCont accountsCont;

    public InputCont(DefaultTableModel tableModel){ 
        this(tableModel, null, null);
    }

    public InputCont(DefaultTableModel tableModel, RecentTransactionCont recentTransactionCont, AccountsCont accountsCont){
        this.recentTransactionCont = recentTransactionCont;
        this.accountsCont = accountsCont;
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
                    String storedItems = (selectedSource != null) ? selectedSource : "work";
                    String account = (selectedAccount != null) ? selectedAccount : "Checking";
                    Date storedDate = (Date) dateSpinner.getValue();

                    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                    String formattedDate = sdf.format(storedDate);
                    

                    System.out.println("Income Amount: "  + storedAmount);
                    System.out.println("Income Items: "   + storedItems);     
                    System.out.println("Income Account: " + account);
                    System.out.println("Income Date: " + formattedDate);

                    IncomeTransaction income = new IncomeTransaction();
                    transactionHistory.addIncome(income);

                    // Update RecentTransactionCont table
                    if (recentTransactionCont != null) {
                        recentTransactionCont.addIncomeTransaction(storedAmount, account, storedItems);
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
                        transaction = new BillTransaction(storedAmount, storedReason, "Joint Account");

                    }else if(category.equals("Groceries")){
                        transaction = new GroceryTransaction(storedAmount, storedReason, storedDate);

                    }else if(category.equals("Shopping")){
                        transaction = new ShoppingTransaction(storedAmount, storedReason, "Checking Account");

                    }else{
                        transaction = new BillTransaction(storedAmount, storedReason, "Checking Account");
                    }
                    
                    System.out.println("Expense Amount: "  + storedAmount);
                    System.out.println("Expense Items: "   + storedItems);
                    System.out.println("Expense Reason: "  + storedReason);
                    System.out.println("Expense Category: " + category);
                    System.out.println("Date: " + formattedDate);
                    System.out.println("Transaction Object Object: " + transaction);
                    

                    transactionHistory.addExpense(transaction);

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