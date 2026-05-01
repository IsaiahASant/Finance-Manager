package backend;
/**
 * Author: Isaiah Santamaria, Sean Powers
 * Version: 4/15/2026
 */
public interface Transaction{
    
    /** get reasoning from the object of the text input*/
    public String getReason();

    /** get the amount of transaction */
    public double getAmount();

    /** returns TransactionId*/
    public String getTransactionId();

    /** returns date */
    public String getDate();
 
    /** toString() method*/
    @Override
    public String toString();


}
