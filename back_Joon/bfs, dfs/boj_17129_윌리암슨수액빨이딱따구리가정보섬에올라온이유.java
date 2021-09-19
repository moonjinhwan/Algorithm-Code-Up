import java.io.*;
import java.util.*;

public class boj_17129_Àª¸®¾Ï½¼¼ö¾×»¡ÀÌµüµû±¸¸®°¡Á¤º¸¼¶¿¡¿Ã¶ó¿ÂÀÌÀ¯ {
	static int m[][], N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		m = new int[N][M];
		int row = 0, col = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			char c[] = st.nextToken().toCharArray();
			for (int j = 0; j < M; j++) {
				m[i][j] = c[j] - '0';
				if (m[i][j] == 2) {
					row = i;
					col = j;
				}
			}
		}
		int answer= bfs(row, col);
		if(answer!=0) {
			System.out.println("TAK");
			System.out.println(answer);
		}else
			System.out.println("NIE");
	}

	static int bfs(int r, int c) {
		int D[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { r, c, 0 });
		boolean v[][] = new boolean[N][M];
		v[r][c]=true;
		while (!q.isEmpty()) {
			int cur[] = q.poll();
			if(m[cur[0]][cur[1]]>=3) {
				return cur[2];
			}
			for (int k = 0; k < 4; k++) {
				int nr = cur[0] + D[k][0];
				int nc = cur[1] + D[k][1];
				if (nr < 0 || nr >= N || nc < 0 || nc >= M || v[nr][nc] || m[nr][nc] == 1)
					continue;
				v[nr][nc]=true;
				q.add(new int[] { nr, nc, cur[2] + 1 });
			}
		}
		return 0;
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}