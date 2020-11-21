package pers.zyx.p2.ui;

import pers.zyx.p2.bean.Customer;
import pers.zyx.p2.service.CustomerList;
import pers.zyx.p2.util.CMUtility;;

public class CustomerView {
	private CustomerList customerList = new CustomerList(10);
	
	private void enterMainMenu() {
		boolean isFlag = true;
		while (isFlag) {
			System.out.println("\n-----------------�ͻ���Ϣ�������-----------------");
			System.out.println("                   1 ��ӿͻ�");
			System.out.println("                   2 �޸Ŀͻ�");
			System.out.println("                   3 ɾ���ͻ�");
			System.out.println("                   4 �ͻ��б�");
			System.out.println("                   5 ��         ��\n");
			System.out.println("                ��ѡ��(1-5): ");

			char menu = CMUtility.readMenuSelection();
			switch (menu) {
			case '1':
				addNewCustomer();
				break;
			case '2':
				modifyCustomer();
				break;
			case '3':
				deleteCustoemr();
				break;
			case '4':
				listAllCustomers();
				break;
			case '5':
				System.out.print("ȷ���Ƿ��˳�(Y/N):");
				char isExit = CMUtility.readConfirmSelection();
				if (isExit == 'Y') {
					isFlag = false;
				}
			}

		}

	}

	private void addNewCustomer() {
		System.out.println("-----------------��ӿͻ�-----------------");
		System.out.print("����:");
		String name=CMUtility.readString(10);
		System.out.print("�Ա�:");
		char gender=CMUtility.readChar();
		System.out.print("����:");
		int age=CMUtility.readInt();
		System.out.print("�绰:");
		String phone=CMUtility.readString(13);
		System.out.print("����:");
		String email=CMUtility.readString(30);
		
		Customer customer = new Customer(name,gender,age,phone,email);
		boolean isSuccess = customerList.addCustomer(customer);
		if(isSuccess) {
			System.out.println("-----------------������-----------------");
		}
		else {
			System.out.println("-----------------�ͻ�Ŀ¼���������ʧ�ܣ�-----------------");
		}
	}

	private void modifyCustomer() {
		System.out.println("----------------�޸Ŀͻ�-----------------");
		Customer cust;
		int number;
		for(;;) {
			System.out.print("��ѡ����޸Ŀͻ����(-1�˳�):");
			number=CMUtility.readInt();
			if(number==-1) {
				return;
			}
			cust = customerList.getCustomer(number-1);
			if(cust==null) {
				System.out.println("�޷��ҵ�ָ���Ŀͻ���");
			}
			else {
				break;
			}
		}
		System.out.println("����("+cust.getName()+"):");
		String name = CMUtility.readString(10,cust.getName());
		System.out.println("�Ա�("+cust.getGender()+"):");
		char gender=CMUtility.readChar(cust.getGender());
		System.out.println("����("+cust.getAge()+"):");
		int age = CMUtility.readInt(cust.getAge());
		System.out.println("�绰("+cust.getPhone()+"):");
		String phone = CMUtility.readString(13,cust.getPhone());
		System.out.println("����("+cust.getEmail()+"):");
		String email=CMUtility.readString(30,cust.getEmail());
	
		Customer newCust = new Customer(name, gender, age, phone, email);
		boolean isReplaced=customerList.replaceCustomer(number-1, newCust);
		if(isReplaced) {
			System.out.println("----------------�޸ĳɹ�----------------\n");
		}
		else {
			System.out.println("----------------�޸�ʧ��----------------\n");
		}
	}

	private void deleteCustoemr() {
		System.out.println("----------------ɾ���ͻ�----------------\n");
		
		int number;
		for(;;) {
			System.out.println("��ѡ���ɾ���ͻ����(-1�˳�):");
			number=CMUtility.readInt();
			if(number==-1) {
				return;
			}
			
			Customer customer = customerList.getCustomer(number-1);
			if(customer==null) {
				System.out.println("�޷��ҵ�ָ���ͻ�!");
			}
			else {
				break;
			}
		}
		
		System.out.print("ȷ���Ƿ�ɾ��(Y/N):");
		char isDelete = CMUtility.readConfirmSelection();
		if(isDelete=='Y') {
			boolean deleteSuccess = customerList.deleteCustomer(number-1);
			if(deleteSuccess) {
				System.out.println("----------------ɾ���ɹ�----------------\n");
			}
			else {
				System.out.println("----------------ɾ��ʧ��----------------\n");
			}
		}
		else {
			return;
		}
	}

	private void listAllCustomers() {
		System.out.println("-----------------�ͻ��б�-----------------\n");
		int total = customerList.getTotal();
		if (total == 0) {
			System.out.println("û�пͻ���¼!");
		} else {
			System.out.println("���\t����\t�Ա�\t����\t�绰\t\t����");
			Customer custs[] = customerList.getAllCustomers();
			for (int i = 0; i < custs.length; i++) {
				Customer cust = custs[i];
				System.out.println((i + 1) + "\t" + cust.getName() + "\t" + cust.getGender() + "\t" + cust.getAge()
						+ "\t" + cust.getPhone() + "\t" + cust.getEmail());
			}
		}
		
		System.out.println("----------------�ͻ��б����----------------\n");
	}

	public static void main(String[] args) {
		CustomerView view = new CustomerView();
		view.enterMainMenu();
	}
}
