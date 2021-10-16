import java.io.*;
import java.util.*;

public class BOJ_18429_±Ù¼Õ½Ç{
	static int N,M,ans;
	static int arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M=stoi(st.nextToken());
		ans=0;
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i]=stoi(st.nextToken());
		}
		dfs(0, new boolean[N], 0);
		System.out.println(ans);
	}
	static void dfs(int curlevel, boolean v[], int sum) {
		if(sum<0) {
			return;
		}
		if(curlevel == N) {
			ans++;
			return;
		}
		for(int i=0; i<N; i++) {
			if(!v[i]) {
				v[i]=true;
				dfs(curlevel+1, v, sum-M+arr[i]);
				v[i]=false;
			}
		}
	}
	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}