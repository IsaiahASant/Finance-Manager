package backend;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

public class TransactionHistory {
    //instance variables for incomes and expenses
    private ArrayList<IncomeTransaction> income;
    private ArrayList<Transaction> expenses;

    public TransactionHistory(){
        this.income = new ArrayList<IncomeTransaction>();
        this.expenses = new ArrayList<>();
    }

    public String getIncomeTransactions(){
        return income.toString();
    }

    public String getExpenseTransactions(){
        return expenses.toString();
    }

    /** 
     * methods writes in the database.csv file and income csv.file in db folder
     * @param newIncome
     */
    public void addIncome(IncomeTransaction newIncome) {
        income.add(newIncome);
        try {
            // income.csv format: "Transaction ID", "Type", "Amount", "Reason", "Date", "items"
            String incomeRow = "\"" + newIncome.getTransactionId() + "\"" + "," +
                           "\"Income\"" + "," +
                           "\"" + newIncome.getAmount() + "\"" + "," +
                           "\"" + newIncome.getReason() + "\"" + "," +
                           "\"" + newIncome.getDate() + "\"" + "," +
                           "\"" + newIncome.getSource() + "\"" + "," +
                           "\"" + newIncome.getAccount() + "\"" +"\n";

            // database.csv format: "Transaction ID", "Transaction Type", "Amount", "Reason", "Date"
            String dbRow = "\"" + newIncome.getTransactionId() + "\"" + "," +
                       "\"Income\"" + "," +
                       "\"" + newIncome.getAmount() + "\"" + "," +
                       "\"" + newIncome.getReason() + "\"" + "," +
                       "\"" + newIncome.getDate() + "\"" + "\n";

            //StandardOpenOption.APPEND - means to add on to next line, StandardOpenOption.CREATE - create csv file if not created already
            Files.writeString(Path.of("db/income.csv"), incomeRow, StandardOpenOption.APPEND);
            Files.writeString(Path.of("db/database.csv"), dbRow, StandardOpenOption.APPEND);

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
    

    /**
     * methods write on database.csv and expense.csv files in db folder
     * @param newExpense
     */
    public void addExpense(Object newExpense) {
        try {
            Path expensePath = Path.of("db/expense.csv");
            Path dbPath = Path.of("db/database.csv");
        
            // Write headers if files don't exist yet
            if (!Files.exists(expensePath)) {
                Files.writeString(expensePath, "\"Transaction ID\",\"Type\",\"Amount\",\"Reason\",\"Date\",\"Items\"\n", StandardOpenOption.CREATE);
            }
            if (!Files.exists(dbPath)) {
                Files.writeString(dbPath, "\"Transaction ID\",\"Transaction Type\",\"Amount\",\"Reason\",\"Date\"\n", StandardOpenOption.CREATE);
            }
        
            if (newExpense instanceof BillTransaction bill) {
                expenses.add(bill);
            
                String expenseRow = "\"" + bill.getTransactionId() + "\"" + "," +
                                    "\"" + bill.getType() + "\"" + "," +
                                    "\"" + bill.getAmount() + "\"" + "," +
                                    "\"" + bill.getReason() + "\"" + "," +
                                    "\"" + bill.getDate() + "\"" + "," +
                                    "\"" + bill.getReason() + "\"" + "\n";
            
                String dbRow = "\"" + bill.getTransactionId() + "\"" + "," +
                               "\"Expense\"" + "," +
                               "\"" + bill.getAmount() + "\"" + "," +
                               "\"" + bill.getReason() + "\"" + "," +
                               "\"" + bill.getDate() + "\"" + "\n";
            
                Files.writeString(expensePath, expenseRow, StandardOpenOption.APPEND);
                Files.writeString(dbPath, dbRow, StandardOpenOption.APPEND);
            
            } else if (newExpense instanceof GroceryTransaction grocery) {
                expenses.add(grocery);
            
                String expenseRow = "\"" + grocery.getTransactionId() + "\"" + "," +
                                    "\"" + grocery.getType() + "\"" + "," +
                                    "\"" + grocery.getAmount() + "\"" + "," +
                                    "\"" + grocery.getReason() + "\"" + "," +
                                    "\"" + grocery.getDate() + "\"" + "," +
                                    "\"" + grocery.getGroceryList() + "\"" + "\n";
            
                String dbRow = "\"" + grocery.getTransactionId() + "\"" + "," +
                               "\"Expense\"" + "," +
                               "\"" + grocery.getAmount() + "\"" + "," +
                               "\"" + grocery.getReason() + "\"" + "," +
                               "\"" + grocery.getDate() + "\"" + "\n";
            
                Files.writeString(expensePath, expenseRow, StandardOpenOption.APPEND);
                Files.writeString(dbPath, dbRow, StandardOpenOption.APPEND);
            
            } else if (newExpense instanceof ShoppingTransaction shopping) {
                expenses.add(shopping);
            
                String expenseRow = "\"" + shopping.getTransactionId() + "\"" + "," +
                                    "\"" + shopping.getType() + "\"" + "," +
                                    "\"" + shopping.getAmount() + "\"" + "," +
                                    "\"" + shopping.getReason() + "\"" + "," +
                                    "\"" + shopping.getDate() + "\"" + "," +
                                    "\"" + shopping.getShoppingList() + "\"" + "\n";
            
                String dbRow = "\"" + shopping.getTransactionId() + "\"" + "," +
                               "\"Expense\"" + "," +
                               "\"" + shopping.getAmount() + "\"" + "," +
                               "\"" + shopping.getReason() + "\"" + "," +
                               "\"" + shopping.getDate() + "\"" + "\n";
            
                Files.writeString(expensePath, expenseRow, StandardOpenOption.APPEND);
                Files.writeString(dbPath, dbRow, StandardOpenOption.APPEND);
            }
        
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }


    @Override 
    public String toString(){
        return "Income: " + getIncomeTransactions() + "\nExpenses: " + getExpenseTransactions();
    }


}
