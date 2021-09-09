import java.io.*;
import java.util.*;

public class boj_19542_전단지돌리기 {
	static boolean visit[];
	static int N,M,D,dp[];
	static List<Integer> list[];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = stoi(st.nextToken());
		M= stoi(st.nextToken());
		D= stoi(st.nextToken());
		list= new ArrayList[N+1];
		visit=  new boolean[N+1];
		dp = new int[N+1];
		for(int i=0; i<=N; i++) {
			list[i]=new ArrayList<>();
		}
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(in.readLine());
			int a=stoi(st.nextToken());
			int b=stoi(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		visit[M]=true;
		dfs(M);
		int ans=0;
		for(int i=1; i<=N; i++) {
			if(i!=M && dp[i]>=D) {
				ans++;
			}
		}
		System.out.println(ans*2);
	}
	static int dfs(int node) {
		int val=0;
		for(int next: list[node]) {
			if(!visit[next]) {
				visit[next]=true;
				val=Math.max(val, dfs(next));
			}
		}
		dp[node] = val;
		return dp[node]+1;
	}
	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}
