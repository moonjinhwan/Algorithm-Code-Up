import java.io.*;
import java.util.*;

public class boij_16202_MST∞‘¿” {
	static int N, M, K, parent[];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		List<int[]> list = new ArrayList<>();
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		K = stoi(st.nextToken());
		parent = new int[N + 1];

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(in.readLine());
			int a = stoi(st.nextToken());
			int b = stoi(st.nextToken());
			list.add(new int[] { a, b, i });
		}
		Collections.sort(list, (a, b) -> (a[2] - b[2]));
		int start = 0;
		int ans[] = new int[K];
		while (start < K) {
			Queue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
			init();
			for (int i = start; i < M; i++) {
				int cur[] = list.get(i);
				pq.add(cur);
			}
			int total = 0;
			while (!pq.isEmpty()) {
				int cur[] = pq.poll();
				if (find(cur[0]) != find(cur[1])) {
					union(cur[0], cur[1]);
					total += cur[2];
				}
			}
			if (check()) {
				ans[start] = total;
				start++;
			} else
				break;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < K; i++) {
			sb.append(ans[i]).append(" ");
		}
		System.out.println(sb);
	}

	static int find(int x) {
		if (x == parent[x]) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a < b) {
			parent[b] = a;
		} else {
			parent[a] = b;
		}
	}

	static boolean check() {
		for (int i = 1; i <= N; i++) {
			parent[i] = find(i);
		}
		for (int i = 1; i < N; i++) {
			if (parent[i] != parent[i + 1]) {
				return false;
			}
		}
		return true;
	}

	static void init() {
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}
