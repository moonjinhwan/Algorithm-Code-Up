import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, Q, map[][];
	static int dr[] = { 0, 1, 0, -1 };
	static int dc[] = { 1, 0, -1, 0 };
	static boolean visit[][];

	static class Pair {
		int r, c;

		public Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int n = Integer.valueOf(st.nextToken());
		Q = Integer.valueOf(st.nextToken());
		N = (int) Math.pow(2, n);
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.valueOf(st.nextToken());
			}
		}
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 1; i <= Q; i++) {
			int L = Integer.valueOf(st.nextToken());
			if (L > 0)
				solve(L);
			// 녹이기
			melt();
		}
		// bfs돌리기
		int sum = 0;
		int max = 0;
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum += map[i][j];
				if (map[i][j] != 0 && !visit[i][j]) {
					int tmp = bfs(i, j);
					max = max < tmp ? tmp : max;
				}
			}
		}
		System.out.println(sum);
		System.out.println(max);
	}

	static void melt() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int check = 0;
				if (map[i][j] == 0)
					continue;
				for (int k = 0; k < 4; k++) {
					int nr = i + dr[k];
					int nc = j + dc[k];
					if (nr < 0 || nr >= N || nc < 0 || nc >= N)
						continue;
					if (map[nr][nc] > 0) {
						check++;
					}
				}
				if (check < 3)
					map[i][j]--;
			}
		}
	}

	static int bfs(int sR, int sC) {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(sR, sC));
		visit[sR][sC] = true;
		int cnt = 1;
		while (!q.isEmpty()) {
			Pair cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N || visit[nr][nc])
					continue;
				if (map[nr][nc] == 0)
					continue;
				visit[nr][nc] = true;
				cnt++;
				q.add(new Pair(nr, nc));
			}
		}
		return cnt;
	}

	static void solve(int n) {
		int sR = 0;
		int sC = 0;
		int l = (int) Math.pow(2, n - 1);
		int size = (int) Math.pow(2, n);
		int cpy[][] = new int[N][N];
		int nR, nC;
		int turn = (N * N) / (size * size);
		while (turn-- > 0) {
			for (int d = 0; d < 4; d++) {
				for (int i = sR; i < sR + l; i++) {
					for (int j = sC; j < sC + l; j++) {
						nR = i + dr[d] * l;
						nC = j + dc[d] * l;
						cpy[nR][nC] = map[i][j];
					}
				}
				if (d == 0) {
					sC += l;
				} else if (d == 1) {
					sR += l;
				} else if (d == 2) {
					sC -= l;
				} else if (d == 3) {
					sR -= l;
				}
			}
			sC += size;
			if (sC == N) {
				sC = 0;
				sR += size;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = cpy[i][j];
			}
		}
	}
}
