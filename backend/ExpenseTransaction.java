package backend;
import java.util.Date;
/**
 * this classes is used so that other expenses can built on top of
 * this class
 * @author Isaiah Santamaria
 * @version 4/30/2026
 */
public abstract class ExpenseTransaction implements Transaction{
    private double amount;
    private String reason;
    private String ID; 
    private Date date;

    /**
     * 
     * @param amount
     * @param reason
     */
    public ExpenseTransaction(Double amount, String reason, Date date){
        this.amount = amount;
        this.reason = reason; 
        this.date = date;
        this.ID = TransactionID.generateId();
    }

    /**
     * returns the amount
     * @return amount
     */
    @Override
    public double getAmount() {
        return amount;
    }

    /**
     * returns the ID of the transaction
     * @return ID
     */
    @Override
    public String getTransactionId() {
        return ID;
    }

    @Override
    public String getReason() {
        return reason;
    }

    @Override
    public String getDate(){
        return date.toString();
    }

    abstract String getType();

    /**
     * returns the content of the object
     * @return the content of the object
     */
    @Override
    public String toString(){
        return "TransactionType:expense Amount:" + 
         amount + " Reason:" + reason + " ID:" + ID; 
    }
    
    
}
