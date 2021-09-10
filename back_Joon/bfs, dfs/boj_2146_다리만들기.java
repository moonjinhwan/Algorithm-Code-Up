import java.io.*;
import java.util.*;

public class boj_2146_다리만들기 {
	static int map[][], N, d[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }, G[][];
	static boolean check[][];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = stoi(st.nextToken());
		map = new int[N][N];
		G = new int[N][N];
		check = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = stoi(st.nextToken());
			}
		}
		int idx = 1;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j <  map.length; j++) {
				if (!check[i][j] && map[i][j]==1) {
					check[i][j] = true;
					findGroup(i, j, idx);
					idx++;
				}
			}
		}
		int minval=200;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if(G[i][j]!=0) {
					minval = Math.min(minval, bfs(i,j));
				}
			}
		}
		System.out.println(minval);
	}

	static int bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		boolean visit[][] = new boolean[N][N];
		q.add(new int[] { r, c, 0 });
		while (!q.isEmpty()) {
			int cur[] = q.poll();
			for (int k = 0; k < 4; k++) {
				int nr = cur[0]+d[k][0];
				int nc = cur[1]+d[k][1];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N || visit[nr][nc])
					continue;
				if(G[nr][nc]!=G[r][c] && G[nr][nc]!=0) {
					return cur[2];
				}
				if(map[nr][nc]==1)
					continue;
				visit[nr][nc] = true;
				q.add(new int[] { nr, nc, cur[2] + 1 });
			}
		}
		return 100;
	}

	static void findGroup(int r, int c, int g) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c });
		G[r][c] = g;
		check[r][c]=true;
		while (!q.isEmpty()) {
			int cur[] = q.poll();
			for (int k = 0; k < 4; k++) {
				int nr = cur[0]+d[k][0];
				int nc = cur[1]+d[k][1];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N || check[nr][nc] || map[nr][nc] == 0)
					continue;
				check[nr][nc] = true;
				G[nr][nc] = g;
				q.add(new int[] { nr, nc });
			}
		}
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}
