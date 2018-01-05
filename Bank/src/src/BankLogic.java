/***
 * This class contents logic of how to handle 
 * all customers and their accounts and basic 
 * bank functionality
 * @author Li Molback, limolb-5
 */
package src;

import java.awt.FocusTraversalPolicy;
import java.lang.annotation.Native;
import java.util.ArrayList;
import java.util.List;

import javax.lang.model.type.NullType;

public class BankLogic {
	
	private int accoutNummber = 1001;
	List<Customer> customerList = new ArrayList<Customer>();
	
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
		if ( !(findCustomer(pNo) == -1)){
			Customer customer = customerList.get(findCustomer(pNo));
			myList.add(customer.getCustomerInfo());
			for (SavingsAccount a : customer.getAccounts()){
				myList.add(a.getAccountNumber() + " " + a.getAccountSaldo() + " " + a.getAccountType() + 
						" " + a.getInterest());
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
			for(SavingsAccount s : c.getAccounts()) {
				removeList.add(s.accountInfo() + " " + (s.getInterest() / 100 * s.getAccountSaldo()));
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
			SavingsAccount sa = new SavingsAccount(accoutNummber); // create object of savingsaccount
			c.addAccount(sa); // skapa an accout for the customer
			accoutNummber++;  // account number increase
			return sa.getAccountNumber();  // return account number increase
		} else {
			return -1;  // felaktig code
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
			for(SavingsAccount s : c.getAccounts()){
				if ( s.getAccountNumber() == accountId ){
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
		//if ( c.getIdNo().equals(pNo)) {
		int account = c.findAccount(accountId);
		if(!(account==-1)) {
			SavingsAccount s = c.getAccount(account);
			if ( !s.equals(null)) {
					s.deposit(amount);
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
			SavingsAccount s = c.getAccount(account);
			if ( !s.equals(null)) {
				if ( s.getAccountSaldo() >= amount) {
					s.withdraw(amount);
					return true;
				}
			}
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
				SavingsAccount s = c.getAccount(account);
				if ( !s.equals(null)) {
					double interest = (s.getInterest()/100 * s.getAccountSaldo());
					c.closeAccount(accountId);
					return s.accountInfo() + " " + interest;
				}
			}
		}
		return null;
	}
	
	/**
	 * get all customer list
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
