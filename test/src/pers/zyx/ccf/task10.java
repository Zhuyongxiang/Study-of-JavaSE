package pers.zyx.ccf;
import java.util.Scanner;


//201909-2 С����ƻ��������

public class task10 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int T = 0;//����ƻ������ʣ�µ�ƻ������
		int D = 0;//����ƻ�������ƻ�����Ŀ���
		int E = 0;//������������������ƻ���������������
		int[] flag = new int[n];//��¼��i������û�з������䣬1��ʾ�е��䣬0��ʾû�е���
		int list[] = new int[n];//���ڴ���е���ƻ�����ı��
		int index = 0;
		for(int i = 0; i < n ;i++) {
			int times = input.nextInt();//��ÿһ��ƻ�����Ĳ�������
			int ans = input.nextInt();//����ʣ��������ʼ��Ϊ��һ�μ�¼
			int value = 0;
			for(int k = 0;k<times-1;k++) {
				value = input.nextInt();
				if(value>0) {//��ʾ���ܷ������䣬��¼����ƻ�����ϵ�ƻ������
					if(value<ans) {//��ʾƻ���е���
						ans = value;//����ƻ�����ϵ�ƻ������
						flag[i] = 1;
					}else {
						continue;
					}
				}else if(value<=0) {//��ʾ�߹�����
					ans = ans+value;
				}
			}
			T+=ans;
		}
		for(int i = 0;i<n;i++) {
			if(flag[i]==1) {
				list[index++] = i+1;
				D++;
			}
		}
		if(D<3) {
			E = 0;
		}else {
			int first = 0;
			int second = 0;
			int third = 0;
			for(int i =0;i<D;i++) {
				if(i==D-2) {
					first = list[i];
					second = list[i+1];
					third = list[0];
				}else if(i==D-1) {
					first = list[i];
					second = list[0];
					third = list[1];
				}else {
					first = list[i];
					second = list[i+1];
					third = list[i+2];
				}
				if((second-first==1 || second-first==-(n-1))&&
						(third-second==1 || third-second==-(n-1))) {
					E++;
				}else {
					continue;
				}
			}
		}
		System.out.println(T+" "+D+" "+E);
	}
}
