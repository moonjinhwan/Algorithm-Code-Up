import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, K, map[][], R, C, S;
	static PriorityQueue<Pair> pq;
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static class Pair implements Comparable<Pair>{
		int r,c,val;
		public Pair(int r, int c, int val) {
			// TODO Auto-generated constructor stub
			this.r=r;
			this.c=c;
			this.val=val;
		}
		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return this.val - o.val;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.valueOf(st.nextToken());
		K = Integer.valueOf(st.nextToken());
		map = new int[N][N];
		pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.valueOf(st.nextToken());
				pq.add(new Pair(i,j,map[i][j]));
			}
		}
		st = new StringTokenizer(in.readLine());
		S = Integer.valueOf(st.nextToken());
		R = Integer.valueOf(st.nextToken())-1;
		C = Integer.valueOf(st.nextToken())-1;
		for(int i=1; i<=S; i++) {
			bfs();
		}
		System.out.println(map[R][C]);
	}
	static void bfs() {
		PriorityQueue<Pair> tmp = new PriorityQueue<>();
		while(!pq.isEmpty()) {
			Pair cur = pq.poll();
			for(int k=0; k<4; k++) {
				int nr = cur.r+dr[k];
				int nc = cur.c+dc[k];
				if(nr<0 || nr>=N || nc<0 ||nc>=N || map[nr][nc]!=0) continue;
				map[nr][nc] = cur.val;
				tmp.add(new Pair(nr,nc,cur.val));
			}
		}
		pq = tmp;
	}
}