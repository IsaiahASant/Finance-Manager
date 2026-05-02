package components;
import java.awt.Color; 

/**
 * Defines a centralized color palette used throughout the application UI.
 * 
 * This class provides consistent theming colors for primary UI elements,
 * secondary accents, and transaction highlighting (income and expense).
 * 
 * @author Isaiah Santamaria
 * @version 4/17/2026
 */
public class ColorTheme {

    /** color theme of the application */
    public final Color PRIMARY = new Color(12,21,25);
    public final Color SECONDARY = new Color(22,33,39);
    public final Color TERTIARY = new Color(58,53,52);
    public final Color QUATERNARY = new Color(114, 75,57);
    public final Color QUINARY = new Color(207,157,123);

    /** Colors used to highlight income/expense in transaction table */
    public final Color INCOME = new Color(33 , 234 , 48 );
    public final Color EXPENSE = new Color(235, 44, 22);

    /**
     * Constructs a ColorTheme object.
     * Currently empty since all colors are predefined constants.
     */
    public ColorTheme(){
    }
}