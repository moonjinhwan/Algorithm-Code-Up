import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = stoi(st.nextToken());
		int M = stoi(st.nextToken());
		int map[][] = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 1; j <= N; j++) {
				int temp = stoi(st.nextToken());
				map[i][j] = temp + map[i][j - 1] + map[i - 1][j] - map[i - 1][j - 1];
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int r1=stoi(st.nextToken());
			int c1 =stoi(st.nextToken());
			int r2=stoi(st.nextToken());
			int c2=stoi(st.nextToken());
			int result = map[r2][c2] - map[r2][c1-1]-(map[r1-1][c2]-map[r1-1][c1-1]);
			sb.append(result+"\n");
		}
		System.out.println(sb.toString());
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}
