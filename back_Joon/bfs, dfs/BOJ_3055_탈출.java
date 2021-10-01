import java.io.*;
import java.util.*;

public class BOJ_3055_≈ª√‚ {
	static char[][] grid;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		grid = new char[N][M];
		boolean v[][] = new boolean[N][M];
		Queue<int[]> q = new LinkedList<>();
		int sr = 0, sc = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			grid[i] = s.toCharArray();
			for (int j = 0; j < M; j++) {
				if (grid[i][j] == 'S') {
					sr = i;
					sc = j;
					v[sr][sc] =true;
				} else if (grid[i][j] == '*') {
					v[i][j] = true;
					q.add(new int[] { i, j, 0, 1 });
				}
			}
		}
		q.add(new int[] { sr, sc, 0, 2 });
		v[sr][sc] = true;
		int D[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		int ans=-1;
		while (!q.isEmpty()) {
			int cur[] = q.poll();
			int t = cur[3];
			if(t==2 && grid[cur[0]][cur[1]]=='D') {
				ans = cur[2];
				break;
			}
			for (int k = 0; k < 4; k++) {
				int nr = cur[0] + D[k][0];
				int nc = cur[1] + D[k][1];
				if (isAble(nr, nc) || v[nr][nc] || grid[nr][nc] == 'X') continue;
				if(t==1 && grid[nr][nc]=='D') continue;	
				v[nr][nc] = true;
				q.add(new int[] {nr,nc,cur[2]+1, t});
			}
		}
		if(ans==-1) System.out.println("KAKTUS");
		else System.out.println(ans);
	}

	static boolean isAble(int nr, int nc) {
		if (nr < 0 || nr >= N || nc < 0 || nc >= M)
			return true;
		return false;
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}