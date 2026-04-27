import components.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class FinanceManager extends JFrame {

    public FinanceManager(){
        setTitle("Personal Finance Tacker by Software Security");
        setSize(850,700);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(new ColorTheme().PRIMARY);
        
        add(new Root());

        setVisible(true);
    }

    public static void main(String [] args){
        new UITester();

        
    }
    
}
