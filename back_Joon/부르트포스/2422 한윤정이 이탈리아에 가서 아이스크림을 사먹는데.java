import java.util.*;
import java.io.*;

public class Main {
	static int N, M, map[][], count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		boolean visit[] = new boolean[N + 1];
		map = new int[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int u = stoi(st.nextToken());
			int v = stoi(st.nextToken());
			map[u][v] = 1;
			map[v][u] = 1;
		}
		dfs(0, new boolean[N + 1], new int[3], 1);
		System.out.println(count);
	}

	static void dfs(int dep, boolean visit[], int arr[], int start) {
		if (dep == 3) {
			if (map[arr[0]][arr[1]] == 1 || map[arr[1]][arr[2]] == 1 || map[arr[0]][arr[2]] == 1)
				return;
			count++;
			return;
		}
		for (int i = start; i <= N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				arr[dep] = i;
				dfs(dep + 1, visit, arr, i + 1);
				visit[i] = false;
			}
		}
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}