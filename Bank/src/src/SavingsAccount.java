package src;

public class SavingsAccount {
	// kommentar här ska tas bort
	private double saldo;
	private int accountNumber;
	
	private final float rate = 0.01f;
	private final String accountType = "Saving account"; 
	
	public SavingsAccount(int accountNumber){
		this.accountNumber = accountNumber;
	}
	
	// sätt in pengar
	public void deposit(double amount){
		this.saldo = amount;
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
	public String accountInfo(){
		String info = "Account number is " + accountNumber +
				               "Saldo is: " + saldo +
				        "Account type is: " + accountType +
				                "Rate is: " + rate;
		return info;		   
	}
	
	public int removeAccount(int accountNumber){
		accountNumber = 0;
		return accountNumber;
	}
}
