import java.io.*;
import java.util.*;

public class BOJ_¹éµµ¾î_17396 {
	static List<long[]> list[];
	static int arr[], N, M;
	static long MAX = Long.MAX_VALUE;
	static boolean v[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		list = new ArrayList[N];
		v = new boolean[N];
		for (int i = 0; i < N; i++)
			list[i] = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = stoi(st.nextToken());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = stoi(st.nextToken());
			int b = stoi(st.nextToken());
			int c = stoi(st.nextToken());
			list[a].add(new long[] { b, c });
			list[b].add(new long[] { a, c });
		}
		Queue<long[]> pq = new PriorityQueue<>((x, y) -> (int)(x[1]-y[1]));
		long path[] = new long[N];
		for (int i = 0; i < N; i++)
			path[i] = MAX;
		path[0] = 0;
		pq.add(new long[] { 0, 0 });
		while (!pq.isEmpty()) {
			long cur[] = pq.poll();
			int curnode = (int)(cur[0]);
			if (v[curnode])
				continue;
			v[curnode] = true;
			for (long next[] : list[curnode]) {
				int nextnode = (int) next[0];
				if (arr[nextnode] == 1 && nextnode != N - 1)
					continue;
				if (!v[nextnode] && path[nextnode] > path[curnode] + next[1]) {
					path[nextnode] = path[curnode] + next[1];
					pq.add(new long[] {nextnode, path[nextnode]});
				}
			}
		}
		// System.out.println(Arrays.toString(path));
		if (path[N - 1] == MAX)
			System.out.println(-1);
		else
			System.out.println(path[N - 1]);
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}