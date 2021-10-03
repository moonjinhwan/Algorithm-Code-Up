import java.io.*;
import java.util.*;

public class BOJ_2665_미로만들기 {
	static int D[][]= {{-1,0},{0,1},{1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N  =stoi(st.nextToken());
		int grid[][] = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			for(int j=0; j<N; j++) {
				grid[i][j] = s.charAt(j)-'0';
			}
		}
		boolean v[][] = new boolean[N][N];
		Queue<int[]> pq = new PriorityQueue<>((a,b) ->{return a[2]-b[2];});
		pq.add(new int[] {0, 0, 0});
		int answer = 0;
		while(!pq.isEmpty()) {
			int cur[] = pq.poll();
			if(cur[0] == N-1 && cur[1]== N-1) {
				answer = cur[2];
				break;
			}
			for(int k=0; k<4; k++) {
				int nr = cur[0] + D[k][0];
				int nc = cur[1] + D[k][1];
				if(nr<0 || nr >=N || nc<0 || nc>=N|| v[nr][nc]) continue;
				v[nr][nc] = true;
				if(grid[nr][nc]==0) {
					pq.add(new int[] {nr,nc, cur[2]+1});
				}else {
					pq.add(new int[] {nr, nc, cur[2]});
				}
			}
		}
		System.out.println(answer);
	}
	
	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}