package pers.zyx.exe02;

public class Account1 {
	private double balance;
	
	public Account1(double init_balance) {
		this.balance=init_balance;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void deposit(double amt) {
		if(amt>0) {
			balance+=amt;
			System.out.println("��Ǯ�ɹ���");
		}
	}
	
	public void withdraw(double amt) {
		if(balance>=amt) {
			balance-=amt;
			System.out.println("ȡǮ�ɹ���");
		}else {
			System.out.println("���㣡");
		}
	}
}
