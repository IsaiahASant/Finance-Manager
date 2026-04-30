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
    /** toString() method*/
    public String getTransactionId();
    @Override
    public String toString();

}
