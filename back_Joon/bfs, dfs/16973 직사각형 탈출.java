import java.util.*;
import java.io.*;

public class Main {
	static int N, M, map[][], startR, startC, endR, endC, H, W;
	static int d[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

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
		st = new StringTokenizer(in.readLine());
		H = stoi(st.nextToken());
		W = stoi(st.nextToken());
		startR = stoi(st.nextToken()) - 1;
		startC = stoi(st.nextToken()) - 1;
		endR = stoi(st.nextToken()) - 1;
		endC = stoi(st.nextToken()) - 1;
		System.out.println(bfs());
	}

	static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		boolean vit[][] = new boolean[N][M];
		vit[startR][startC] = true;
		q.add(new int[] { startR, startC, 0 });
		while (!q.isEmpty()) {
			int cur[] = q.poll();
			if (cur[0] == endR && cur[1] == endC) {
				return cur[2];
			}
			for (int k = 0; k < 4; k++) {
				int nr = cur[0] + d[k][0];
				int nc = cur[1] + d[k][1];
				if (nr < 0 || (nr + H) > N || nc < 0 || (nc + W) > M || vit[nr][nc] || map[nr][nc] == 1)
					continue;
				if (!check(nr, nc))
					continue;
				vit[nr][nc] = true;
				q.add(new int[] { nr, nc, cur[2] + 1 });
			}
		}
		return -1;
	}

	static boolean check(int r, int c) {
		for (int i = r; i < r + H; i++) {
			for (int j = c; j < c + W; j++) {
				if (map[i][j] == 1) {
					return false;
				}
			}
		}
		return true;
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}