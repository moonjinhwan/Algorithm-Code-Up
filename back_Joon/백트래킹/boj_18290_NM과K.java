import java.io.*;
import java.util.*;

public class boj_18290_NM°úK {
	static int N, M, K, matrix[][], answer = -987654321, d[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		K = stoi(st.nextToken());

		matrix = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				matrix[i][j] = stoi(st.nextToken());
			}
		}
		dfs(0, 0, new boolean[N][M], 0);
		System.out.println(answer);
	}

	static void dfs(int idx, int cnt, boolean v[][], int s) {
		if (cnt == K) {
			answer = Math.max(answer, s);
			return;
		}
		for (int i = idx; i < M * N; i++) {
			int r = i / M;
			int c = i % M;
			if (able(r, c, v)) {
				v[r][c] = true;
				dfs(i + 1, cnt + 1, v, s + matrix[r][c]);
				v[r][c] = false;
			}
		}
	}

	static boolean able(int r, int c, boolean[][] v) {
		for (int k = 0; k < 4; k++) {
			int nr = r + d[k][0];
			int nc = c + d[k][1];
			if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
				continue;
			}
			if (v[nr][nc]) {
				return false;
			}
		}
		return true;
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}