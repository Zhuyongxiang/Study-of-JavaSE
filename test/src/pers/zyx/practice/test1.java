package pers.zyx.practice;
import java.util.Scanner;
public class test1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		int shuru[]=new int[n+1];		//���n���˵ĳ�ݶ���
		shuru[0]=-1;
		for(int i=1;i<=n;i++) {
			shuru[i]=input.nextInt();		//���ÿ���˵�ǰӵ�е�Ʊ��
		}
		int piaoshu[]=new int[n+1];
		piaoshu[0]=-1;
		for(int i=1;i<=n;i++) {
			piaoshu[i]=1;					//��ʼ��ÿ���������������Լ�����һƱ
		}
		/*ѡ��Ӻ���ǰ���ʺ��޸����飬ԭ�������ں�����˿��ܳ��������ǰ����ˣ�����ǰ����˵�Ʊ�����ܵ�������˵�Ӱ��
		 * ����������鷽�ɽ��������*/
		for(int i=n;i>=1;i--) {
			if(shuru[i]!=0) {	/*shuru[i]����0��˵��û�г�ݶ����ܵõ������Ʊ�����ǵ�ǰӵ�е�Ʊ����shuru[i]
			������0��˵���������г�ݵ��ˣ���ݵ��˵�Ʊ��Ӧ�ü��ϴ��˵�ǰ��Ʊ��*/	
			//piaoshu[shuru[i]]��ʾ��i��������ݵ��˵ĵ�ǰƱ��
				piaoshu[shuru[i]]+=piaoshu[i];
			}
		}
		for(int i=1;i<=n;i++) {
			System.out.println(piaoshu[i]);
		}
	}
}


/*

5
0 1 2 3 1
5
3
2
1
1

��ʼ����5���˵ĵ�ǰƱ��Ϊ��1 1 1 1 1
����������飺
��1�������˳�ݵ�һ�ˣ���һ��Ʊ�����ϵ����˵ĵ�ǰƱ����
��ʱ��ǰƱ��Ϊ��2 1 1 1 1
��2�������˳�ݵ����ˣ�������Ʊ�����ϵ����˵ĵ�ǰƱ����
��ʱ��ǰƱ��Ϊ��2 1 2 1 1
��3�������˳�ݵڶ��ˣ��ڶ���Ʊ�����ϵ����˵ĵ�ǰƱ����
��ʱ��ǰƱ��Ϊ��2 3 2 1 1
��4���ڶ��˳�ݵ�һ�ˣ���һ��Ʊ�����ϵڶ��˵ĵ�ǰƱ����
��ʱ��ǰƱ��Ϊ��5 3 2 1 1
��5���������޳�ݶ��󣬲���
������ɣ�����ÿ�����ܵõ������Ʊ��Ϊ��5 3 2 1 1 

*/
