import java.io.*;
import java.util.*;

public class boj_1937_øÂΩ…¿Ô¿Ã∆«¥Ÿ {
	static int N, matrix[][], d[][]= {{-1,0},{0,1},{1,0},{0,-1}};
	static int v[][];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = stoi(st.nextToken());
		matrix = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				matrix[i][j]= stoi(st.nextToken());
			}
		}
		v=new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(v[i][j]==0) {
					dfs(i,j);
				}
			}
		}
		int answer =0;
		for(int i=0; i<N; i++)
			answer = Math.max(answer, Arrays.stream(v[i]).max().getAsInt());
		System.out.println(answer);
	}
	static int dfs(int r, int c) {
		int max=0;
		for(int k=0; k<4; k++) {
			int nr = r+d[k][0];
			int nc = c+d[k][1];
			if(nr<0||nr>=N||nc<0||nc>=N || matrix[nr][nc]<=matrix[r][c]) continue;
			if(v[nr][nc]!=0) {
				max = Math.max(max, v[nr][nc]);
				continue;
			}else if(v[nr][nc]==0)
				max = Math.max(max, dfs(nr,nc));
		}
		v[r][c] = max+1;
		return v[r][c];
	}
	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}