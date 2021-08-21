import java.util.*;
import java.io.*;

public class Main {
	static char map[][];
	static int maxdep=0;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = stoi(st.nextToken());
		map = new char[7][N];
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = 'A';
			}
		}
		dfs(0, 0, N - 1);
		for(int i=maxdep; i<7; i++)
			map[i][N-1]='B';
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < map.length; i++) {
			sb.append(String.valueOf(map[i])).append("\n");
		}
		System.out.println(sb.toString());
	}

	static void dfs(int dep, int l, int r) {
		if (l == r) {
			maxdep=Math.max(dep, maxdep);
			return;
		}
		int mid = (l + r) / 2;
		change(dep, l, mid);
		dfs(dep + 1, l, mid);
		dfs(dep + 1, mid + 1, r);
	}

	static void change(int dep, int l, int r) {
		for (int i = l; i <= r; i++) {
			map[dep][i] = map[dep][i] == 'A' ? 'B' : 'A';
		}
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}