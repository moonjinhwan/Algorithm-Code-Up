import java.io.*;
import java.util.*;

public class boj_17073 {
	static int N, K, W;
	static boolean visit[];
	static List<Integer> list[];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = stoi(st.nextToken());
		W = stoi(st.nextToken());
		K = 0;
		list = new List[N + 1];
		visit = new boolean[N + 1];
		for (int i = 1; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(in.readLine());
			int a = stoi(st.nextToken());
			int b = stoi(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		dfs(1);
		System.out.println(W / (double) K);
	}

	static void dfs(int node) {
		visit[node] = true;
		boolean flag = false;
		for (int next : list[node]) {
			if (!visit[next]) {
				flag = true;
				dfs(next);
			}
		}
		if (!flag) {
			K++;
		}
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}