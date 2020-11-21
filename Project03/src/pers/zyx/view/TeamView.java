package pers.zyx.view;

import pers.zyx.domain.Employee;
import pers.zyx.domain.Programmer;
import pers.zyx.service.NameListService;
import pers.zyx.service.TeamException;
import pers.zyx.service.TeamService;

public class TeamView {
	private NameListService listSvc = new NameListService();
	private TeamService teamSvc = new TeamService();

	private void enterMainMenu() {
		boolean loopFlag = true;
		while (loopFlag) {
			char menu = 0;
			if (menu != '1') {
				listAllEmployees();
			}
			System.out.print("1-�Ŷ��б�  2-����Ŷӳ�Ա  3-ɾ���Ŷӳ�Ա  4-�˳�  ��ѡ��(1-4):");
			menu = TSUtility.readMenuSelectionn();
			switch (menu) {
			case '1':
				getTeam();
				break;
			case '2':
				addMember();
				break;
			case '3':
				deleteMember();
				break;
			case '4':
				System.out.print("ȷ���Ƿ��˳�(Y/N):");
				char isExit = TSUtility.readConfirmSelection();
				if (isExit == 'Y') {
					loopFlag = false;
				}
				break;
			}

		}
	}

	private void listAllEmployees() {
		System.out.println("--------------------�����Ŷӵ������--------------------");
		Employee employees[] = listSvc.getAllEmployees();
		if (employees == null || employees.length == 0) {
			System.out.println("��˾��û���κ�Ա����Ϣ��");
		} else {
			System.out.println("ID\t����\t����\t����\tְλ\t״̬\t����\t��Ʊ\t�����豸");
			for (int i = 0; i < employees.length; i++) {
				System.out.println(employees[i]);
			}
		}
		System.out.println("-----------------------------------------------------");
	}

	private void getTeam() {
		System.out.println("-------------------�Ŷӳ�Ա�б�---------------------");
		Programmer team[] = teamSvc.getTeam();
		if (team == null || team.length == 0) {
			System.out.println("�����Ŷ�Ŀǰû�г�Ա��");
		} else {
			System.out.println("TID/ID\t����\t����\t����\tְλ\t����\t��Ʊ\n");
			for (int i = 0; i < team.length; i++) {
				System.out.println(team[i].getDetailsForTeam());
			}
		}

		System.out.println("--------------------------------------------------");
	}

	private void addMember() {
		System.out.println("--------------------��ӳ�Ա--------------------");
		System.out.print("������Ҫ��ӵ�Ա��ID");
		int id = TSUtility.readInt();
		try {
			Employee emp = listSvc.getEmployee(id);
			teamSvc.addMember(emp);
			System.out.println("��ӳɹ�");
		} catch (TeamException e) {
			// TODO Auto-generated catch block
			System.out.println("���ʧ�ܣ�ԭ��" + e.getMessage());
		}
		TSUtility.readReturn();
	}

	private void deleteMember() {
		System.out.println("--------------------ɾ����Ա--------------------");
		System.out.print("������Ҫɾ��Ա����TID:");
		int memberId = TSUtility.readInt();
		System.out.print("ȷ���Ƿ�ɾ��(Y/N):");
		char isDelete = TSUtility.readConfirmSelection();
		if(isDelete == 'N') {
			return;
		}
		
		try {
			teamSvc.removeMember(memberId);
			System.out.println("ɾ���ɹ�");
		} catch (TeamException e) {
			System.out.println("ɾ��ʧ�ܣ�ԭ��: " + e.getMessage());
		}
		TSUtility.readReturn();
	}

	public static void main(String[] args) {
		TeamView view = new TeamView();
		view.enterMainMenu();
	}
}
