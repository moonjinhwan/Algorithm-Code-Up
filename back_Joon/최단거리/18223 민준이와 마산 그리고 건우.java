import java.util.*;
import java.io.*;

public class Main {
	static List<int[]> list[];
	static int INF = 987654321;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int V = stoi(st.nextToken());// 정점수
		int E = stoi(st.nextToken());// 간선수
		int P = stoi(st.nextToken());// 타깃
		list = new ArrayList[V + 1];
		for (int i = 1; i < V + 1; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 1; i <= E; i++) {
			st = new StringTokenizer(in.readLine());
			int from = stoi(st.nextToken());
			int to = stoi(st.nextToken());
			int val = stoi(st.nextToken());
			list[from].add(new int[] { to, val });
			list[to].add(new int[] { from, val });
		}
		int len1 = solve(1, P, V) + solve(P, V, V);
		int len2 = solve(1, V, V);
		if (len1 == len2) {
			System.out.println("SAVE HIM");
		} else
			System.out.println("GOOD BYE");
	}

	static int solve(int start, int end, int V) {
		Queue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
		boolean visit[] = new boolean[V + 1];
		int[] shortest = new int[V + 1];
		for (int i = 0; i < V + 1; i++)
			shortest[i] = INF;
		shortest[start] = 0;
		pq.add(new int[] { start, 0 });
		while (!pq.isEmpty()) {
			int cur[] = pq.poll();
			int curnode = cur[0];
			if (visit[curnode])
				continue;
			visit[curnode] = true;
			if (curnode == end) {
				return shortest[end];
			}
			for (int[] next : list[cur[0]]) {
				int nextedge = next[1];
				int nextnode = next[0];
				if (!visit[nextnode] && shortest[nextnode] > shortest[curnode] + nextedge) {
					shortest[nextnode] = shortest[curnode] + nextedge;
					pq.add(new int[] { nextnode, nextedge });
				}
			}
		}
		return shortest[end];
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}
