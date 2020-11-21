package pers.zyx.exe02;

import pers.zyx.exe01.Account;

public class Customer {
	private String firstName;
	private String lastName;
	private Account1 account;
	
	public Customer(String f,String l) {
		this.firstName=f;
		this.lastName=l;
	}

	public String getFirstName() {
		return firstName;
	}

	
	public String getLastName() {
		return lastName;
	}
	
	public Account1 getAccount1() {
		return account;
	}
	
	public void setAccount1(Account1 account) {
		this.account=account;
	}

}
