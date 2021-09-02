import java.util.*;
import java.io.*;

public class Main {
	static List<Integer> list[];
	static int N, cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = stoi(st.nextToken());
		list = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(in.readLine());
			int a, b;
			a = stoi(st.nextToken());
			b = stoi(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		dfs(0, 1, new boolean[N + 1]);
		if (cnt % 2 == 0)
			System.out.println("No");
		else
			System.out.println("Yes");
	}

	static void dfs(int dep, int curnode, boolean visit[]) {
		boolean find = false;
		visit[curnode] = true;
		for (int next : list[curnode]) {
			if (!visit[next]) {
				dfs(dep + 1, next, visit);
				find = true;
			}
		}
		if (!find) {//리프노드
			cnt+=dep;
		}
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}