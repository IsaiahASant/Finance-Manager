package components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * Simple bar chart showing Income vs Expense totals.
 * Y-axis fixed from $0 to $10,000.
 *
 * @author Sean Powers & Hayden Ralston & Isaiah
 * @version Spring 2026
 */
public class GraphChart extends JPanel {

    private double incomeTotal;
    private double expenseTotal;

    private static final int MAX_VALUE    = 10000;
    private static final int MARGIN_LEFT  = 70;
    private static final int MARGIN_RIGHT = 30;
    private static final int MARGIN_TOP   = 30;
    private static final int MARGIN_BOTTOM= 50;
    public static final ColorTheme COLOR_THEME = new ColorTheme();

    public GraphChart(double incomeTotal, double expenseTotal) {
        this.incomeTotal  = incomeTotal;
        this.expenseTotal = expenseTotal;
        setPreferredSize(new Dimension(400, 400));
        setBackground(COLOR_THEME.PRIMARY);
        setBorder(BorderFactory.createLineBorder(COLOR_THEME.SECONDARY));
    }

    public void setIncomeTotal(double incomeTotal) {
        this.incomeTotal = incomeTotal;
        repaint();
    }

    public void setExpenseTotal(double expenseTotal) {
        this.expenseTotal = expenseTotal;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width  = getWidth()  - MARGIN_LEFT - MARGIN_RIGHT;
        int height = getHeight() - MARGIN_TOP  - MARGIN_BOTTOM;

        // --- draw Y axis ---
        g.setColor(COLOR_THEME.QUINARY);
        g.drawLine(MARGIN_LEFT, MARGIN_TOP, MARGIN_LEFT, MARGIN_TOP + height);

        // --- draw X axis ---
        g.drawLine(MARGIN_LEFT, MARGIN_TOP + height, MARGIN_LEFT + width, MARGIN_TOP + height);

        // --- Y axis labels and grid lines ($0 to $10,000 in steps of $1,000) ---
        g.setFont(new Font("Arial", Font.PLAIN, 11));
        int steps = 10;
        for (int i = 0; i <= steps; i++) {
            int value = (MAX_VALUE / steps) * i;
            int y = MARGIN_TOP + height - (int)((double) height * i / steps);

            // grid line
            g.setColor(COLOR_THEME.TERTIARY);
           
            g.drawLine(MARGIN_LEFT, y, MARGIN_LEFT + width, y);

            // label
            g.setColor(COLOR_THEME.QUINARY);
            g.drawString("$" + value, 5, y + 5); 
        }

        // --- bar dimensions ---
        int barWidth = width / 5; // each bar takes up 1/5 of the chart width
        int gap = width / 5; // gap between bars

        int incomeX  = MARGIN_LEFT + gap / 2;
        int expenseX = incomeX + barWidth + gap;

        // clamp values so bars never go above the chart
        double incomeClamped  = Math.min(incomeTotal,  MAX_VALUE);
        double expenseClamped = Math.min(expenseTotal, MAX_VALUE);

        int incomeBarHeight  = (int)(height * incomeClamped  / MAX_VALUE);
        int expenseBarHeight = (int)(height * expenseClamped / MAX_VALUE);

        // --- draw income bar (green) ---
        g.setColor(new Color(34, 139, 34)); // forest green
        g.fillRect(incomeX, MARGIN_TOP + height - incomeBarHeight, barWidth, incomeBarHeight);
        

        // --- draw expense bar (red) ---
        g.setColor(new Color(200, 30, 30)); // dark red
        g.fillRect(expenseX, MARGIN_TOP + height - expenseBarHeight, barWidth, expenseBarHeight);

        // --- bar labels ---
        g.setFont(new Font("Arial", Font.BOLD, 12));
        g.setColor(COLOR_THEME.QUINARY);

        // "Income" label
        int incomeLabelX = incomeX + barWidth / 2 - g.getFontMetrics().stringWidth("Income") / 2;
        g.drawString("Income", incomeLabelX, MARGIN_TOP + height + 20);

        // "Expense" label
        int expenseLabelX = expenseX + barWidth / 2 - g.getFontMetrics().stringWidth("Expense") / 2;
        g.drawString("Expense", expenseLabelX, MARGIN_TOP + height + 20);

        // --- value above each bar ---
        g.setFont(new Font("Arial", Font.PLAIN, 11));
        g.drawString("$" + (int) incomeTotal,  incomeX,  MARGIN_TOP + height - incomeBarHeight  - 5);
        g.drawString("$" + (int) expenseTotal, expenseX, MARGIN_TOP + height - expenseBarHeight - 5);

        // --- title ---
        g.setFont(new Font("Arial", Font.BOLD, 14));
        int titleX = MARGIN_LEFT + width / 2 - g.getFontMetrics().stringWidth("Income vs Expense") / 2;
        g.drawString("Income vs Expense", titleX, MARGIN_TOP - 10);
    }


    
}