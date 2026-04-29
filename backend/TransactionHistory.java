package backend;
import java.util.ArrayList;


public class TransactionHistory {
    //instance variables for incomes and expenses
    private ArrayList<IncomeTransaction> income;
    private ArrayList<ExpenseTransaction> expenses;

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

    public void addIncome(IncomeTransaction newIncome){
        income.add(newIncome);
    }
    
    public void addExpense(Object newExpense){
        if(newExpense instanceof BillTransaction){
            expenses.add((BillTransaction)newExpense);
        }
    }


    @Override 
    public String toString(){
        return "Income: " + getIncomeTransactions() + "\nExpenses: " + getExpenseTransactions();
    }


}
