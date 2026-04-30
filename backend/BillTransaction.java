package backend;
/**
 * Keeps track of the bills being paid
 * 
 * @author Sean Powers & Isaiah Santamaria
 * @version Spring 2026
 * 
 */

public class BillTransaction extends ExpenseTransaction implements Transaction{
    private String destination;
    private String ID;
    private String reason;
    private double amount;

 

    public BillTransaction(double amount, String reason, String destination){
        this.reason = reason;
        this.amount = amount;
        this.ID = TransactionID.generateId();
        this.destination = destination;


    }

    /**
     * @return reason
     */
    @Override
    public String getReason(){
        return reason;
    }

    /**
     * @return amount
     */
    @Override
    public double getAmount(){
        return amount;
    }
    /**
     * returns transactionId variable
     */
    @Override
    public String getTransactionId(){
        return ID;
    }


    /**
     * 
     */
    @Override
    public String toString(){
        return "Paid the " + reason + "bill totaling " + amount + " dollars.";
    }

    /**
     * adds food list into list
     * @param food
     */
  

    }





