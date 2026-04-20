
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class UITester extends JFrame {
    public RecentTransaction rTCont;
    public InputCont inputCont;
    public AccountsCont AcntCont;
    public ContentCont content;

    public UITester(){
        setTitle("Personal Finance Tacker by Software security");
        setSize(1500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(new ColorTheme().PRIMARY);

        add(new Root());
        
        setVisible(true);

    }

    public static void main(String [] args){
        new UITester();
    }

    
    


    
}
