package pers.zyx.collection;

import java.util.*;

public class CollectionTest {
	Collection c1 = new ArrayList();
	Collection c2 = new HashSet();

	public CollectionTest() {
		Student ZhangSan = new Student("����", 90);
		c1.add(ZhangSan);
		c1.add("����");
		c1.add("����");
		c1.add(new Student("����", 86));
		c1.add(new Student("����", 78));
		c1.add(ZhangSan);
		printCollection(c1);
		c1.remove(ZhangSan);
		c1.remove("����");
		printCollection(c1);
		c2.add(ZhangSan);
		c2.add("����");
		printCollection(c2);
		c2.addAll(c1);
		printCollection(c2);
	}

	private void printCollection(Collection c) {
		System.out.println("-------------------");
		Iterator it = c.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CollectionTest();
	}

}
