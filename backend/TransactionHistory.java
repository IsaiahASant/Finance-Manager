package backend;
import java.util.ArrayList;


public class TransactionHistory {
    //instance variables for incomes and expenses
    private ArrayList<IncomeTransaction> income;
    private ArrayList<ExpenseTransaction> expenses;

    public void TransactionHistory(ArrayList<IncomeTransaction> income, ArrayList<ExpenseTransaction> expense){
        this.income = income;
        expenses = expense;
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
    
    public void addIncome(ExpenseTransaction newExpense){
        expenses.add(newExpense);
    }


    @Override 
    public String toString(){
        return "Income: " + getIncomeTransactions() + "\nExpenses: " + getExpenseTransactions();
    }


}
