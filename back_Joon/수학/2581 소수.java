import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = stoi(st.nextToken());
		st = new StringTokenizer(in.readLine());
		int M = stoi(st.nextToken());
		boolean memo[] = new boolean[M+1];
		memo[1]=true;
		for(int i=2; i<=M; i++) {
			int cnt=2;
			int val=cnt*i;
			while(val <= M) {
				memo[val] = true;
				val=i*(++cnt);
			}
		}
		int minval=Integer.MAX_VALUE;
		int sum = 0;
		for(int i=N; i<=M; i++) {
			if(!memo[i]) {
				sum+=i;
				minval=Math.min(minval, i);
			}
		}
		if(minval!=Integer.MAX_VALUE) {
			System.out.println(sum);
			System.out.println(minval);
		}else
			System.out.println(-1);
	}
	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}