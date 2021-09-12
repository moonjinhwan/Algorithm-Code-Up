import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = stoi(st.nextToken());
		int M = stoi(st.nextToken());
		int map[][]=new int[N+1][M+1];
		for(int i=1;i<N+1;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=1;j<M+1;j++) {
				map[i][j]=stoi(st.nextToken());
			}
		}
		int memo[][] = new int[N+1][M+1];
		for(int i=1;i<N+1;i++) {
			for(int j=1;j<M+1;j++) {
				memo[i][j]=map[i][j]+memo[i-1][j]+memo[i][j-1]-memo[i-1][j-1];
			}
		}
		st = new StringTokenizer(in.readLine());
		int K=stoi(st.nextToken());
		StringBuilder sb= new StringBuilder();
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(in.readLine());
			int r1=stoi(st.nextToken());
			int c1=stoi(st.nextToken());
			int r2=stoi(st.nextToken());
			int c2=stoi(st.nextToken());
			int sum=memo[r2][c2]-memo[r1-1][c2]-memo[r2][c1-1]+memo[r1-1][c1-1];
			sb.append(sum+"\n");
		}
		System.out.println(sb);
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}