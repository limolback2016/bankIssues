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
	
	public void setForename(String foreName){
		this.name = foreName;
	}
	
	public String getForename(){
		return this.name;
	}
	
	public void setSurname(String surName){
		this.surName = surName;
	}
	
	public String getSurname(){
		return this.surName;
	}
	
	// ID no should not be changed while it sets
	public String getIdNo(){
		return this.idNo;
	}
	
	// add account
	public void addAccount(SavingsAccount s){
		accounts.add(s);
	}
	
	// get account
	public List<SavingsAccount> getAccounts(){
		return accounts;
	}
	
	public SavingsAccount getAccount(int id){
		return accounts.get(id);
	}
	
	public String getCustomerInfo() {
		return getForename() + " " +  getSurname() + " " + getIdNo();
	}
	
	public int findAccount(int accountNumber){
		for (int i = 0 ; i < accounts.size() ; i++){
			if ( accounts.get(i).getAccountNumber() == accountNumber){
				return i;
			}
		}
			return -1;
	}
	
}
