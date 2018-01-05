/***
 * This class contents all informaiton of
 * a customer and its account's info. 
 * @author Li Molback, limolb-5
 */
package src;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Customer {
	private String surName;
	private String name;
	private String idNo;
	List<SavingsAccount> accounts = new ArrayList<>();
	
	public Customer(String pID){
		this.idNo = pID;
	}
	
	/**
	 * Set customer's first name
	 * @param foreName
	 */
	public void setForename(String foreName){
		this.name = foreName;
	}
	
	/**
	 * Get customer's first name
	 * @return customer's first name
	 */
	public String getForename(){
		return this.name;
	}
	
	/**
	 * Set customer's surname
	 * @param surName
	 */
	public void setSurname(String surName){
		this.surName = surName;
	}
	
	/**
	 * Get customer's surname
	 * @return customer's surname
	 */
	public String getSurname(){
		return this.surName;
	}
	
	/**
	 * Get customer's ID
	 * @return customer's ID 
	 */
	public String getIdNo(){
		return this.idNo;
	}
	
	/**
	 * create an new account for the customer 
	 * @param s add an account to the customer
	 */
	public void addAccount(SavingsAccount s){
		accounts.add(s);
	}
	
	/**
	 * Get all accounts of a customer
	 * @return a list of the customer's accounts 
	 */
	public List<SavingsAccount> getAccounts(){
		return accounts;
	}
	
	/**
	 * Get account for a customer 
	 * with right ID number 
	 * @param id the customer ID with connecting to the account
	 * @return accounts which connected with a customer ID
	 */
	public SavingsAccount getAccount(int id){
		return accounts.get(id);
	}
	
	/**
	 * print customer's information such as name and ID no. 
	 * @return customer name and ID no
	 */
	public String getCustomerInfo() {
		return getForename() + " " +  getSurname() + " " + getIdNo();
	}
	
	/**
	 * check if an account does exist or not 
	 * @param accountNumber which is checked
	 * @return check against account list
	 */
	public int findAccount(int accountNumber){
		for (int i = 0 ; i < accounts.size() ; i++){
			if ( accounts.get(i).getAccountNumber() == accountNumber){
				return i;
			}
		}
			return -1;
	}
	
	/**
	 * check if an account does exist and then delete it 
	 * @param accountNumber which is checked
	 */
	public void closeAccount(int accountNumber) {
		accounts.remove(findAccount(accountNumber));
	}
	
}
