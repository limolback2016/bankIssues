/***
 * This class contents all informaiton of
 * an account for a customer 
 * @author Li Molback, limolb-5
 */
package src;

import java.text.DecimalFormat;

public class SavingsAccount {
	// kommentar här ska tas bort
	private double saldo;
	private int accountNumber;
	
	private final float rate = 0.01f;
	private final String accountType = "Sparkonto"; 
	
	/**
	 * constructor for class SavingsAccount
	 * @param accountNumber passes account information
	 * dvs data to class instance variable accountNumber
	 * and save the information
	 */
	public SavingsAccount(int accountNumber){
		this.accountNumber = accountNumber;
	}
	
	/**
	 * shows how many money is in the account
	 * @param amount is the money which 
	 * customer sets into its account
	 */
	public void deposit(double amount){
		this.saldo += amount;
	}
	
	/**
	 * take out pengar from an account
	 * @param amount is the money which 
	 * customer takes out from its account
	 */
	public void withdraw (double amount){
		System.out.println("How many money do you want to take out?");
		saldo -=amount;
		System.out.println("You take out " + saldo + " kr from your account.");
	}
	
	/**
	 * show balance of an account
	 * @return what is left of an account
	 */
	public double getAccountSaldo(){
		System.out.println("You have " +  saldo + " in your account.");
		return saldo;
	}
	
	/**
	 * Get interest of deposit in an account
	 * @return interest of the deposit 
	 */
	public double getInterest(){
		return (rate * 100);
	}
	
	/**
	 * calculate interest of deposit in an account
	 * @return
	 */
	public double clalculateInterest() {
		double amountWithInterest = saldo * (1 + rate);
		return amountWithInterest; 
	}
	
	/**
	 * Get the type of an account 
	 * @return account type
	 */
	public String getAccountType(){
		return this.accountType;
	}
	
	/**
	 * Get account number of a customer
	 * @return customer account number
	 */
	public int getAccountNumber(){
		return accountNumber;
	}
	
	/**
	 * get presentation information about the 
	 * account no, balance, account type and 
	 * interest rate
	 * @return
	 */
	public String accountInfo(){
		DecimalFormat format = new DecimalFormat("#0.0");
		String info = accountNumber + " " + saldo + " " + accountType + " " + rate*100;
		return info;		   
	}
}
