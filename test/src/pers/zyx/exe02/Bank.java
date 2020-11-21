package pers.zyx.exe02;

public class Bank {
	private Customer[] Customers;
	private int numOfCustomers;
	
	public Bank() {
		Customers = new Customer[10];
	}
	
	public void addCustomer(String f,String l) {
		Customer newCust = new Customer(f,l);
		Customers[numOfCustomers++]=newCust;
	}
	
	public int getNumOfCustomer() {
		return numOfCustomers;
	}
	
	public Customer getCustomer(int index) {
		if(index>=0 && index<numOfCustomers) {
			return Customers[index];
		}
		return null;
	}
}
