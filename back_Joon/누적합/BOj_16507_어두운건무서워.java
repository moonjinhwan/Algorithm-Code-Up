import java.io.*;
import java.util.*;

public class BOj_16507_어두운건무서워{
	static int grid[][], dp[][];
	static int N, M, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		K = stoi(st.nextToken());
		grid = new int[N + 1][M + 1];
		dp = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				grid[i][j] = stoi(st.nextToken());
			}
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				dp[i][j] = dp[i][j-1]+dp[i-1][j] - dp[i-1][j-1]+grid[i][j];
			}
		}
		StringBuilder sb = new StringBuilder();
		while (K-- > 0) {
			st = new StringTokenizer(br.readLine());
			int r1 = stoi(st.nextToken());
			int c1 = stoi(st.nextToken());
			int r2 = stoi(st.nextToken());
			int c2 = stoi(st.nextToken());
			int sum = dp[r2][c2] - dp[r2][c1 - 1] - dp[r1 - 1][c2] + dp[r1 - 1][c1 - 1];
			int n = (r2-r1+1)*(c2-c1+1);
			sb.append(sum/n).append("\n");
		}
		System.out.println(sb);
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}