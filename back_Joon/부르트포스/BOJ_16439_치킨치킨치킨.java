import java.io.*;
import java.util.*;

public class BOJ_16439_ġŲġŲġŲ {
	static int N, M, ans;
	static int arr[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=stoi(st.nextToken());
		M=stoi(st.nextToken());
		arr =  new int[N][M];
		ans = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j ++) {
				arr[i][j] = stoi(st.nextToken());
			}
		}
		dfs(0 , new int[3]);
		System.out.println(ans);
	}
	static void dfs(int level, int save[]) {
		if(level == 3) {
			int sum=0;
			for(int i=0; i<N; i++) {
				int max=0;
				for(int j=0; j<3; j++) {
					max = Math.max(max, arr[i][save[j]]);
				}
				sum+=max;
			}
			ans = Math.max(sum, ans);
			return;
		}
		for(int i=0; i<M; i++) {
			save[level] = i;
			dfs(level+1, save);
		}
	}
	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}