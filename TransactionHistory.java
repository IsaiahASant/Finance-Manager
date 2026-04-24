import java.util.ArrayList;


public class TransactionHistory {
    //instance variables for incomes and expenses
    private ArrayList<Integer> income;
    private ArrayList<Integer> expenses;

    public void TransactionHistory(ArrayList<Integer> income, ArrayList<Integer> expense){
        this.income = income;
        expenses = expense;
    }

    public String getIncomeTransactions(){
        return income.toString();
    }

    public String getExpenseTransactions(){
        return expenses.toString();
    }

    @Override 
    public String toString(){
        return "Income: " + getIncomeTransactions() + "\nExpenses: " + getExpenseTransactions();
    }


}
