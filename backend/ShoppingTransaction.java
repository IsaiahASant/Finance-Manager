package backend;
import java.util.Date;

/**
 * Represents a shopping transaction that tracks items purchased.
 * This class extends "ExpenseTransaction" and is used to
 * record purchases, including a list of items (such as food or other goods).
 * 
 * @author Sean Powers & Isaiah Santamaria
 * @version Spring 2026
 */
public class ShoppingTransaction extends ExpenseTransaction {
   
    private String reason;
    private double amount;

    //* unique list speficialy for this object */
    private String shoppingList; 

    /**
     * Constructs a ShoppingTransaction with the specified amount, reason, date, and item list.
     *
     * @param amount the total cost of the shopping transaction
     * @param reason the reason or description for the transaction
     * @param date the date the transaction occurred
     * @param items the list of purchased items
     */
    public ShoppingTransaction(double amount, String reason, Date date, String items){
      super(amount, reason,date);
      this.shoppingList = items;
    }

    /**
     * Return formatted string including parent transaction details and shopping type
     * @return formatted string including parent transaction details and shopping type
     */
    @Override
    public String toString(){
        return super.toString() + " ExpenseType:Shopping";
    }

    /**
     * Return a string representing the shopping list
     * @return a string representing the shopping list
     */
    public String getShoppingList(){
        return shoppingList;
    }

    /**
     * return the string "Shopping"
     * @return the string "Shopping"
     */
    public String getType(){
        return "Shopping";
    }
}