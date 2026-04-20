
import java.awt.BorderLayout;
import javax.swing.*;

/**
 * main container of root
 * @author Isaiah Santamaria
 * @version 4/16/2025
 */
public class Root extends JPanel {
    public RecentTransaction rTCont;
    public InputCont inputCont;
    public AccountsCont AcntCont;
    public ContentCont content;
    public static final ColorTheme COLOR_THEME = new ColorTheme();
    public Root(){
        setLayout(new BorderLayout());
        //setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40)); // makes Root have auto padding
        setBackground(COLOR_THEME.PRIMARY);
        setSize(1500,500);


        JPanel bottomPanel = new JPanel();
     
        add(new Banner(), BorderLayout.NORTH);

        //add(bottomPanel, BorderLayout.CENTER); // stretches to fill remaining space

        
        
        
        
        
        setVisible(true);
        
    }

    public static void main(String []args){
        new Root();
    }

    
}
