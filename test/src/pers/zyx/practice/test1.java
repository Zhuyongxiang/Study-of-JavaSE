package pers.zyx.practice;
import java.util.Scanner;
public class test1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		int shuru[]=new int[n+1];		//存放n个人的崇拜对象
		shuru[0]=-1;
		for(int i=1;i<=n;i++) {
			shuru[i]=input.nextInt();		//存放每个人当前拥有的票数
		}
		int piaoshu[]=new int[n+1];
		piaoshu[0]=-1;
		for(int i=1;i<=n;i++) {
			piaoshu[i]=1;					//初始化每个人至少有来自自己的那一票
		}
		/*选择从后往前访问和修改数组，原因是排在后面的人可能崇拜排在其前面的人，排在前面的人的票数会受到后面的人的影响
		 * 逆序访问数组方可解决此问题*/
		for(int i=n;i>=1;i--) {
			if(shuru[i]!=0) {	/*shuru[i]等于0，说明没有崇拜对象，能得到的最大票数就是当前拥有的票数。shuru[i]
			不等于0，说明此人所有崇拜的人，崇拜的人的票数应该加上此人当前的票数*/	
			//piaoshu[shuru[i]]表示第i个人所崇拜的人的当前票数
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

初始化，5个人的当前票数为：1 1 1 1 1
逆序遍历数组：
（1）第五人崇拜第一人，第一人票数加上第五人的当前票数，
此时当前票数为：2 1 1 1 1
（2）第四人崇拜第三人，第三人票数加上第四人的当前票数，
此时当前票数为：2 1 2 1 1
（3）第三人崇拜第二人，第二人票数加上第三人的当前票数，
此时当前票数为：2 3 2 1 1
（4）第二人崇拜第一人，第一人票数加上第二人的当前票数，
此时当前票数为：5 3 2 1 1
（5）第五人无崇拜对象，不变
遍历完成，最终每个人能得到的最多票数为：5 3 2 1 1 

*/
