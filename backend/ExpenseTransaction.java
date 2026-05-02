package backend;

import java.util.Date;

/**
 * Abstract base class for all expense-related transactions.
 * This class provides common fields and methods that specific
 * expense types bills, groceries, shopping build upon this abstract class
 * 
 * @author Isaiah Santamaria
 * @version 4/30/2026
 */
public abstract class ExpenseTransaction implements Transaction {

    private double amount;
    private String reason;
    private String ID; 
    private Date date;

    /**
     * Constructs an ExpenseTransaction with the specified amount, reason, and date.
     * A unique transaction ID is automatically generated.
     * 
     * @param amount The monetary value of the transaction
     * @param reason The reason or description for the expense
     * @param date The date the transaction occurred
     */
    public ExpenseTransaction(Double amount, String reason, Date date) {
        this.amount = amount;
        this.reason = reason; 
        this.date = date;
        this.ID = TransactionID.generateId();
    }

    /**
     * Returns the amount of the transaction.
     * 
     * @return double representing the transaction amount
     */
    @Override
    public double getAmount() {
        return amount;
    }

    /**
     * Returns the unique transaction ID.
     * 
     * @return String representing the transaction ID
     */
    @Override
    public String getTransactionId() {
        return ID;
    }

    /**
     * Returns the reason or description for the transaction.
     * 
     * @return String representing the transaction reason
     */
    @Override
    public String getReason() {
        return reason;
    }

    /**
     * Returns the date of the transaction as a String.
     * 
     * @return String representation of the transaction date
     */
    @Override
    public String getDate() {
        return date.toString();
    }

    /**
     * Returns the type of expense transaction.
     * Must be implemented by subclasses.
     * 
     * @return String representing the transaction type
     */
    abstract String getType();

    /**
     * Returns a string representation of the transaction.
     * 
     * @return formatted transaction details as a String
     */
    @Override
    public String toString() {
        return "TransactionType:expense Amount:" + 
               amount + " Reason:" + reason + " ID:" + ID; 
    }
}