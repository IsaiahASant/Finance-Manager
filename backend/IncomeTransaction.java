package backend;
import java.util.Date;


public class IncomeTransaction implements Transaction {
    private double amount;
    private String source;
    private String ID;
    private String reason; 
    private String account;
    private Date date; 

    private double tax; 
    private double afterTax;

    /**
     * when there is not param
     */
    public IncomeTransaction() {
        this.amount = 0;
        this.source = "Unkown";
        this.ID = TransactionID.generateId();
    }

    /**
     * Overrwritng constructor
     * @param amount the amount that is being included
     * @param source where is the money coming from
     * @param account which account is this transaction is going towards
     * @param date keeps tracks of the date
     */
    public IncomeTransaction(double amount, String source, String account, Date date) {
        this.amount = amount;
        this.source = source;
        this.account = account;
        this.date = date;
        this.ID = TransactionID.generateId();
        reason = "Paying for " + source + "s"; 
        
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
     * returns the reason of the transaction
     * @return reason
     */
    @Override
    public String getReason(){
        return reason;

    }

    /**
     * returns where the source of the transaction 
     * is coming from
     * @return source
     */
    public String getSource() {
        return source;
    }

    /**
     * returns the ID of the transaction
     * @return ID
     */
    @Override
    public String getTransactionId() {
        return ID;
    }

    /**
     * return account, the destination where the income is going towards
     * @return account, the destination where the income is going towards
     */
    public String getAccount(){
        return account;
    }

    /**
     * returns date into a String value
     * @returns date into a String value
     */
    public String getDate(){
        return date.toString();
    }




    public void displayTransaction() {
        System.out.println("Transaction ID: " + ID);
        System.out.println("Source: " + source);
        System.out.println("Amount: $" + amount);
    }
    /**
     * returns the content of the object
     * @returns the object content
     */
    @Override
    public String toString() {
        return "IncomeTransaction{" +
                "transactionId='" + ID + '\'' +
                ", source='" + source + '\'' +
                ", amount=" + amount +
                '}';
    }

    public static void main(String[] args) {
        IncomeTransaction transaction = new IncomeTransaction(1000.0,"source", "source", new Date());

        System.out.println(transaction.getDate());
    }
}
