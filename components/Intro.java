package components;

import javax.swing.*;
import java.awt.*;
/**
 * displays the intro thread at the start of the application to welcome
 * user
 * @author Isaiah Santamaria
 */
public class Intro extends Thread{
    private static final ColorTheme COLOR_THEME = new ColorTheme();
    private final JFrame frame;

    public Intro(JFrame frame){
        this.frame = frame;
    }

    @Override
    public void run() {
        JPanel cover = new JPanel(new BorderLayout());
        cover.setBackground(new ColorTheme().PRIMARY);
    
        JLabel welcome = new JLabel("Welcome", SwingConstants.CENTER);
        welcome.setFont(new Font("Arial", Font.BOLD, 48));
        welcome.setForeground(Color.WHITE);
        cover.add(welcome, BorderLayout.CENTER);
    
        // Show cover
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame.add(cover);
                frame.revalidate();
            }
        });
    
        // Hold for 2 seconds
        try { Thread.sleep(2000); } catch (InterruptedException ignored) {}
    
        // Swap cover out, add Root in
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame.remove(cover);
                frame.add(new Root());
                frame.revalidate();
                frame.repaint();
            }
        });
    }


}
