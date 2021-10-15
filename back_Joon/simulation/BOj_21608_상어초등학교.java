import java.io.*;
import java.util.*;

public class BOj_21608_상어초등학교{
	static int grid[][];
	static int N;
	static int D[][] = {{-1,0},{0,1},{1,0},{0,-1}};
	static Set<Integer> set[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		int K = (N*N)+1;
		set = new HashSet[K];
		int arr[] = new int[K];
		grid = new int[N][N];
		for(int i=0; i<K; i++)
			set[i] = new HashSet<>();
		for(int i=0; i<N*N; i++) {
			st = new StringTokenizer(br.readLine());
			int a= stoi(st.nextToken());
			arr[i+1] = a;
			for(int j=0; j<4; j++) {
				int freind =  stoi(st.nextToken());
				set[a].add(freind);
			}
		}
		int idx=1;
		while(idx<K) {
			Queue<int[]> pq = new PriorityQueue<>((int a[], int b[])->{
				if(b[0] == a[0]) {
					if(b[1]==a[1]) {
						if(a[2]==b[2])
							return a[3]-b[3];
						return a[2]-b[2];
					}
					return b[1] - a[1];
				}
				return b[0] - a[0];
			});
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(grid[i][j]==0) {
						int fn=findFreinds(i,j, arr[idx]);
						int bn = findBrank(i,j);
						pq.add(new int[] {fn, bn, i ,j});
					}
				}
			}
			int pos[] = pq.poll();
			int nr = pos[2];
			int nc = pos[3];
			grid[nr][nc] = arr[idx];
			idx++;
		}
		System.out.println(calc());
	}
	static int calc() {
		int sum=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int cnt=0;
				for(int k=0; k<4; k++) {
					int nr= i+D[k][0];
					int nc= j+D[k][1];
					if(nr<0|| nr>=N || nc<0 || nc>=N) continue;
					if(set[grid[i][j]].contains(grid[nr][nc])) {
						cnt++;
					}
				}
				if(cnt==0) sum+=0;
				else if(cnt==1) sum+=1;
				else if(cnt==2) sum+=10;
				else if(cnt==3) sum+=100;
				else if(cnt==4) sum+=1000;
			}
		}
		return sum;
	}
	static int findFreinds(int r, int c, int me) {
		int res=0;
		for(int k=0; k<4; k++) {
			int nr= r+D[k][0];
			int nc= c+D[k][1];
			if(nr<0|| nr>=N || nc<0 || nc>=N || grid[nr][nc]==0) continue;
			if(set[me].contains(grid[nr][nc])) {
				res++;
				
			}
		}
		return res;
	}
	static int findBrank(int r, int c) {
		int res = 0;
		for(int k=0; k<4; k++) {
			int nr= r+D[k][0];
			int nc= c+D[k][1];
			if(nr<0|| nr>=N || nc<0 || nc>=N || grid[nr][nc]>0) continue;
			res++;
		}
		return res;
	}
	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}