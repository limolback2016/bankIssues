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

public abstract class Account {
	private int accountNumber;
	protected double balance;
	private Calendar myCalendar = Calendar.getInstance();
	private ArrayList<String> transactionList = new ArrayList<String>();
	protected double rate;
	protected String accountType = " ";
	DecimalFormat d = new DecimalFormat("#0.0");
	
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
		
		transaction = formattedTime + " " + d.format(amount)
				      + " " + d.format(balance);
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
		DecimalFormat d = new DecimalFormat("#.0");
		String info = getAccountNo() + " " + d.format(getAccountBalance()) + " " + accountType + " " + d.format(rate);
		return info;		   
	}
	
}
