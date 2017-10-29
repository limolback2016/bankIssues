package src;

public class SavingsAccount {
	
	private double saldo;
	private int accountNumber;
	
	private final float rate = 0.01f;
	private final String accountType = "Saving account"; 
	
	public SavingsAccount(int accountNumber){
		this.accountNumber = accountNumber;
	}
	
	// sätt in pengar
	public void deposit(int amount){
		this.saldo = amount;
	}
	
	// ta ut pengar
	public void withdraw (int amount){
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
		double interest;
		return interest = saldo * (1 + rate);
	}
	
	public String getAccountType(){
		return this.accountType;
	}
	
	public int getAccountNumber(){
		return accountNumber;
	}
	
	// hämta presentationsinformation om kontot
	// kontonummer saldo kontotyp räntesats
	public void accountInfo(){
		System.out.println( "Account number is " + accountNumber +
				            "Saldo is: " + saldo +
				            "Account type is: " + accountType +
				            "Rate is: " + rate);
	}
}
