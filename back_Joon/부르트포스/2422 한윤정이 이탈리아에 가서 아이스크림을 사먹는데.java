import java.util.*;
import java.io.*;

public class Main {
	static int N, M, map[][], count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		map = new int[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int u = stoi(st.nextToken());
			int v = stoi(st.nextToken());
			map[u][v] = 1;
			map[v][u] = 1;
		}
		dfs(0, new int[3], 1);
		System.out.println(count);
	}

	static void dfs(int saveIdx, int save[], int start) {
		if (saveIdx == 3) {
			if (map[save[0]][save[1]] == 1 || map[save[1]][save[2]] == 1 || map[save[0]][save[2]] == 1)
				return;
			count++;
			return;
		}
		for (int i = start; i <= N; i++) {
			save[saveIdx] = i;
			dfs(saveIdx + 1, save, i + 1);
		}
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}