/***
 * This class contents all informaiton of
 * a credit account for a customer 
 * @author Li Molback, limolb-5
 */
package src;

public class CreditAccount extends Account{
	
	/**
	 * class constructor
	 * @param accountNo is account number
	 */
	public CreditAccount(int accountNo){
		super(accountNo);
		rate = 0.05f;
		accountType = "Kreditkonto";
	}

	/**
	 * override withdraw method from base class Account
	 * withdraw money in a credit account
	 * @param amountOfWithdrawMoney is withdraw money 
	 *        in an credit account
	 * @return if there is enough money from a credit account 
	 *         then rate will be 5% of withdraw money, otherwise
	 *         is 7%
	 */
	@Override
	public boolean withdraw(double amountOfWithdrawMoney) {
		if ((getAccountBalance() - amountOfWithdrawMoney) >= -5000) {
			this.balance -= amountOfWithdrawMoney;
			if(getAccountBalance() < 0) {
				rate = 0.07f;
			} else {
				rate = 0.05f;
			}
			updateTransactionList(-amountOfWithdrawMoney);
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * calculate interest of balance in the account
	 * @return interest of balance 
	 */
	public double calculateInterest(){
		double amountWithInterest = getAccountBalance() * rate;
		return amountWithInterest; 
	}
	
}
