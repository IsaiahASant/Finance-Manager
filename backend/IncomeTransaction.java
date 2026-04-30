package backend;
public class IncomeTransaction implements Transaction {
    private double amount;
    private String source;
    private String ID;
    private double tax; 
    private double afterTax;

    public IncomeTransaction() {
        this.amount = 0;
        this.source = "Unkown";
        this.ID = TransactionID.generateId();
    }

    public IncomeTransaction( double amount, String source) {
        this.amount = amount;
        this.source = source;
        this.ID = TransactionID.generateId();
    }
    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public String getReason(){
        return "";

    }

    public String getSource() {
        return source;
    }


    @Override
    public String getTransactionId() {
        return ID;
    }

    public void setAmount(int amount) {
        if(amount >= 0) this.amount = amount;
        else System.out.println("Amount cannot be a negative amount");
    }



    public void setSource(String source) {
        if (source.equalsIgnoreCase("work") || 
            source.equalsIgnoreCase("gift") || 
            source.equalsIgnoreCase("lottery")) {
            this.source = source;
        } else { 
            System.out.println("Invalid source. Please use work, gift, or lottery as the source of income.");
        }
    }




    public void setTransactionId(String transactionId) {
        this.ID = transactionId;
    }





    public void nyTax() {
        if (source.equalsIgnoreCase("work")){
            tax = amount * .1;
            afterTax = amount - tax;
        } else if (source.equalsIgnoreCase("lottery")) {
            tax = amount * .15;
            afterTax = amount - tax;
        }
    }

    public void displayTransaction() {
        System.out.println("Transaction ID: " + ID);
        System.out.println("Source: " + source);
        System.out.println("Amount: $" + amount);
    }

    @Override
    public String toString() {
        return "IncomeTransaction{" +
                "transactionId='" + ID + '\'' +
                ", source='" + source + '\'' +
                ", amount=" + amount +
                '}';
    }
}
