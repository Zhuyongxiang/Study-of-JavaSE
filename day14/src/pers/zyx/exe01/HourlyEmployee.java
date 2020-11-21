package pers.zyx.exe01;

public class HourlyEmployee extends Employee {
	private int wage;
	private int hour;

	public HourlyEmployee(String name, int number, MyDate birthday, int wage, int hour) {
		super(name,number,birthday);
		this.wage = wage;
		this.hour = hour;
	}
	
	@Override
	public double earnings() {
		// TODO Auto-generated method stub
		return wage*hour;
	}
	
	public String toString() {
		return "HourlyEmployee["+super.toString()+"]";
	}

}
