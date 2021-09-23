import java.io.*;
import java.util.*;

public class boj_17484_진우의달여행small {
	static int N,M,matrix[][],D[][] = {{1,-1},{1,0},{1,1}}, answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=stoi(st.nextToken());
		M=stoi(st.nextToken());
		matrix = new int[N][M];
		answer=Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				matrix[i][j]=stoi(st.nextToken());
			}
		}
		for(int i=0; i<M; i++) {
			dfs(0, matrix[0][i], -1, 0, i);
		}
		System.out.println(answer);
	}
	static void dfs(int dep, int sum, int preDir, int r, int c) {
		if(dep==N-1) {
			answer= Math.min(answer, sum);
			return;
		}
		for(int k=0; k<3; k++) {
			if(preDir != k) {
				int nr=r+D[k][0];
				int nc=c+D[k][1];
				if(nr>=N||nc<0||nc>=M) continue;
				dfs(dep+1, sum+matrix[nr][nc], k, nr, nc);
			}
		}
	}
	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}