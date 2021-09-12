import java.util.*;
import java.io.*;

public class Main {
	static Set<Integer> set;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N, M, a, b, INF = Integer.MAX_VALUE;
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		int arr[] = new int[M];
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<M;i++) {
			arr[i] = stoi(st.nextToken());
		}
		int dp[] = new int[N + 1];
		set = new HashSet<>();
		for(int i=1; i<3; i++) {
			combine(i, arr, 0, 0, 0);
		}
		for(int x: set) {
			if(x<=N)
				dp[x] = 1;
		}
		for (int i = 0; i <= N; i++) {
			if(set.contains(i)) continue;
			int minval = INF; 
			for(int x: set) {
				if(i-x > 0 && dp[i-x]!=INF) {
					minval = Math.min(minval, dp[i-x]+1);
				}
			}
			dp[i] = minval;
		}
		if(dp[N]==INF)
			System.out.println(-1);
		else
			System.out.println(dp[N]);
	}
	static void combine(int len, int arr[], int arrIdx, int selNum, int sum) {
		if(len == selNum) {
			set.add(sum);
			return;
		}
		
		for(int i=arrIdx; i<arr.length; i++) {
			combine(len, arr, i+1, selNum+1, sum+arr[i]);
		}
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}