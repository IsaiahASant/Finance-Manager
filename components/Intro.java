package components;

import javax.swing.*;
import java.awt.*;

public class Intro extends Thread{
    private static final ColorTheme COLOR_THEME = new ColorTheme();
    private final JFrame frame;

    public Intro(JFrame frame){
        this.frame = frame;
    }

    @Override
    public void run() {
        JPanel splash = new JPanel(new BorderLayout());
        splash.setBackground(new ColorTheme().PRIMARY);
    
        JLabel welcome = new JLabel("Welcome", SwingConstants.CENTER);
        welcome.setFont(new Font("Arial", Font.BOLD, 48));
        welcome.setForeground(Color.WHITE);
        splash.add(welcome, BorderLayout.CENTER);
    
        // Show splash
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame.add(splash);
                frame.revalidate();
            }
        });
    
        // Hold for 2 seconds
        try { Thread.sleep(2000); } catch (InterruptedException ignored) {}
    
        // Swap splash out, add Root in
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame.remove(splash);
                frame.add(new Root());
                frame.revalidate();
                frame.repaint();
            }
        });
    }


}
