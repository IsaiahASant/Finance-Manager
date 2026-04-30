package backend;
/**
 * this classes is used so that other expenses can built on top of
 * this class
 * @author Isaiah Santamaria
 * @version 4/30/2026
 * 
 */
public abstract class ExpenseTransaction{
    private double amount;
    private String reason;
    private String ID;  

    /**
     * 
     * @param amount
     * @param reason
     */
    public ExpenseTransaction(Double amount, String reason){
        this.amount = amount;
        this.reason = reason; 
        this.ID = TransactionID.generateId();
    }

    /**
     * returns the content of the object
     * @return the content of the object
     */
    @Override
    public String toString(){
        return "Transaction Type: expense \nAmount: " + 
         amount + "\nReason: " + reason + "\nID: " + ID; 
    }
    
    


}
