import java.io.*;
import java.util.*;

public class BOJ_21317_징검다리건너기 {
	static int arr[][];
	static int N, K, MIN=987654321;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		arr = new int[N][2];
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = stoi(st.nextToken());
			arr[i][1] = stoi(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		K = stoi(st.nextToken());
		dfs(1, N-1, 0, 0);
		System.out.println(MIN);
	}
	static void dfs(int cnt, int maxlevel, int curlevel, int sum) {
		if(maxlevel < curlevel) {
			return;
		}
		if(maxlevel == curlevel) {
			MIN = Math.min(MIN, sum);
			return;
		}
		dfs(cnt, maxlevel, curlevel+1, sum+arr[curlevel][0]);
		dfs(cnt, maxlevel, curlevel+2, sum+arr[curlevel][1]);
		if(cnt==1) {
			dfs(0, maxlevel, curlevel+3, sum+K);
		}
	}
	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}