package pers.zyx.ccf;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//201912-2 回收站选址
public class task13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		List list = new LinkedList();
		List trashList = new LinkedList();
		int count0 = 0, count1 = 0, count2 = 0, count3 = 0, count4 = 0;
		String t = "", b = "", l = "", r = "", lt = "", lb = "", rt = "", rb = "";
		String num = input.nextLine();
		int n = Integer.parseInt(num);
		for (int i = 0; i < n; i++) {
			String str = input.nextLine();
			list.add(str);
		}
		for (int i = 0; i < n; i++) {
			String str = (String) list.get(i);
			String data[] = str.split(" ");
			int x = Integer.parseInt(data[0]);
			int y = Integer.parseInt(data[1]);
			t = x + " " + (y + 1);
			b = x + " " + (y - 1);
			l = (x - 1) + " " + y;
			r = (x + 1) + " " + y;
			if (list.contains(new String(t)) && list.contains(new String(b)) && list.contains(new String(l))
					&& list.contains(new String(r))) {// 回收站
				trashList.add(str);
			}
		}

		for (int i = 0; i < trashList.size(); i++) {
			int count = 0;
			String str = (String) trashList.get(i);
			String data[] = str.split(" ");
			int x = Integer.parseInt(data[0]);
			int y = Integer.parseInt(data[1]);
			lt = (x - 1) + " " + (y + 1);
			lb = (x - 1) + " " + (y - 1);
			rt = (x + 1) + " " + (y + 1);
			rb = (x + 1) + " " + (y - 1);
			if (list.contains(new String(lt))) {
				count++;
			}
			if (list.contains(new String(lb))) {
				count++;
			}
			if (list.contains(new String(rt))) {
				count++;
			}
			if (list.contains(new String(rb))) {
				count++;
			}
			if (count == 0) {
				count0++;
			} else if (count == 1) {
				count1++;
			} else if (count == 2) {
				count2++;
			} else if (count == 3) {
				count3++;
			} else if (count == 4) {
				count4++;
			}
		}
		System.out.println(count0);
		System.out.println(count1);
		System.out.println(count2);
		System.out.println(count3);
		System.out.println(count4);
	}

}
