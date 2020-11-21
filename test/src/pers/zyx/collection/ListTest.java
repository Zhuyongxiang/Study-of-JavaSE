package pers.zyx.collection;

import java.util.*;

public class ListTest {
	public ListTest() {
		List list1 = new ArrayList();
		List list2 = new LinkedList();
		Student zhangsan = new Student("张三", 90);
		System.out.println("----------[演示1]顺序插入元素----------");
		list1.add(0, zhangsan);
		list1.add(1, "张三");
		list1.add(2, "李四");
		list1.add(3, new Student("王五", 80));
		list1.add(4, new Student("赵六", 70));
		list1.add(5, zhangsan);
		printCollection(list1);

		System.out.println("----------[演示2]删除元素----------");
		ListIterator it = list1.listIterator();
		while (it.hasNext()) {
			Object o = it.next();
			if (o instanceof String) {
				System.out.println("String对象[" + o + "]---从列表清除！");
				it.remove();
			}
		}
		printCollection(list1);
		System.out.println("----------[演示3]逆序插入元素----------");
		list2.add(0, zhangsan);
		list2.add(0, "李四");
		printCollection(list2);
		System.out.println("----------[演示4]插入列表----------");
		list2.addAll(0, list1);
		printCollection(list2);

		System.out.println("----------[演示5]定位元素----------");
		System.out.println("首个[zhangsan]对象位于" + list2.indexOf(zhangsan));
		System.out.println("末个[zhangsan]对象位于" + list2.lastIndexOf(zhangsan));

		System.out.println("----------[演示6]截取子列表----------");
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
