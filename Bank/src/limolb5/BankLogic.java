/***
 * This class contents logic of how to handle 
 * all customers and their accounts and basic 
 * bank functionality
 * @author Li Molback, limolb-5
 */
package limolb5;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BankLogic {
	private static int accoutNummber = 1001;
	List<Customer> customerList = new ArrayList<Customer>();
	DecimalFormat d = new DecimalFormat("#0.0");
	
	/**
	 * Create a new customer in the bank system
	 * with all customer information
	 * @param name is customer's first name
	 * @param surname is customer's surname
	 * @param pNo is customer's person no
	 * @return a new customer is created and 
	 * also check if the customer already 
	 * exists or not in the system
	 */
	public boolean createCustomer(String name, String surname, String pNo){
		if ( findCustomer(pNo) == -1){
			Customer customer = new Customer(pNo);
			customer.setForename(name);
			customer.setSurname(surname);
			customerList.add(customer);
			return true;
		}
		return false;
	}
	
	/**
	 * Get all customer information
	 * @param pNo identify which customer
	 * @return customer list or null when 
	 * customer doesn't exist
	 */
	public List<String> getCustomer(String pNo){
		List<String> myList = new ArrayList<>();
		CreditAccount creditAccount = new CreditAccount(accoutNummber);
		if ( !(findCustomer(pNo) == -1)){
			Customer customer = customerList.get(findCustomer(pNo));
			myList.add(customer.getCustomerInfo());
			for (Account a : customer.getAccounts()){
				//identify account type to print out right interest here
				myList.add(a.getAccountNo() + " " + String.format(Locale.ROOT, "%.1f", a.getAccountBalance()) + " " + a.getAccountType() + 
						" " + String.format(Locale.ROOT, "%.1f", a.getInterest()));
			}
			return myList;
		}
		return null;
	}
	
	/**
	 * change exist customer information
	 * @param name is customer's first name
	 * @param surname is customer's surname
	 * @param pNo is customer's person no
	 * @return customer's info changed or not
	 */
	public boolean changeCustomerName(String name, String surname, String pNo){
		if ( findCustomer(pNo) == -1){
			return false;
		} else {
			Customer c = customerList.get(findCustomer(pNo));
			c.setForename(name);
			c.setSurname(surname);
			return true;
		}
	}
	
	/**
	 * delete customer's information from the system
	 * @param pNo is customer person no
	 * @return remove list of customer
	 */
	public List<String> deleteCustomer(String pNo){
		List<String> removeList = new ArrayList<>();
		if ( findCustomer(pNo) == -1){
			return null;
		} else {
			Customer c = customerList.get(findCustomer(pNo));
			removeList.add(c.getCustomerInfo());
			for(Account s : c.getAccounts()) {
				removeList.add(s.accountInfo() + " " + String.format(Locale.ROOT, "%.1f", (s.getInterest() / 100) * s.getAccountBalance()));
			}
			customerList.remove(c);
		}
		return removeList;
	}
	
	/**
	 * create saving account to a customer
	 * @param pNo is customer's person no
	 * @return account no and check if account no 
	 * exists or not
	 */
	public int createSavingsAccount(String pNo){
		if ( !(findCustomer(pNo) == -1) ){
			Customer c = customerList.get(findCustomer(pNo)); // check if customer exits 
			Account savningsAccount = new SavingsAccount(accoutNummber); // create object of savingsaccount
			c.addAccount(savningsAccount); // skapa an accout for the customer
			accoutNummber++;  // account number increase 
			return savningsAccount.getAccountNo();  // return account number increase
		} else {
			return -1;  // felaktig code
		}
	}
	
	/**
	 * create credit account to a customer
	 * @param pNr is customer's person no
	 * @return account no and check if account no 
	 * exists or not
	 */
	public int createCreditAccount(String pNr) {
		if ( !(findCustomer(pNr) == -1) ){
			Customer c = customerList.get(findCustomer(pNr));
			Account creditAccount = new CreditAccount(accoutNummber);
			c.addAccount(creditAccount);
			accoutNummber++;
			return creditAccount.getAccountNo();
		} else {
			return -1;
		}
	}
	
	/**
	 * Get acoount information
	 * @param pNo is customer's person no
	 * @param accountId is account no
	 * @return account information or null when 
	 * account doesn't exist
	 */
	public String getAccount(String pNo, int accountId){
		Customer c = customerList.get(findCustomer(pNo));
		if (!c.equals(null)){
			for(Account s : c.getAccounts()){
				if ( s.getAccountNo() == accountId ){
					return s.accountInfo();
				}
			}
		}
		return null;
	}
	
	/**
	 * deposit money to a customer's account
	 * @param pNo is customer's person no
	 * @param accountId is account no
	 * @param amount is amount of money
	 * @return if account exist deposit money
	 * in the account
	 */
	public boolean deposit(String pNo, int accountId, double amount) {
		Customer c = customerList.get(findCustomer(pNo));
		int account = c.findAccount(accountId);
		if(!(account==-1)) {
			Account savingsAccount = c.getAccount(account);
			if ( !savingsAccount.equals(null)) {
					savingsAccount.deposit(amount);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * withdraw money from an account
	 * @param pNo is customer's person no
	 * @param accountId is account no
	 * @param amount is amount of withdrawing money
	 * @return withdraw money from an account when 
	 * there has enough money in it
	 */
	public boolean withdraw(String pNo, int accountId, double amount) {
		Customer c = customerList.get(findCustomer(pNo));
		int account = c.findAccount(accountId);
		if(!(account==-1)) {
			Account tempAccount = c.getAccount(account);
			tempAccount.withdraw(amount);
		}
		return false;
	}
	
	/**
	 * close an account of a customer
	 * @param pNr is customer's person no
	 * @param accountId is account no
	 * @return account information 
	 */
	public String closeAccount(String pNr, int accountId) {
		int listId = findCustomer(pNr);
		if(listId != -1) {
			Customer c = customerList.get(listId);
			int account = c.findAccount(accountId);
			if(!(account==-1)) {
				Account savingsAccount = c.getAccount(account);
				String accountType = savingsAccount.getAccountType();
				if ( !savingsAccount.equals(null)) {
					double interest = ((savingsAccount.getInterest() /100 ) * savingsAccount.getAccountBalance());
					if (accountType == "Kreditkonto"){
						String returnVal = savingsAccount.accountInfo() + " " + String.format(Locale.ROOT, "%.1f", interest);
						c.closeAccount(accountId);
						return returnVal;
					} else {
						String returnVal = savingsAccount.accountInfo() + " " + String.format(Locale.ROOT, "%.2f", interest);
						c.closeAccount(accountId);
						return returnVal;
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * get all customers
	 * @return customer list
	 */
	public ArrayList<String> getAllCustomers() {
		ArrayList<String> myList = new ArrayList<String>();
		for ( Customer c : customerList) {
			myList.add(c.getCustomerInfo());
		}
		return myList;
	}
	
	/**
	 * get transaction with right person number and right account no
	 * @param pNr is person number
	 * @param accountId is account number
	 * @return transaction of a customer account
	 */
	public ArrayList<String> getTransactions(String pNr, int accountId){
		int listId = findCustomer(pNr);
		if (listId != -1){
			Customer c = customerList.get(listId);
			int accountListId = c.findAccount(accountId);
			if( !(accountListId == -1)) {
				Account myAccount = c.getAccount(accountListId);
				return myAccount.getTransactionList();
			}
		}
		return null;	
	}
	
	/**
	 * check if customer already exists or not
	 * @param pNo is customer's person no
	 * @return customer exists or not  
	 */
		private int findCustomer(String pNo){
			for ( int i = 0; i< customerList.size(); i++){
				if ( customerList.get(i).getIdNo().equals(pNo) ){
					 return i;
				}	
			}
			return -1;
		}
}
