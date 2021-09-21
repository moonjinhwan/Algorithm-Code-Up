import java.io.*;
import java.util.*;

public class boj_17141_¿¬±¸¼Ò2 {
	static int N,M,matrix[][], D[][]= {{-1,0},{0,1},{1,0},{0,-1}}, answer=2500, spreadNum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=stoi(st.nextToken());
		M=stoi(st.nextToken());
		matrix=  new int[N][N];
		spreadNum=0;
		int blockNum=0;
		List<Integer> L = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				matrix[i][j]=stoi(st.nextToken());
				if(matrix[i][j]==1) {
					blockNum++;
				}else if(matrix[i][j]==2) {
					L.add(i*N + j);
				}
			}
		}
		spreadNum=N*N-blockNum-M;
		dfs(0, L, new int[M], 0);
		if(answer==2500)
			answer=-1;
		System.out.println(answer);
	}
	static void dfs(int aidx, List<Integer> L, int[] a, int start) {
		if(aidx == M) {
			bfs(a);
			return;
		}
		for(int i=start; i<L.size(); i++) {
			a[aidx] = L.get(i);
			dfs(aidx+1, L, a, i+1);
		}
	}
	static void bfs(int a[]) {
		Queue<int[]> q= new LinkedList<>();
		boolean v[][] = new boolean[N][N];
		for(int e: a) {
			q.add(new int[] {e/N, e%N, 0});
			v[e/N][e%N] = true;
		}
		int cnt=0, dist=0;
		while(!q.isEmpty()) {
			int cur[]=q.poll();
			for(int k=0; k<4; k++) {
				int nr = cur[0]+D[k][0];
				int nc = cur[1]+D[k][1];
				if(nr<0||nr>=N||nc<0||nc>=N||v[nr][nc]||matrix[nr][nc]==1)continue;
				cnt++;
				v[nr][nc] = true;
				q.add(new int[] {nr,nc,cur[2]+1});
				dist=Math.max(dist, cur[2]+1);
			}
		}
		if(cnt==spreadNum) {
			answer=Math.min(answer, dist);
		}
	}
	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}