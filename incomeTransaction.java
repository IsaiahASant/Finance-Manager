public class incomeTransaction {
    private int amount;
    private String source;
    private String transactionId;
    private double tax; 
    private double afterTax;

    public incomeTransaction() {
        this.amount = 0;
        this.source = "Unkown";
        this.transactionId = "N/A";
    }

    public incomeTransaction( int amount, String source, String transactionId) {
        this.amount = amount;
        this.source = source;
        this.transactionId = transactionId;
    }

    public int getAmount() {
        return amount;
    }

    public String getSoruce() {
        return source;
    }

    public String getTransactionId() {
        return transactionId;
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
        this.transactionId = transactionId;
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
        System.out.println("Transaction ID: " + transactionId);
        System.out.println("Source: " + source);
        System.out.println("Amount: $" + amount);
    }

     @Override
    public String toString() {
        return "IncomeTransaction{" +
                "transactionId='" + transactionId + '\'' +
                ", source='" + source + '\'' +
                ", amount=" + amount +
                '}';
    }
}
