import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = stoi(st.nextToken());
		st = new StringTokenizer(in.readLine());
		int arr[] = new int[N];
		int dp[] = new int[N];
		int ans = 1;
		for(int i=0;i<N;i++) {
			arr[i] = stoi(st.nextToken());
			dp[i] = 1;
			for(int j=i-1; j>=0; j--) {
				if(arr[i] < arr[j] && dp[i] <= dp[j] ) {
					dp[i] = dp[j] + 1;
					ans = Math.max(ans, dp[i]);
				}
			}
		}
		System.out.println(N-ans);
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}