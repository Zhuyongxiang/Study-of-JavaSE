package pers.zyx.exe01;

public class Account {
	private int id;	//�˺�
	private double balance;	//���
	private double annualInterestRate;//������
	
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
	
	public void withdraw(double ammount) {//ȡǮ
		if(balance < ammount) {
			System.out.println("���㣬ȡ��ʧ�ܣ�");
			return;
		}else {
			balance-=ammount;
			System.out.println("�ɹ�ȡ��"+ammount);
		}
	}
	
	public void deposit(double ammount) {//��Ǯ
		if(ammount>0) {
			balance+=ammount;
			System.out.println("�ɹ�����"+ammount);
		}
	}
	
}
