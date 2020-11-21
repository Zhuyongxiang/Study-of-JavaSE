package pers.zyx.ccf;

import java.io.*;
import java.util.*;

//201809-2 买菜
public class task15 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int low = 0, high = 0;
		int value = 0;
		int ans = 0;
		String line = "";
		String data[];
		int[] values = new int[1000000];
		int index = 0;
		int count=0;
		String n_str = reader.readLine();
		int n = Integer.parseInt(n_str);
		for (int i = 0; i < n; i++) {
			line = reader.readLine();
			data = line.split(" ");
			low = Integer.parseInt(data[0]);
			high = Integer.parseInt(data[1]);
			value = low;
			while (value < high) {
				values[index++] = value;
				value++;
			}
		}
		count = index;	//数组中的实际个数
		index = 0;		//重置index
		for (int i = 0; i < n; i++) {
			line = reader.readLine();
			data = line.split(" ");
			low = Integer.parseInt(data[0]);
			high = Integer.parseInt(data[1]);
			value = low;
			while(index<count && value<high) {
				if(values[index]<value) {
					index++;
				}else if(values[index]>value) {
					value++;
				}else if(values[index]==value) {
					index++;
					value++;
					ans++;
				}
			}
		}
		System.out.println(ans);
	}

}
