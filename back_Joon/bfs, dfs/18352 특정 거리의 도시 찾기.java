import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N, M, K, X;
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		K = stoi(st.nextToken());
		X = stoi(st.nextToken());
		List<Integer> list[] = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++)
			list[i] = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int a = stoi(st.nextToken());
			int b = stoi(st.nextToken());
			list[a].add(b);
		}
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { X, 0 });
		boolean visit[] = new boolean[N + 1];
		int cnt[]=new int[N+1];
		visit[X]=true;
		while (!q.isEmpty()) {
			int cur[] = q.poll();
			for (int next : list[cur[0]]) {
				if(!visit[next]) {
					visit[next]=true;
					q.add(new int[] {next, cur[1]+1});
					cnt[next]=cur[1]+1;
				}
			}
		}
		List<Integer> ans=new ArrayList<>();
		for(int i=1;i<N+1;i++) {
			if(cnt[i]==K) {
				ans.add(i);
			}
		}
		if(ans.size()==0)
			System.out.println(-1);
		else
			for(int k: ans)
				System.out.println(k+" ");
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}