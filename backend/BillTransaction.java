package backend;
import java.util.Date;

/**
 * Represents a bill payment transaction.
 * This class extends "ExpenseTransaction" and is used to
 * specifically categorize and manage transactions that are bills.
 * 
 * @author Sean Powers & Isaiah Santamaria
 * @version Spring 2026
 */
public class BillTransaction extends ExpenseTransaction{
 
    /**
     * Constructs a new BillTransaction with the specified amount, reason, and date.
     *
     * @param amount the monetary amount of the bill transaction
     * @param reason the reason or description for the bill
     * @param date the date the bill transaction occurred
     */
    public BillTransaction(double amount, String reason, Date date){
        super(amount, reason, date );
    }

    /**
     * return a String representing the transaction type ("Bill")
     *
     * @return a String representing the transaction type ("Bill")
     */
    @Override
    public String getType(){
        return "Bill";
    }

    /**
     * return a formatted string describing this bill transaction
     *
     * @return a formatted string describing this bill transaction
     */
    @Override
    public String toString(){
        return super.toString()+  " ExpenseType:Bill";
    }
}