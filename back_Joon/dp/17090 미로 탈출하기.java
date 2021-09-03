import java.util.*;
import java.io.*;

public class Main {
	static int N,M, dp[][];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		char map[][] = new char[N][M];
		dp = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			String s = st.nextToken();
			map[i] = s.toCharArray();
		}
		int cnt=0;
		int visit[][]=new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(visit[i][j]==0) {
					visit[i][j]=1;
					dp[i][j]=dfs(i, j, visit, map);
				}
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(dp[i][j]==1)
					cnt++;
			}
		}
		System.out.println(cnt);
	}
	static int dfs(int r, int c, int visit[][], char map[][]) {
		if(map[r][c]=='U') {
			r--;			
		}else if(map[r][c]=='R') {
			c++;
		}else if(map[r][c]=='D') {
			r++;
		}else if(map[r][c]=='L') {
			c--;
		}
		if(r<0 || r>=N || c<0 ||c>=M) {
			return 1;
		}
		if(visit[r][c]==1) {
			if(dp[r][c]==0) {
				return 0;
			}else {
				return 1;
			}
		}else {
			visit[r][c]=1;
			dp[r][c]= dfs(r, c, visit, map);
			return dp[r][c];
		}
	}
	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}