package pers.zyx.ccf;

import java.util.*;

//201903-2 二十四点

public class task5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String geshu = input.nextLine();
		int n = Integer.parseInt(geshu);	//不能直接用nextInt
		int jieguo[] = new int[n];			//用于存储每一行的计算结果
		for (int i = 0; i < n; i++) {
			String str = input.nextLine();
			String ans = Tohouzhui(str);
			int res = jisuan(ans);
			jieguo[i] =res;
		}
		for(int i=0;i<n;i++) {			//结果为24输出Yes,否则输出No
			if(jieguo[i]==24) {
				System.out.println("Yes");
			}
			else {
				System.out.println("No");
			}
		}
	}

	public static String Tohouzhui(String str1) {	//中缀表达式转为后缀表达式
		StringBuffer str2 = new StringBuffer();		//存储后缀表达式
		str2.append(str1.substring(0, 1));	//第一个字符（数字字符）和第三个字符（数字字符）直接加入后缀表达式
		str2.append(str1.substring(2, 3));
		Stack s = new Stack();		//用于存储运算符
		s.push(str1.substring(1, 2));//第二个字符为第一个运算符，直接入栈
		while (!s.isEmpty() && priority(s.peek().toString()) >= priority(str1.substring(3, 4).toString())) {
			//若第四个字符（运算符）的优先级比栈顶运算符的优先级高，栈顶运算符出栈并加入后缀表达式，直到栈顶元素运算符优先级比第四个字符（运算符）的优先级低
			str2.append(s.pop().toString());
		}
		s.push(str1.substring(3, 4));//第四个字符（运算符）入栈
		str2.append(str1.substring(4, 5));
		while (!s.isEmpty() && priority(s.peek().toString()) >= priority(str1.substring(5, 6).toString())) {
			//若第六个字符（运算符）的优先级比栈顶运算符的优先级高，栈顶运算符出栈并加入后缀表达式，直到栈顶元素运算符优先级比第六个字符（运算符）的优先级低
			str2.append(s.pop().toString());
		}
		s.push(str1.substring(5, 6));//第六个字符（运算符）入栈
		str2.append(str1.substring(6, 7));//第七个字符加入后缀表达式
		while (!s.isEmpty()) {
			str2.append(s.pop().toString());	//将栈中剩余字符加入后缀表达式
		}
		return str2.toString();
	}

	public static int jisuan(String str2) {
		int ans = 0;	//存储计算结果
		int temp = 0;	//存储中间结果
		Stack stack = new Stack();	//计算栈
		for (int i = 0; i < str2.length(); i++) {
			String str = str2.substring(i, i + 1).toString();
			char ch = str2.charAt(i);
			if (ch <= '9' && ch >= '1') {		//数字入栈
				int flag = Integer.parseInt(str);
				stack.push(flag);
			} else {		//当前字符是运算符，栈中两个对象出栈，并计算，计算结果入栈
				int a = (int) stack.pop();
				int b = (int) stack.pop();
				if (str.equals("+")) {
					temp = b + a;
					stack.push(temp);
				} else if (str.equals("-")) {
					temp = b - a;
					stack.push(temp);
				} else if (str.equals("x")) {
					temp = b * a;
					stack.push(temp);
				} else if (str.equals("/")) {
					temp = b / a;
					stack.push(temp);
				}
			}
		}
		ans = (int) stack.pop();
		return ans;
	}

	public static int priority(String str)// 用于比较优先级
	{
		if (str.equals("+") || str.equals("-"))
			return 1;
		else {
			return 2;
		}
	}

}
