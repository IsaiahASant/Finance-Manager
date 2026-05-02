package backend;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

/**
 * Manages and stores all transaction history, including income and expenses.
 * Handles both in-memory storage and writing transaction data to CSV files.
 * 
 * @author Isaiah Santamaria
 * @version 5/1/2026
 */
public class TransactionHistory {

    // Stores all income transactions
    private ArrayList<IncomeTransaction> income;

    // Stores all expense transactions (bills, groceries, shopping, etc.)
    private ArrayList<Transaction> expenses;

    /**
     * Initializes empty lists for income and expense transactions.
     */
    public TransactionHistory() {
        this.income = new ArrayList<IncomeTransaction>();
        this.expenses = new ArrayList<>();
    }

    /**
     * Returns a string representation of all stored income transactions.
     * 
     * @return String containing all income transactions
     */
    public String getIncomeTransactions() {
        return income.toString();
    }

    /**
     * Returns a string representation of all stored expense transactions.
     * 
     * @return String containing all expense transactions
     */
    public String getExpenseTransactions() {
        return expenses.toString();
    }

    /**
     * Adds a new income transaction to the list and writes it to CSV files.
     * Data is written to both:
     * - income.csv (detailed income records)
     * - database.csv (general transaction log)
     * 
     * @param newIncome The IncomeTransaction object to be added
     */
    public void addIncome(IncomeTransaction newIncome) {
        income.add(newIncome);

        try {
            // Format for income.csv:
            // "Transaction ID", "Type", "Amount", "Reason", "Date", "Source", "Account"
            String incomeRow = "\"" + newIncome.getTransactionId() + "\"" + "," +
                               "\"Income\"" + "," +
                               "\"" + newIncome.getAmount() + "\"" + "," +
                               "\"" + newIncome.getReason() + "\"" + "," +
                               "\"" + newIncome.getDate() + "\"" + "," +
                               "\"" + newIncome.getSource() + "\"" + "," +
                               "\"" + newIncome.getAccount() + "\"" + "\n";

            // Format for database.csv:
            // "Transaction ID", "Transaction Type", "Amount", "Reason", "Date"
            String dbRow = "\"" + newIncome.getTransactionId() + "\"" + "," +
                           "\"Income\"" + "," +
                           "\"" + newIncome.getAmount() + "\"" + "," +
                           "\"" + newIncome.getReason() + "\"" + "," +
                           "\"" + newIncome.getDate() + "\"" + "\n";

            // APPEND: Adds data to the end of the file
            // CREATE: Creates the file if it does not already exist
            Files.writeString(Path.of("db/income.csv"), incomeRow, StandardOpenOption.APPEND);
            Files.writeString(Path.of("db/database.csv"), dbRow, StandardOpenOption.APPEND);

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    /**
     * Adds a new expense transaction and writes it to CSV files.
     * Supports multiple expense types:
     * - BillTransaction
     * - GroceryTransaction
     * - ShoppingTransaction
     * 
     * Writes data to:
     * - expense.csv (detailed expense records)
     * - database.csv (general transaction log)
     * 
     * @param newExpense The expense object to be processed (must be a valid transaction type)
     */
    public void addExpense(Object newExpense) {
        try {
            Path expensePath = Path.of("db/expense.csv");
            Path dbPath = Path.of("db/database.csv");

            // Create files with headers if they do not already exist
            if (!Files.exists(expensePath)) {
                Files.writeString(expensePath,
                        "\"Transaction ID\",\"Type\",\"Amount\",\"Reason\",\"Date\",\"Items\"\n",
                        StandardOpenOption.CREATE);
            }

            if (!Files.exists(dbPath)) {
                Files.writeString(dbPath,
                        "\"Transaction ID\",\"Transaction Type\",\"Amount\",\"Reason\",\"Date\"\n",
                        StandardOpenOption.CREATE);
            }

            // Handle BillTransaction
            if (newExpense instanceof BillTransaction) {
                BillTransaction bill = (BillTransaction) newExpense;
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

            // Handle GroceryTransaction
            } else if (newExpense instanceof GroceryTransaction) {
                GroceryTransaction grocery = (GroceryTransaction) newExpense;
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

            // Handle ShoppingTransaction
            } else if (newExpense instanceof ShoppingTransaction) {
                ShoppingTransaction shopping = (ShoppingTransaction) newExpense;
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

    /**
     * Returns a formatted string containing all income and expense transactions.
     * 
     * @return Combined transaction summary
     */
    @Override
    public String toString() {
        return "Income: " + getIncomeTransactions() +
               "\nExpenses: " + getExpenseTransactions();
    }
}