import java.util.*;
import java.io.*;

public class Main {
	static int N,M,favor[][], flower[], subject[][], likeFlower[][], ans[];
	static boolean exit;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		favor = new int[N][4];
		flower = new int[N];
		subject = new int[N+1][N+1];
		likeFlower = new int[N][2];
		ans = new int[N+1];
		exit= false;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<4; j++) {
				favor[i][j] = stoi(st.nextToken());
			}
		}
		for(int frog=0; frog<N; frog++) {
			st = new StringTokenizer(in.readLine());
			likeFlower[frog][0] = stoi(st.nextToken());
			likeFlower[frog][1] = stoi(st.nextToken());
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			int u = stoi(st.nextToken());
			int v= stoi(st.nextToken());
			int val = stoi(st.nextToken());
			subject[u][v] = val;
			subject[v][u] = val;
		}
		combine(0, new boolean[N+1]);
		StringBuilder sb = new StringBuilder();
		if(exit) {
			sb.append("YES\n");
			for(int i=1; i<=N; i++) {
				sb.append(ans[i]+1).append(" ");
			}
		}else
			sb.append("NO");
		System.out.println(sb);
	}
	static void combine(int frogidx, boolean choose[]) {
		if(exit) {
			return;
		}
		if(frogidx == N) {
			if(checkLog()) {
				exit=true;
			}
			return;
		}
		for(int i=0; i<2; i++) {
			int temp = likeFlower[frogidx][i];
			if(!choose[temp]) {
				choose[temp]= true;
				flower[frogidx] = temp;
				combine(frogidx+1, choose);
				choose[temp]= false;
			}
		}
	}
	static boolean checkLog() {
		for(int f1=0; f1<N; f1++) {
			for(int f2=0; f2<N; f2++) {
				int flower1 = flower[f1];
				int flower2 = flower[f2];
				if(subject[flower1][flower2]!=0) {
					int sub = subject[flower1][flower2]-1;
					if(favor[f1][sub] == favor[f2][sub]) {
						ans[flower1] = f1;
						ans[flower2] = f2;
					}else
						return false;
				}
			}
		}
		return true;
	}
	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}