package pers.zyx.exe01;

public class PayrollSystem {
	public static void main(String[] args) {
		Employee employees[] = new Employee[2];
		
		employees[0] = new SalariedEmployee("��ɭ",1002,new MyDate(1992,2,28),10000);
		employees[1] = new HourlyEmployee("����",2001,new MyDate(1998,4,5),50,240);
		
		for(int i = 0; i < employees.length; i++) {
			System.out.println(employees[i].toString());
			double salary = employees[i].earnings();
			System.out.println("�¹���Ϊ:"+salary);
			System.out.println();
		}
	}
}
