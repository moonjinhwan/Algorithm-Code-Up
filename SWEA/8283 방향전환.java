import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int T, c1, r1, c2, r2;
	static int dr[] = { -1, 0, 1, 0 };
	static int dc[] = { 0, 1, 0, -1 };

	static class Pair {
		int r, c, dist, dir;

		public Pair(int r, int c, int dist, int dir) {
			// TODO Auto-generated constructor stub
			this.r = r;
			this.c = c;
			this.dist = dist;
			this.dir = dir;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		T = Integer.valueOf(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			c1 = Integer.valueOf(st.nextToken()) + 100;
			r1 = Integer.valueOf(st.nextToken()) + 100;
			c2 = Integer.valueOf(st.nextToken()) + 100;
			r2 = Integer.valueOf(st.nextToken()) + 100;
			int ans = bfs();
			System.out.println("#" + tc + " " + ans);
		}
	}

	static int bfs() {
		Queue<Pair> q = new LinkedList<>();
		boolean visit[][][] = new boolean[2][201][201];
		q.add(new Pair(r1, c1, 0, 0));
		q.add(new Pair(r1, c1, 0, 1));
		visit[0][r1][c1] = true;// 현재 방향이 세로
		visit[1][r1][c1] = true;// 가로
		while (!q.isEmpty()) {
			Pair cur = q.poll();
			if (cur.r == r2 && cur.c == c2) {
				return cur.dist;
			}
			for (int i = 0; i < 4; i++) {
				int nr = 0;
				int nc = 0;
				int nd = 0;
				if (cur.dir % 2 == 0 && i % 2 == 1) {// 현재가 세로방향이고, 다음이 가로방향
					nr = cur.r + dr[i];
					nc = cur.c + dc[i];
					nd = 1;
				} else if (cur.dir % 2 == 1 && i % 2 == 0) {
					nr = cur.r + dr[i];
					nc = cur.c + dc[i];
					nd = 0;
				}else {
					continue;
				}
				if (nr < 0 || nr > 200 || nc < 0 || nc > 200 || visit[nd][nr][nc]) {
					continue;
				}
				visit[nd][nr][nc] = true;
				q.add(new Pair(nr, nc, cur.dist + 1, nd));
			}
		}
		return 0;
	}
}
