/***
 * This class is base class for SavingsAccount and CreditAccount
 * the common variable and method is written in this class
 * @author Li Molback, limolb-5
 */
package limolb5;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public abstract class Account {
	private int accountNumber;
	protected double balance;
	private Calendar myCalendar = Calendar.getInstance();
	private ArrayList<String> transactionList = new ArrayList<String>();
	protected double rate;
	protected String accountType = " ";
	
	/**
	 * class constructor
	 * @param accountNo is account number
	 */
	public Account(int accountNo){
		this.accountNumber = accountNo;
	}
	
	/**
	 * deposit money to an account 
	 * @param amountOfDepositeMoney is an amount of
	 *        depositing money
	 */
	public void deposit(double amountOfDepositeMoney){   // hur sätter man pengar på olika konto????
		this.balance += amountOfDepositeMoney;
		updateTransactionList(amountOfDepositeMoney);
	}
	
	/**
	 * abstract method of withdraw which will be 
	 * overridden in class savingsAccount and reditAccont
	 * @param amountOfWithdrawMoney is an amount of 
	 *        withdrawing money
	 * @return balance in the account of a customer
	 */
	abstract boolean withdraw(double amountOfWithdrawMoney);
	
	/**
	 * get the balance of a customer's account 
	 * @return
	 */
	public double getAccountBalance(){
		return balance;
	}
	
	/**
	 * get the number of an account
	 * @return account number
	 */
	public int getAccountNo(){
		return accountNumber;
	}
	
	/**
	 * get the interest of a type of an account
	 * @return 
	 */
	public double getInterest(){
		return rate;
	}
	
	/**
	 * save all transactions of an account to a list
	 * @param amount transaction's amount
	 */
	protected void updateTransactionList(double amount){
		String transaction;
		SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");
		String formattedTime = format.format(myCalendar.getTime());
		
		transaction = formattedTime + " " + String.format(Locale.ROOT, "%.1f", amount)
				      + " " + String.format(Locale.ROOT, "%.1f", balance);
		transactionList.add(transaction);
	}
	
	/**
	 * get all transactions' info
	 * @return transaction's list
	 */
	public ArrayList<String> getTransactionList(){
		return transactionList;
	}
	
	/**
	 * get an account type
	 * @return account type
	 */
	public String getAccountType(){
		return accountType;
	}
	
	/**
	 * get an account info
	 * @return account info
	 */
	public String accountInfo(){
		String info = getAccountNo() + " " + String.format(Locale.ROOT, "%.1f", getAccountBalance()) 
				+ " " + accountType + " " + String.format(Locale.ROOT, "%.1f", rate);
		return info;		   
	}
	
}
