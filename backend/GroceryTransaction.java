package backend;

import java.util.Date;

/**
 * Represents a grocery-related expense transaction.
 * Extends "ExpenseTransaction" by adding a grocery list
 * to track purchased items.
 */
public class GroceryTransaction extends ExpenseTransaction {

    /**
     * A string representing the list of grocery items associated with this transaction.
     */
    private String groceryList;

    /**
     * Constructs a new {@code GroceryTransaction} with the specified details.
     *
     * @param amount  the monetary amount of the transaction
     * @param reason  the reason or description for the transaction
     * @param date    the date of the transaction
     * @param grocery the initial grocery list (items purchased)
     */
    public GroceryTransaction(double amount, String reason, Date date, String grocery) {
        super(amount, reason, date);
        this.groceryList = grocery;
    }

    /**
     * Returns the grocery list associated with this transaction.
     *
     * @return a string containing the grocery items
     */
    public String getGroceryList(){
        return groceryList;
    }

    /**
     * Returns the type of this transaction.
     *
     * @return the string "Grocery"
     */
    @Override
    public String getType(){
        return "Grocery";
    }

    /**
     * return a formatted string describing the transaction
     *
     * @return a formatted string describing the transaction
     */
    @Override
    public String toString(){
        return super.toString() + " ExpenseType:Grocery";
    }

    /**
     * Adds an item to the grocery list.
     * The item is appended to the existing list with a space separator.
     *
     * @param item the grocery item to add
     */
    public void addItem(String item) {
        groceryList = groceryList + " " + item;
    }
}