package components;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.*;

/**
 * A UI banner component displayed at the top of the application.
 * It contains the application title, credits label, and a logo icon.
 * 
 * This class is responsible for styling and arranging the header section
 * of the Personal Finance Tracker interface.
 * 
 * @author Isaiah Santamaria
 * @version 4/19/2026
 */
public class Banner extends JPanel{
    private JLabel title = new JLabel("Personal Fiance Tracker"); 
    private JLabel creds = new JLabel("Software Security");
    //private JLabel displayIcon;
    private ImageIcon icon = new ImageIcon("icon.png");

    private JLabel logoCont;
    

    /**
     * Constructs the Banner panel, initializes UI components,
     * applies styling, and arranges layout for the header section.
     */
    public Banner(){
        setLayout(new BorderLayout());
        setBackground(new ColorTheme().SECONDARY);
        //setPreferredSize(new Dimension(100,getHeight()));
       

        /************** Styling and intilizing components ***********/

        //title 
        title.setFont(new Font("Serif", Font.BOLD, 28));
        title.setForeground(new ColorTheme().QUINARY);
        creds.setFont(new Font("Serif", Font.BOLD, 13));
        creds.setForeground(new ColorTheme().QUATERNARY);

        /** adding components to main Container */
        add(new JPanel(){{
            setOpaque(false);
            setLayout(new BorderLayout());
            add(title, "North");
            add(creds, "South");
        }}, "West");

        //add(logoCont, "East");

        setVisible(true);
    }
}