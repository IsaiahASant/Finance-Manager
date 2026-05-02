package backend;

/**
 * Defines the common structure for all transaction types.
 * Any class implementing this interface must provide
 * basic transaction details such as reason, amount, ID, and date.
 * 
 * @author Isaiah Santamaria & Sean Powers
 * @version 4/15/2026
 */
public interface Transaction {

    /**
     * return String representing the transaction reason
     * @return String representing the transaction reason
     */
    public String getReason();

    /**
     * return double representing the transaction amount
     * @return double representing the transaction amount
     */
    public double getAmount();

    /**
     * return String representing the transaction ID
     * @return String representing the transaction ID
     */
    public String getTransactionId();

    /**
     * return String representing the transaction date
     * @return String representing the transaction date
     */
    public String getDate();

    /**
     * return formatted transaction details as a String
     * @return formatted transaction details as a String
     */
    @Override
    public String toString();
}