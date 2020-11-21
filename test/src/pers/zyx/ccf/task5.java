package pers.zyx.ccf;

import java.util.*;

//201903-2 ��ʮ�ĵ�

public class task5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String geshu = input.nextLine();
		int n = Integer.parseInt(geshu);	//����ֱ����nextInt
		int jieguo[] = new int[n];			//���ڴ洢ÿһ�еļ�����
		for (int i = 0; i < n; i++) {
			String str = input.nextLine();
			String ans = Tohouzhui(str);
			int res = jisuan(ans);
			jieguo[i] =res;
		}
		for(int i=0;i<n;i++) {			//���Ϊ24���Yes,�������No
			if(jieguo[i]==24) {
				System.out.println("Yes");
			}
			else {
				System.out.println("No");
			}
		}
	}

	public static String Tohouzhui(String str1) {	//��׺���ʽתΪ��׺���ʽ
		StringBuffer str2 = new StringBuffer();		//�洢��׺���ʽ
		str2.append(str1.substring(0, 1));	//��һ���ַ��������ַ����͵������ַ��������ַ���ֱ�Ӽ����׺���ʽ
		str2.append(str1.substring(2, 3));
		Stack s = new Stack();		//���ڴ洢�����
		s.push(str1.substring(1, 2));//�ڶ����ַ�Ϊ��һ���������ֱ����ջ
		while (!s.isEmpty() && priority(s.peek().toString()) >= priority(str1.substring(3, 4).toString())) {
			//�����ĸ��ַ���������������ȼ���ջ������������ȼ��ߣ�ջ���������ջ�������׺���ʽ��ֱ��ջ��Ԫ����������ȼ��ȵ��ĸ��ַ���������������ȼ���
			str2.append(s.pop().toString());
		}
		s.push(str1.substring(3, 4));//���ĸ��ַ������������ջ
		str2.append(str1.substring(4, 5));
		while (!s.isEmpty() && priority(s.peek().toString()) >= priority(str1.substring(5, 6).toString())) {
			//���������ַ���������������ȼ���ջ������������ȼ��ߣ�ջ���������ջ�������׺���ʽ��ֱ��ջ��Ԫ����������ȼ��ȵ������ַ���������������ȼ���
			str2.append(s.pop().toString());
		}
		s.push(str1.substring(5, 6));//�������ַ������������ջ
		str2.append(str1.substring(6, 7));//���߸��ַ������׺���ʽ
		while (!s.isEmpty()) {
			str2.append(s.pop().toString());	//��ջ��ʣ���ַ������׺���ʽ
		}
		return str2.toString();
	}

	public static int jisuan(String str2) {
		int ans = 0;	//�洢������
		int temp = 0;	//�洢�м���
		Stack stack = new Stack();	//����ջ
		for (int i = 0; i < str2.length(); i++) {
			String str = str2.substring(i, i + 1).toString();
			char ch = str2.charAt(i);
			if (ch <= '9' && ch >= '1') {		//������ջ
				int flag = Integer.parseInt(str);
				stack.push(flag);
			} else {		//��ǰ�ַ����������ջ�����������ջ�������㣬��������ջ
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

	public static int priority(String str)// ���ڱȽ����ȼ�
	{
		if (str.equals("+") || str.equals("-"))
			return 1;
		else {
			return 2;
		}
	}

}
