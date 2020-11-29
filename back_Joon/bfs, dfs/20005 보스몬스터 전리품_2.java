import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, P;
	static int bossr, bossc;
	static int dr[] = { -1, 0, 1, 0 };
	static int dc[] = { 0, 1, 0, -1 };
	static char map[][];

	static class Player implements Comparable<Player> {
		int r, c, d, dps;

		public Player(int r, int c, int d, int dps) {
			this.r = r;
			this.c = c;
			this.d = d;
			this.dps = dps;
		}

		@Override
		public int compareTo(Player o) {
			// TODO Auto-generated method stub
			return this.d - o.d;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		P = Integer.valueOf(st.nextToken());
		map = new char[N][M];
		Player[] p = new Player[P];
		for (int i = 0; i < N; i++) {
			String str = in.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] >= 'a' && map[i][j] <= 'z') {
					p[map[i][j] - 'a'] = new Player(i, j, 0, 0);
				}
				if (map[i][j] == 'B') {
					bossr = i;
					bossc = j;

				}
			}
		}
		for (int i = 0; i < P; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			st.nextToken();
			p[i].dps = Integer.valueOf(st.nextToken());
		}
		int BOSS = Integer.valueOf(in.readLine());
		for (int i = 0; i < P; i++) {
			p[i].d = bfs(i, p[i].r, p[i].c);
		}
		Arrays.sort(p);
		int res = 0;
		int sum = 0;
		for (int i = 0; i+1 < P; i++) {
			if (BOSS > 0) {
				sum += p[i].dps;
				res++;
				if (p[i].d != p[i + 1].d) {
					BOSS -= (sum * (p[i + 1].d - p[i].d));
				}
			}
		}
		if(BOSS>0)
			res++;
		System.out.println(res);
	}

	static int bfs(int id, int r, int c) {
		boolean[][] visit = new boolean[N][M];
		Queue<Player> q = new LinkedList<>();
		visit[r][c] = true;
		q.add(new Player(r, c, 0, 0));
		int dist = 0;
		while (!q.isEmpty()) {
			Player cur = q.poll();
			if (cur.r == bossr && cur.c == bossc) {
				dist = cur.d;
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M || visit[nr][nc])
					continue;
				if(map[nr][nc]=='X')
					continue;
				visit[nr][nc] = true;
				q.add(new Player(nr, nc, cur.d + 1, cur.dps));
			}
		}
		return dist;
	}
}