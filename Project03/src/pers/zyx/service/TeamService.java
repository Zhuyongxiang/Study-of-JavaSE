package pers.zyx.service;

import pers.zyx.domain.Architect;
import pers.zyx.domain.Designer;
import pers.zyx.domain.Employee;
import pers.zyx.domain.Programmer;

public class TeamService {
	private static int counter = 1;
	private final int MAX_MEMBER = 5;
	private Programmer team[] = new Programmer[MAX_MEMBER];
	private int total;

	public TeamService() {
		super();
	}

	public Programmer[] getTeam() {
		Programmer team[] = new Programmer[total];
		for (int i = 0; i < team.length; i++) {
			team[i] = this.team[i];
		}
		return team;
	}

	public void addMember(Employee e) throws TeamException {
		if (total >= MAX_MEMBER) {
			throw new TeamException("��Ա�������޷����");
		}
		if (!(e instanceof Programmer)) {
			throw new TeamException("�ó�Ա���ǿ�����Ա���޷���ӣ�");
		}
		if (isExist(e)) {
			throw new TeamException("��Ա�����ڱ������Ŷ��У�");
		}
		Programmer p = (Programmer) e;
		if ("BUSY".equals(p.getStatus().getNAME())) {
			throw new TeamException("��Ա������ĳ�Ŷӳ�Ա��");
		} else if ("VOCATION".equals(p.getStatus().getNAME())) {
			throw new TeamException("��ԱԱ�������ݼ٣��޷���ӣ�");
		}
		int numOfArch = 0, numOfDes = 0, numOfPro = 0;
		for (int i = 0; i < total; i++) {
			if (team[i] instanceof Architect) {
				numOfArch++;
			} else if (team[i] instanceof Designer) {
				numOfDes++;
			} else if (team[i] instanceof Programmer) {
				numOfPro++;
			}
		}
		if (p instanceof Architect) {
			if (numOfArch >= 1) {
				throw new TeamException("�Ŷ���֮��ֻ����һ���ܹ�ʦ��");
			}
		} else if (p instanceof Designer) {
			if (numOfDes >= 2) {
				throw new TeamException("�Ŷ���֮��ֻ�����������ʦ��");
			}
		} else if (p instanceof Programmer) {
			if (numOfPro >= 3) {
				throw new TeamException("�Ŷ���֮��ֻ������������Ա��");
			}
		}
		team[total++] = p;
		p.setStatus(Status.BUSY);
		p.setMemberId(counter++);
	}

	private boolean isExist(Employee e) {
		for (int i = 0; i < total; i++) {
			if (team[i].getId() == e.getId()) {
				return true;
			}
		}
		return false;
	}

	public void removeMember(int memberId) throws TeamException {
		int i = 0;
		for (; i < total; i++) {
			if(team[i].getMemberId()==memberId) {
				team[i].setStatus(Status.FREE);
				break;
			}
		}
		if(i==total) {
			throw new TeamException("�Ҳ���ָ����mumberId��Ա����ɾ��ʧ�ܣ�");
		}
		for(int j=i+1;j<total;j++) {
			team[j-1] = team[j];
		}
		team[--total] = null;
	}
}
