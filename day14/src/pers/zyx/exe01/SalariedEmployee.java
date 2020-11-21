package pers.zyx.exe01;

public class SalariedEmployee extends Employee {
	private double monthlySalary;
	
	
	public double getMonthlySalary() {
		return monthlySalary;
	}

	public void setMonthlySalary(double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}

	public SalariedEmployee(String name, int number, MyDate birthday,double monthlySalary) {
		super(name,number,birthday);
		this.monthlySalary = monthlySalary;
	}

	@Override
	public double  earnings() {
		// TODO Auto-generated method stub
		return monthlySalary;
	}
	
	public String toString() {
		return "SalariedEmployee["+super.toString()+"]";
	}
	
}
