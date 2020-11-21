package pers.zyx.ccf;
import java.util.Scanner;


//201909-2 小明种苹果（续）

public class task10 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int T = 0;//所有苹果树上剩下的苹果总数
		int D = 0;//发生苹果掉落的苹果树的棵树
		int E = 0;//相邻连续三棵树发生苹果掉落情况的组数
		int[] flag = new int[n];//记录第i棵树有没有发生掉落，1表示有掉落，0表示没有掉落
		int list[] = new int[n];//用于存放有掉落苹果树的编号
		int index = 0;
		for(int i = 0; i < n ;i++) {
			int times = input.nextInt();//对每一棵苹果树的操作次数
			int ans = input.nextInt();//最终剩余量，初始化为第一次记录
			int value = 0;
			for(int k = 0;k<times-1;k++) {
				value = input.nextInt();
				if(value>0) {//表示可能发生掉落，记录的是苹果树上的苹果数量
					if(value<ans) {//表示苹果有掉落
						ans = value;//更新苹果树上的苹果数量
						flag[i] = 1;
					}else {
						continue;
					}
				}else if(value<=0) {//表示蔬果操作
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
