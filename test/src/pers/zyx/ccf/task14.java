package pers.zyx.ccf;

//202006-2 œ° ËœÚ¡ø
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;

public class task14 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String str = input.readLine();
		String data[] = str.split(" ");
		int n = Integer.parseInt(data[0]);
		int a = Integer.parseInt(data[1]);
		int b = Integer.parseInt(data[2]);
		HashMap map = new HashMap();
		String line="";
		String value[] = new String[2];
		int dim,val;
		long ans = 0L;
		for(int i =0;i<a;i++) {
			line = input.readLine();
			value = line.split(" ");
			dim = Integer.parseInt(value[0]);
			val = Integer.parseInt(value[1]);
			map.put(dim, val);
		}
		for(int i =0;i<b;i++) {
			line = input.readLine();
			value = line.split(" ");
			dim = Integer.parseInt(value[0]);
			val = Integer.parseInt(value[1]);
			if(map.containsKey(dim)) {
				ans +=(int)map.get(dim)*val;
			}
		}
		System.out.println(ans);
	}
}
