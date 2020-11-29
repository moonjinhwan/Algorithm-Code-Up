import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int T, H, W, O, F, startr, startc, desr, desc;
	static int map[][];
	static int dr[] = { -1, 0, 1, 0 };
	static int dc[] = { 0, 1, 0, -1 };
	static boolean visit[][][];

	static class Pair {
		int r, c, f;

		public Pair(int r, int c, int f) {
			// TODO Auto-generated constructor stub
			this.r = r;
			this.c = c;
			this.f = f;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		T = Integer.valueOf(st.nextToken());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			H = Integer.valueOf(st.nextToken());
			W = Integer.valueOf(st.nextToken());
			O = Integer.valueOf(st.nextToken());
			F = Integer.valueOf(st.nextToken());
			startr = Integer.valueOf(st.nextToken()) - 1;
			startc = Integer.valueOf(st.nextToken()) - 1;
			desr = Integer.valueOf(st.nextToken()) - 1;
			desc = Integer.valueOf(st.nextToken()) - 1;
			map = new int[H][W];
			for (int i = 0; i < O; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				int y, x, w;
				y = Integer.valueOf(st.nextToken()) - 1;
				x = Integer.valueOf(st.nextToken()) - 1;
				w = Integer.valueOf(st.nextToken());
				map[y][x] = w;
			}
			if (bfs()) {
				System.out.println("잘했어!!");
			} else {
				System.out.println("인성 문제있어??");
			}
		}
	}

	static boolean bfs() {
		boolean flag = false;
		Queue<Pair> q = new LinkedList<>();
		visit = new boolean[F + 1][H][W];
		visit[F][startr][startc] = true;
		q.add(new Pair(startr, startc, F));
		while (!q.isEmpty()) {
			Pair cur = q.poll();
			if (cur.f < 1) {
				continue;
			}
			if (cur.r == desr && cur.c == desc) {
				flag = true;
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				int nf = cur.f - 1;
				if (nr < 0 || nc < 0 || nr >= H || nc >= W)
					continue;
				if (visit[nf][nr][nc])
					continue;
				// 더 큰 경우
				visit[nf][nr][nc]=true;
				if (map[nr][nc] > map[cur.r][cur.c]) {
					if (cur.f >= (map[nr][nc] - map[cur.r][cur.c])) {
						q.add(new Pair(nr, nc, nf));
					}
				} else {
					q.add(new Pair(nr, nc, nf));
				}
			}
		}
		return flag;
	}
}