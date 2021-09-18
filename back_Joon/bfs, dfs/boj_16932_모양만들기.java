import java.io.*;
import java.util.*;

public class boj_16932_모양만들기 {
	static int N, M, matrix[][], d[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int visited[][];
	static Map<Integer, Integer> dic;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		matrix = new int[N][M];
		visited = new int[N][M];
		dic = new HashMap<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				matrix[i][j] = stoi(st.nextToken());
			}
		}
		int g = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (matrix[i][j]==1 && visited[i][j]==0) {
					bfs(i, j, g);
					g++;
				}
			}
		}
		int answer=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(matrix[i][j]==0) {
					int sum=1;
					Set<Integer> set=new HashSet<>();
					for(int k=0; k<4; k++) {
						int r=i+d[k][0];
						int c=j+d[k][1];
						if (r < 0 || r >= N || c < 0 || c >= M || set.contains(visited[r][c])) continue;
						if(visited[r][c]!=0) {
							sum+= (dic.get(visited[r][c]));
							set.add(visited[r][c]);
						}
					}
					answer= Math.max(answer, sum);
				}
			}
		}
		System.out.println(answer);
	}

	static void bfs(int r, int c, int g) {
		Queue<int[]> q = new LinkedList<>();
		visited[r][c] = g;
		int cnt = 1;
		q.add(new int[] { r, c });
		while (!q.isEmpty()) {
			int cur[] = q.poll();
			for (int k = 0; k < 4; k++) {
				int nr = cur[0] + d[k][0];
				int nc = cur[1] + d[k][1];
				if (nr < 0 || nr >= N || nc < 0 || nc >= M  || matrix[nr][nc]==0 || visited[nr][nc]!=0)
					continue;
				visited[nr][nc] = g;
				cnt++;
				q.add(new int[] {nr, nc});
			}
		}
		dic.put(g, cnt);
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}