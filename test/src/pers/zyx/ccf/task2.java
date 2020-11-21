package pers.zyx.ccf;

import java.util.Scanner;

//ISBNºÅÂë

public class task2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String in = input.nextLine();
		int sum=0;
		String ans;
		sum = Integer.parseInt(in.substring(0, 1))*1+Integer.parseInt(in.substring(2, 3))*2
				+Integer.parseInt(in.substring(3, 4))*3+Integer.parseInt(in.substring(4, 5))*4
				+Integer.parseInt(in.substring(6, 7))*5+Integer.parseInt(in.substring(7, 8))*6
				+Integer.parseInt(in.substring(8, 9))*7+Integer.parseInt(in.substring(9, 10))*8
				+Integer.parseInt(in.substring(10, 11))*9;
		int mod = sum%11;
		if(mod==10) {
			ans="X";
		}
		else {
			ans =""+mod;
		}
		if(ans.equals(in.substring(12, 13))) {
			System.out.println("Right");
		}
		else {
			StringBuffer buf = new StringBuffer(in);
			buf.delete(12, 13);
			buf.append(ans);
			System.out.println(buf.toString());
		}
	}
}
