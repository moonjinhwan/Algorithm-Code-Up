import java.io.*;
import java.util.*;

public class boj_2406_안정적인_네트워크 {
	static int N, M, par[];
	static Queue<int[]> pq;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		init();
		for (int i = 0; i < M; i++) {
			 st = new StringTokenizer(in.readLine());
			 int a = stoi(st.nextToken())-1;
			 int b = stoi(st.nextToken())-1;
			 union(a, b);
		}
		pq= new PriorityQueue<>((a,b)->(a[2]-b[2]));
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<N; j++) {
				int x = stoi(st.nextToken());
				if(i==0 || j==0 || i==j) {
					continue;
				}
				
				pq.add(new int[] {i, j, x});
			}
		}
		int cnt=0;
		int sum=0;
		List<int[]> list= new ArrayList<>();
		while(!pq.isEmpty()){
			int cur[] = pq.poll();
			if(find(cur[0]) != find(cur[1])) {
				sum+=cur[2];
				cnt++;
				union(cur[0], cur[1]);
				list.add(new int[] {cur[0],cur[1]});
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(sum).append(" ").append(cnt).append("\n");
		for(int[] arr: list) {
			sb.append(arr[0]+1).append(" ").append(arr[1]+1).append("\n");
		}
		System.out.println(sb.toString());
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a > b) {
			par[b] = a;
		} else {
			par[a] = b;
		}
	}

	static int find(int x) {
		if (x == par[x]) {
			return x;
		}
		return par[x] = find(par[x]);
	}

	static void init() {
		par = new int[N];
		for (int i = 0; i < N; i++) {
			par[i] = i;
		}
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}
