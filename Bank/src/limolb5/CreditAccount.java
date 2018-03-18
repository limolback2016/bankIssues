/***
 * This class contents all informaiton of
 * a credit account for a customer 
 * @author Li Molback, limolb-5
 */
package limolb5;

public class CreditAccount extends Account{
	private static final float DEBT_RATE = 7f;
	private static final float RATE = 0.5f;
	private static final double CREDIT_LIMIT = -5000;

	/**
	 * class constructor
	 * @param accountNo is account number
	 */
	public CreditAccount(int accountNo){
		super(accountNo);
		rate = RATE;
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
		if ((getAccountBalance() - amountOfWithdrawMoney) >= CREDIT_LIMIT) {
			this.balance -= amountOfWithdrawMoney;
			updateTransactionList(-amountOfWithdrawMoney);
			if(this.balance >= 0) {
				rate = RATE;
			} else {
				rate = DEBT_RATE;
			}
			return true;
		}
		return false;
	}
	
	/**
	 * calculate interest of balance in the account
	 * @return interest of balance 
	 */
	public double calculateInterest(){
		return Math.round((balance * (rate/100)));
	}
	
}
