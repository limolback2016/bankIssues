package src;

import java.awt.FocusTraversalPolicy;
import java.lang.annotation.Native;
import java.util.ArrayList;
import java.util.List;

import javax.lang.model.type.NullType;

public class BankLogic {
	
	private int accoutNummber = 1000;
	List<Customer> customerList = new ArrayList<Customer>();
	List<SavingsAccount> accountList = new ArrayList<SavingsAccount>();
	
	public BankLogic(){
	
	}
	
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
	
	public List<String> getCustomer(String pNo){
		List<String> myList = new ArrayList<>();
		if ( !(findCustomer(pNo) == -1)){
			Customer customer = customerList.get(findCustomer(pNo));
			myList.add(customer.getCustomerInfo());
			for (SavingsAccount a : customer.getAccounts()){
				myList.add(a.getAccountNumber() + " " + a.getAccountSaldo() + " " + a.getAccountType() + 
						" " + a.getInterest());
			}
		}
		return myList;	
	}
	
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
	
	public List<String> deleteCustomer(String pNo){
		List<String> removeList = getCustomer(pNo);
		if ( findCustomer(pNo) == -1){
			return null;
		} else {
			Customer c = customerList.get(findCustomer(pNo));
			customerList.remove(c);
		}
		return removeList;
	}
	
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
	
	public String getAccount(String pNo, int accountId){
		Customer c = customerList.get(findCustomer(pNo));
		if (!c.equals(null)){
			for(SavingsAccount s : accountList){
				if ( s.getAccountNumber() == accountId ){
					return s.accountInfo();
				}
			}
		}
		return null;
	}
	
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
	
	public String closeAccount(String pNr, int accountId) {
		Customer c = customerList.get(findCustomer(pNr));
		int account = c.findAccount(accountId);
		if(!(account==-1)) {
			SavingsAccount s = c.getAccount(account);
			if ( !s.equals(null)) {
				for ( SavingsAccount sa : accountList){
					sa.removeAccount(accountId);
				}
			}
		}
		return null;
	}
	
	public ArrayList<String> getAllCustomers() {
		ArrayList<String> myList = new ArrayList<String>();
		for ( Customer c : customerList) {
			myList.add(c.getCustomerInfo());
		}
		return myList;
	}
	
	// help class to check if customer already exists or not
		private int findCustomer(String pNo){
			for ( int i = 0; i< customerList.size(); i++){
				if ( customerList.get(i).getIdNo().equals(pNo) ){
					 return i;
				}	
			}
			return -1;
		}
}
