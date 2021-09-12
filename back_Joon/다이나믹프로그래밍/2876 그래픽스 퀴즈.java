import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = stoi(st.nextToken());
		int dp[][] = new int[N+1][6];
		int maxnum=0;
		int grade=0;
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(in.readLine());
			int a=stoi(st.nextToken());
			int b=stoi(st.nextToken());
			dp[i][a]=dp[i-1][a]+1;
			dp[i][b]=dp[i-1][b]+1;
			if(dp[i][a] > maxnum) {
				maxnum=dp[i][a];
				grade=a;
			}else if(dp[i][a] == maxnum && i<grade) {
				grade=a;
			}
			if(dp[i][b]>maxnum) {
				maxnum=dp[i][b];
				grade=b;
			}else if(dp[i][b] == maxnum && i<grade) {
				grade=b;
			}
		}
		System.out.println(maxnum+" "+grade);
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}