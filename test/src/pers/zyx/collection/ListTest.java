package pers.zyx.collection;

import java.util.*;

public class ListTest {
	public ListTest() {
		List list1 = new ArrayList();
		List list2 = new LinkedList();
		Student zhangsan = new Student("����", 90);
		System.out.println("----------[��ʾ1]˳�����Ԫ��----------");
		list1.add(0, zhangsan);
		list1.add(1, "����");
		list1.add(2, "����");
		list1.add(3, new Student("����", 80));
		list1.add(4, new Student("����", 70));
		list1.add(5, zhangsan);
		printCollection(list1);

		System.out.println("----------[��ʾ2]ɾ��Ԫ��----------");
		ListIterator it = list1.listIterator();
		while (it.hasNext()) {
			Object o = it.next();
			if (o instanceof String) {
				System.out.println("String����[" + o + "]---���б������");
				it.remove();
			}
		}
		printCollection(list1);
		System.out.println("----------[��ʾ3]�������Ԫ��----------");
		list2.add(0, zhangsan);
		list2.add(0, "����");
		printCollection(list2);
		System.out.println("----------[��ʾ4]�����б�----------");
		list2.addAll(0, list1);
		printCollection(list2);

		System.out.println("----------[��ʾ5]��λԪ��----------");
		System.out.println("�׸�[zhangsan]����λ��" + list2.indexOf(zhangsan));
		System.out.println("ĩ��[zhangsan]����λ��" + list2.lastIndexOf(zhangsan));

		System.out.println("----------[��ʾ6]��ȡ���б�----------");
		list1 = list2.subList(1, 5);
		printCollection(list1);
	}

	private void printCollection(List list) {
		ListIterator it = list.listIterator();
		int n = 0;
		while (it.hasNext()) {
			System.out.println(n + ":" + it.next());
			n++;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ListTest();
	}

}
