import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;




/**
 * This is an interactive conatiner where it prompts
 * users to put in transaction input or not
 * @author Isaiah Santamaria
 * @version 4/19/2026
 */
public class InputCont extends JPanel{
        /** display transaction variables */
        private JTable table;
        private DefaultTableModel tableModel;
        private JButton print_csv_btn;
        /**color Theme Object */
        private static final ColorTheme COLOR_THEME = new ColorTheme();
        private JButton income_btn;
        private JButton expense_btn;

    public InputCont(){ 
        setOpaque(false);
        setPreferredSize(new Dimension(350, 400));
        //setLayout(new GridBagLayout()); //helps center components automaticallly
    
        /**Styling Buttons */
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
                System.out.println("Income btn Clicked!");
            }
        });

        expense_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
     * displays the income inputs
     */
    private void displayIncome(){

    }

    /**
     * display expense income
     */
    private void displayExpense(){

    }

    /**
     * display options inputs
     */
    private void displayOptions(){
        setLayout(new GridBagLayout());

        add(new JContainer(){{
            add(income_btn);
            add(expense_btn);  
        }});
        

    }

}
