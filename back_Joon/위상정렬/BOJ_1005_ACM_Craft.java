import java.io.*;
import java.util.*;

public class BOJ_1005_ACM_Craft {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = stoi(st.nextToken());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int N = stoi(st.nextToken());
			int M = stoi(st.nextToken());
			int val[] = new int[N + 1];
			int cnt[] = new int[N+1];
			int dp[] = new int[N+1];
			List<Integer> list[] = new ArrayList[N + 1];
			for (int i = 0; i <= N; i++) {
				list[i] = new ArrayList<>();
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				val[i] = stoi(st.nextToken());
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = stoi(st.nextToken());
				int b = stoi(st.nextToken());
				list[a].add(b);
				cnt[b]++;
			}
			st = new StringTokenizer(br.readLine());
			int K = stoi(st.nextToken());
			//
			Queue<Integer> q= new LinkedList<>();
			for(int i=1; i<=N; i++) {
				if(cnt[i]==0) {
					q.add(i);
					dp[i] = val[i];
				}
			}
			while(!q.isEmpty()) {
				int cur = q.poll();
				for(int next: list[cur]) {
					cnt[next]--;
					dp[next] = Math.max(val[next]+dp[cur], dp[next]);
					if(cnt[next]==0) {
						q.add(next);
					}
				}
			}
			System.out.println(dp[K]);
		}
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}