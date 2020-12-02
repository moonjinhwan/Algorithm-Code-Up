import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int T, N, M;
	static boolean visit[];
	static int res = 0;
	static ArrayList<Integer> list[];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		T = Integer.valueOf(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			res=0;
			st = new StringTokenizer(in.readLine(), " ");
			N = Integer.valueOf(st.nextToken());
			M = Integer.valueOf(st.nextToken());
			list = new ArrayList[N+1];
			for (int i = 0; i < N+1; i++) {
				list[i] = new ArrayList<>();
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				int u = Integer.valueOf(st.nextToken());
				int v = Integer.valueOf(st.nextToken());
				list[u].add(v);
				list[v].add(u);
			}
			for (int i = 1; i <= N; i++) {
				visit = new boolean[N+1];
				dfs(i, 1);
			}
			System.out.println("#"+tc+" "+res);
		}
	}

	static void dfs(int from, int d) {
		visit[from] = true;
		res = res < d ? d : res;
		// 인접리스트 탐색하기
		for (int to : list[from]) {
			if (!visit[to]) {
				dfs(to, d+1);
				visit[to] = false;
			}
		}
	}
}