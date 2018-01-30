/***
 * This class contents all informaiton of
 * a saving account for a customer 
 * @author Li Molback, limolb-5
 */
package src;

public class SavingsAccount extends Account{
	
	private final float WITHDRAWAL_RATE = 0.02f;
	private boolean costWithdraw = false; 
	
	/**
	 * class constructor
	 * @param accountNo is account number
	 */
	public SavingsAccount(int accountNo) {
		super(accountNo); //super hänvisar konstruktor i Account
		rate = 0.01f;
		accountType = "Sparkonto";
	}

	/**
	 * override withdraw method from base class Account
	 * withdraw money in a saving account
	 * @param amountOfWithdrawMoney is withdraw money 
	 *        in a saving account
	 * @return if there is enough money from a credit account 
	 *         then rate will be 1% of withdraw money
	 */
	@Override
	public boolean withdraw(double amountOfWithdrawMoney) {
		boolean returnVal = false;
		double amount = (amountOfWithdrawMoney * (1 + WITHDRAWAL_RATE));
		if((getAccountBalance() - amount) >= 0) {
			if(costWithdraw) {
				this.balance -= amount;
				updateTransactionList(amount);
			} else {
				this.balance -= amountOfWithdrawMoney;
				costWithdraw = true;
				updateTransactionList(amountOfWithdrawMoney);
			}
			returnVal = true;
			
			}
		return returnVal;
		}
	
	/**
	 * calculate interest of balance in an account
	 * @return interest of balance

	 */
	public double calculateInterest() {
		double amountWithInterest = getAccountBalance() * rate;
		return amountWithInterest; 
	}
}
