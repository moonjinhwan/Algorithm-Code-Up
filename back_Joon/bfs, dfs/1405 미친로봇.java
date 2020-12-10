import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int dr[] = { 0, 0, -1, 1 };
	static int dc[] = { 1, -1, 0, 0 };
	static int N, per[];
	static boolean visit[][];
	static double res;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.valueOf(st.nextToken());
		per = new int[4];
		for (int i = 0; i < 4; i++) {
			per[i] = Integer.valueOf(st.nextToken());
		}
		res = 0;
		visit = new boolean[29][29];
		dfs(0, 14, 14, 1);
		System.out.println(res);
	}

	static void dfs(int idx, int r, int c, double sum) {
		visit[r][c] = true;
		if (idx == N) {
			res += sum;
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (visit[nr][nc]) {
				continue;
			}
			dfs(idx + 1, nr, nc, sum * (double)(per[i]) / 100);
			visit[nr][nc] = false;
		}
	}
}