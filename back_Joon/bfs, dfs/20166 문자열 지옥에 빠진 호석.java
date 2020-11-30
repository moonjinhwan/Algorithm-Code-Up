import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K;
	static char map[][];
	static int dr[] = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int dc[] = { 0, 0, -1, 1, -1, 1, -1, 1 };
	static HashMap<String, Integer> hs;
	static class Pair {
		int r, c;
		String d;

		public Pair(int r, int c, String d) {
			// TODO Auto-generated constructor stub
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		K = Integer.valueOf(st.nextToken());
		map = new char[N][M];
		String str;
		String godLetter[] = new String[K];
		for (int i = 0; i < N; i++) {
			str = in.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		hs = new HashMap<>();
		for (int k = 0; k < K; k++) {
			godLetter[k] = in.readLine();
			hs.put(godLetter[k], 0);
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				bfs(i, j);
			}
		}
		Collection<Integer> values = hs.values();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<K; i++) {
			sb.append(hs.get(godLetter[i])+"\n");
		}
		System.out.println(sb);
	}

	static void bfs(int r, int c) {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(r, c, map[r][c] + ""));
		while (!q.isEmpty()) {
			Pair cur = q.poll();
			if (hs.get(cur.d)!=null) {
				int tmp = hs.get(cur.d);
				hs.put(cur.d, tmp+1);
			}
			if (cur.d.length() == 5) {
				continue;
			}
			for (int i = 0; i < 8; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				// 왼쪽
				if (nc < 0 && (nr >= 0 && nr < N)) {
					nc = M - 1;
				}
				// 오른쪽
				else if (nc >= M && (nr >= 0 && nr < N)) {
					nc = 0;
				}
				// 아래
				else if (nr >= N && (nc >= 0 && nc < M)) {
					nr = 0;
				}
				// 위
				else if (nr < 0 && (nc >= 0 && nc < M)) {
					nr = N - 1;
				}
				// 왼좌대각
				else if (nr < 0 && nc < 0) {
					nr = N - 1;
					nc = M - 1;
				}
				// 오른아래대각
				else if (nr >= N && nc >= M) {
					nr = 0;
					nc = 0;
				} 
				
				//왼아래 대각
				else if(nc<0 && nr>=N) {
					nr = 0;
					nc = M-1;
				}
				//오른 위 대각
				else if(nc>=M && nr<0) {
					nr = N-1;
					nc = 0;
				}
				q.add(new Pair(nr, nc, cur.d + map[nr][nc]));
			}
		}
	}
}