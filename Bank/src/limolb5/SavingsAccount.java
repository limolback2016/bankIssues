/***
 * This class contents all informaiton of
 * a saving account for a customer 
 * @author Li Molback, limolb-5
 */
package limolb5;

public class SavingsAccount extends Account{
	
	private final float SAVING_RATE = 1f;
	private final float WITHDRAWAL_RATE = 2f;
	private boolean costWithdraw = false; 
	
	/**
	 * class constructor
	 * @param accountNo is account number
	 */
	public SavingsAccount(int accountNo) {
		super(accountNo); //super hänvisar konstruktor i Account
		rate = SAVING_RATE;
		accountType = "Sparkonto";
	}

	/**
	 * override withdraw method from base class Account
	 * withdraw money in a saving account
	 * @param amountOfWithdrawMoney is withdraw money 
	 *        in a saving account
	 * @return if there is enough money from a saving account 
	 *         then rate will be 2% of withdraw money
	 */
	@Override
	public boolean withdraw(double amountOfWithdrawMoney) {
		boolean returnVal = false;
		// summan av uttagen är uttagen + uttagen * rate dvs uttagen * ( 1 + 0.
		double amount = amountOfWithdrawMoney * (1 + WITHDRAWAL_RATE);    // uttagen med 2% räntan
		if((getAccountBalance() - amount) >= 0) {
			if(!costWithdraw) {
				this.balance -=amount;
				updateTransactionList(-amount);
			} else {
				this.balance -= amountOfWithdrawMoney;
				costWithdraw = true;
				updateTransactionList(-amountOfWithdrawMoney);
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
