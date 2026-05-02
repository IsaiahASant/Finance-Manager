package backend;
import java.util.Date;

/**
 * Represents an income transaction in the system.
 * This class implements the "Transaction" interface and stores
 * information about money received, including its source, destination account,
 * and associated metadata such as date and transaction ID.
 * 
 * @author Hayden & Isaiah Santamaria
 */
public class IncomeTransaction implements Transaction {
    private double amount;
    private String source;
    private String ID;
    private String reason; 
    private String account;
    private Date date; 

    /**
     * Default constructor for an IncomeTransaction.
     * Initializes fields with default values and generates a transaction ID.
     */
    public IncomeTransaction() {
        this.amount = 0;
        this.source = "Unkown";
        this.ID = TransactionID.generateId();
    }

    /**
     * Constructs an IncomeTransaction with specified details.
     *
     * @param amount the amount of money received
     * @param source the source from which the income is received
     * @param account the account where the income is deposited
     * @param date the date the transaction occurred
     */
    public IncomeTransaction(double amount, String source, String account, Date date) {
        this.amount = amount;
        this.source = source;
        this.account = account;
        this.date = date;
        this.ID = TransactionID.generateId();
        reason = "money from " + source; 
    }

    /**
     * return the transaction amount
     * 
     * @return the transaction amount
     */
    @Override
    public double getAmount() {
        return amount;
    }

    /**
     * return a string describing the reason for the income
     *
     * @return a string describing the reason for the income
     */
    @Override
    public String getReason(){
        return reason;
    }

    /**
     * Gets the source of the income.
     *
     * @return the income source
     */
    public String getSource() {
        return source;
    }

    /**
     * Gets the transaction ID.
     *
     * @return the unique transaction ID
     */
    @Override
    public String getTransactionId() {
        return ID;
    }

    /**
     * Gets the destination account of the income.
     *
     * @return the account receiving the income
     */
    public String getAccount(){
        return account;
    }

    /**
     * Gets the date of the transaction as a string.
     *
     * @return the transaction date in String format
     */
    public String getDate(){
        return date.toString();
    }

    /**
     * Displays basic transaction details to the console.
     */
    public void displayTransaction() {
        System.out.println("Transaction ID: " + ID);
        System.out.println("Source: " + source);
        System.out.println("Amount: $" + amount);
    }

    /**
     * Returns a string representation of the IncomeTransaction.
     *
     * @return formatted string containing transaction details
     */
    @Override
    public String toString() {
        return "IncomeTransaction{" +
                "transactionId='" + ID + '\'' +
                ", source='" + source + '\'' +
                ", amount=" + amount +
                '}';
    }
}