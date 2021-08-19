import java.util.*;
import java.io.*;

public class Main {
	static int map[][], N, M, D[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }, total = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = stoi(st.nextToken());
			}
		}
		dfs(0, 0, 0);
		System.out.println(total);
	}

	static void dfs(int r, int c, int dep) {
		if (dep == 2) {
			solve();
			return;
		}
		for (int i = r; i < map.length; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] ==0) {
					map[i][j] = 1;
					dfs(i, j, dep+1);
					map[i][j] = 0;
				}
			}
		}
	}

	static void solve() {
		boolean visit[][] = new boolean[N][M];
		int cnt = 0;
		for (int i = 0; i < visit.length; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 2 && !visit[i][j]) {
					cnt += bfs(visit, i, j);
				}
			}
		}
		total = Math.max(total, cnt);
	}

	static int bfs(boolean visit[][], int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		visit[r][c] = true;
		q.add(new int[] { r, c});
		boolean findzero = false;
		int cnt = 1;
		while (!q.isEmpty()) {
			int cur[] = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + D[i][0];
				int nc = cur[1] + D[i][1];
				if (boundCheck(nr, nc) || visit[nr][nc] || map[nr][nc] == 1)
					continue;
				if (map[nr][nc] == 0) {
					findzero = true;
					continue;
				}
				visit[nr][nc] = true;
				q.add(new int[] { nr, nc });
				++cnt;
			}
		}
		if (findzero) {
			return 0;
		} else
			return cnt;
	}

	static boolean boundCheck(int a, int b) {
		if (a < 0 || a >= N || b < 0 || b >= M)
			return true;
		return false;
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}