import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static ArrayList<Integer> list[];
	static boolean visit[], friends[];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.valueOf(st.nextToken());
		st = new StringTokenizer(in.readLine());
		M = Integer.valueOf(st.nextToken());
		list = new ArrayList[N+1];
		visit = new boolean[N+1];
		visit[1] = true;
		friends = new boolean[N+1];
		for(int i=0; i<N+1; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		recur(0, 1);
		int res=0;
		for(int i=2; i<=N; i++) {
			if(friends[i]) {
				res++;
			}
		}
		System.out.println(res);
	}
	static void recur(int depth, int num) {
		if(depth > 2) {
			return;
		}
		friends[num] = true;
		for(int k : list[num]) {
			if(!visit[k]) {
				visit[k] = true;
				recur(depth+1, k);
				visit[k] = false;
			}
		}
	}
}