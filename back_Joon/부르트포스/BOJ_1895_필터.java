import java.io.*;
import java.util.*;

public class BOJ_1895_« ≈Õ {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = stoi(st.nextToken());
		int M = stoi(st.nextToken());
		
		int grid[][] = new int[N][M];
		for(int i=0;i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				grid[i][j]=stoi(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		int T = stoi(st.nextToken());
		int r=0, c=0;
		List<Integer> list;
		List<Integer> ans=new ArrayList<>();
		while(r+3<=N) {
			list=new ArrayList<>();
			for(int i=r; i<r+3; i++) {
				for(int j=c; j<c+3; j++) {
					list.add(grid[i][j]);
				}
			}
			Collections.sort(list);
			ans.add(list.get(4));
			c++;
			if(c+3 > M) {
				c=0;
				r++;
			}
		}
		int cnt=0;
		for(int k: ans) {
			if(k>=T)
				cnt++;
		}
		System.out.println(cnt);
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}