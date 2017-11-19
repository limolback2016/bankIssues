package src;

import java.text.DecimalFormat;

public class SavingsAccount {
	// kommentar här ska tas bort
	private double saldo;
	private int accountNumber;
	
	private final float rate = 0.01f;
	private final String accountType = "Sparkonto"; 
	
	public SavingsAccount(int accountNumber){
		this.accountNumber = accountNumber;
	}
	
	// sätt in pengar
	public void deposit(double amount){
		this.saldo += amount;
	}
	
	// ta ut pengar
	public void withdraw (double amount){
		System.out.println("How many money do you want to take out?");
		saldo -=amount;
		System.out.println("You take out " + saldo + " kr from your account.");
	}
	
	// show saldo of a account
	public double getAccountSaldo(){
		System.out.println("You have " +  saldo + " in your account.");
		return saldo;
	}
	
	// show deposit interest
	public double getInterest(){
		return (rate * 100);
	}
	
	public double clalculateInterest() {
		double amountWithInterest = saldo * (1 + rate);
		return amountWithInterest; 
	}
	
	public String getAccountType(){
		return this.accountType;
	}
	
	public int getAccountNumber(){
		return accountNumber;
	}
	
	// hämta presentationsinformation om kontot
	// kontonummer saldo kontotyp räntesats
	public String accountInfo(){
		DecimalFormat format = new DecimalFormat("#0.0");
		String info = accountNumber + " " + saldo + " " + accountType + " " + rate*100 + " " + format.format(saldo * rate);
		return info;		   
	}
	
	public int removeAccount(int accountNumber){
		accountNumber = 0;
		return accountNumber;
	}
}
