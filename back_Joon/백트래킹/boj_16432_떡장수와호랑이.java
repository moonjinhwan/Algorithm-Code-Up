import java.io.*;
import java.util.*;

public class boj_16432_¶±Àå¼ö¿ÍÈ£¶ûÀÌ {
	static List<Integer> list[];
	static boolean visit[][], flag=false;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = stoi(st.nextToken());
		list = new ArrayList[N];
		visit = new boolean[N][9];
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int M=stoi(st.nextToken());
			for(int j=0; j<M; j++) {
				list[i].add(stoi(st.nextToken()));
			}
		}
		dfs(0, new int[N], 0);
		if(!flag)
			System.out.println(-1);
	}
	static void dfs(int depth, int save[], int prev) {
		if(flag)
			return;
		if(depth == N) {
			flag=true;
			StringBuilder sb=new StringBuilder();
			for(int i=0; i<N; i++) {
				sb.append(save[i]).append("\n");
			}
			System.out.println(sb);
			return;
		}
		for(int i=0; i< list[depth].size(); i++) {
			if(!visit[depth][i] && prev!=list[depth].get(i)) {
				visit[depth][i]=true;
				save[depth]=list[depth].get(i);
				dfs(depth+1, save, list[depth].get(i));
			}
		}
	}
	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}