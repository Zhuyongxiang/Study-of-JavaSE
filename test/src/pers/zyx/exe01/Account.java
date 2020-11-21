package pers.zyx.exe01;

public class Account {
	private int id;	//账号
	private double balance;	//余额
	private double annualInterestRate;//年利率
	
	public Account() {
		
	}
	
	public Account(int id, double balance, double annuallnterestRate) {
		this.id = id;
		this.balance = balance;
		this.annualInterestRate = annuallnterestRate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnuallnterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	
	public void withdraw(double ammount) {//取钱
		if(balance < ammount) {
			System.out.println("余额不足，取款失败！");
			return;
		}else {
			balance-=ammount;
			System.out.println("成功取出"+ammount);
		}
	}
	
	public void deposit(double ammount) {//存钱
		if(ammount>0) {
			balance+=ammount;
			System.out.println("成功存入"+ammount);
		}
	}
	
}
