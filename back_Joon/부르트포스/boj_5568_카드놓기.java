import java.io.*;
import java.util.*;

public class boj_5568_카드놓기 {
	static Set<String> set;
	static String s[];
	static int N, K;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = stoi(st.nextToken());
		st = new StringTokenizer(in.readLine());
		K = stoi(st.nextToken());
		set = new HashSet<>();
		s= new String[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			s[i]=st.nextToken();
		}
		dfs(0, new boolean[N], "");
		System.out.println(set.size());
	}
	
	static void dfs(int dep, boolean visit[], String sum) {
		if(dep == K) {
			set.add(sum);
			return;
		}
		for(int i=0; i<N; i++) {
			if(!visit[i]) {
				visit[i]=true;
				dfs(dep+1, visit, sum+s[i]);
				visit[i]=false;
			}
		}
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}
