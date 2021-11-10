import java.io.*;
import java.util.*;

public class Main{
	static int N, M, cnt;
	static int arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		arr = new int[N];
		cnt=0;
		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			arr[i] = stoi(st.nextToken());
		}
		dfs(0, 0, 0);
		System.out.println(cnt);
	}
	static void dfs(int level, int start, int sum) {
		if(level == 2) {
			if(sum<=M) {
				cnt++;
			}
			return;
		}
		for(int i=start; i<N; i++) {
			dfs(level+1, i+1, sum+arr[i]);
		}
	}
	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}