import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
	static int T, N, K, map[][];
	static ArrayList<Pair> list;
	static boolean visit[][];
	static int dr[] = { -1, 0, 1, 0 };
	static int dc[] = { 0, 1, 0, -1 };
	static int res;
	static class Pair {
		int r, c, t, d;

		public Pair(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		T = Integer.valueOf(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			N = Integer.valueOf(st.nextToken());
			K = Integer.valueOf(st.nextToken());
			map = new int[N][N];
			int max=0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.valueOf(st.nextToken());
					max = max < map[i][j] ? map[i][j] : max;
				}
			}
			list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (max == map[i][j]) {
						list.add(new Pair(i, j));
					}
				}
			}
			res=0;
			for (int i = 0; i < list.size(); i++) {
				Pair cur = list.get(i);
				visit = new boolean[N][N];
				dfs(cur.r, cur.c, 1, map, 1);
			}
			System.out.println("#"+tc+" "+res);
		}
	}

	static void dfs(int r, int c, int dist, int temp[][], int t) {
		visit[r][c] = true;
		if(res < dist) {
			res = dist;
		}
		for (int k = 0; k < 4; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			if (nr < 0 || nr >= N || nc < 0 || nc >= N || visit[nr][nc])
				continue;
			if (t > 0) {
				if (temp[nr][nc] >= temp[r][c]) {
					int tmp = temp[nr][nc];
					if (temp[nr][nc] < temp[r][c] + K) {
						temp[nr][nc] = temp[r][c] - 1;
						dfs(nr,nc,dist+1, temp, 0);
						temp[nr][nc] = tmp;
						visit[nr][nc] = false;
					}
				}
			}
			if(temp[r][c] > temp[nr][nc]) {
				dfs(nr,nc,dist+1, temp, t);
				visit[nr][nc] = false;
			}
		}
	}

}
