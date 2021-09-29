import java.io.*;
import java.util.*;

public class BOJ_1167_트리의지름 {
	static int N, dp[], ANSWER = 0;
	static List<int[]> list[];
	static boolean v[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		v = new boolean[N + 1];
		dp = new int[N + 1];
		list = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++)
			list[i] = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = stoi(st.nextToken());
			while (true) {
				int b = stoi(st.nextToken());
				if (b == -1)
					break;
				int c = stoi(st.nextToken());
				list[a].add(new int[] { b, c });
			}
		}
		dfs(1, 0);
		ANSWER = Arrays.stream(dp).max().getAsInt(); 
		//System.out.println(Arrays.toString(dp));
		System.out.println(ANSWER);
	}

	static int dfs(int n, int prew) {
		int fir = 0;
		int sec = 0;
		v[n] = true;
		for (int[] next : list[n]) {
			int node = next[0];
			int w = next[1];
			if (v[node])
				continue;
			int ret = dfs(node, w);
			if(ret > fir) {
				sec = fir;
				fir = ret;
			}
			else if(ret > sec) {
				sec =ret;
			}
		}
		dp[n] = fir+sec;
		return fir + prew;
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}