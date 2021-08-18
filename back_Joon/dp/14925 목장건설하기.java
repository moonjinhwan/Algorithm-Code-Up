import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int ROW = stoi(st.nextToken());
		int COL = stoi(st.nextToken());
		int map[][] = new int[ROW + 1][COL + 1];
		int dp[][] = new int[ROW + 1][COL + 1];
		int answer = 0;
		for (int i = 1; i <= ROW; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 1; j <= COL; j++) {
				map[i][j] = stoi(st.nextToken());
			}
		}
		for (int i = 1; i <= ROW; i++) {
			for (int j = 1; j <= COL; j++) {
				if (map[i][j] >= 1)
					continue;
				int val1 = Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
				int val2 = Math.min(dp[i - 1][j - 1], dp[i][j - 1]);
				dp[i][j] = Math.min(val1, val2) + 1;
				answer = Math.max(answer, dp[i][j]);
			}
		}
		System.out.println(answer);
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}
//0들판, 1나무 2돌
//세로M 가로N
//정사각형 한변의길이는?