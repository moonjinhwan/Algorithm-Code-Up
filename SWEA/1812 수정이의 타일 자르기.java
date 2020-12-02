import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int T, N, M;

	static class Pair implements Comparable<Pair> {
		int r, c;

		public Pair(int r, int c) {
			this.r = r;
			this.c = c;
			// TODO Auto-generated constructor stub
		}

		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			int tmp = this.r * this.c;
			int tmp2 = o.r * o.c;
			return tmp2 - tmp;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		T = Integer.valueOf(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			PriorityQueue<Pair> pq = new PriorityQueue<>();
			st = new StringTokenizer(in.readLine(), " ");
			N = Integer.valueOf(st.nextToken());
			M = Integer.valueOf(st.nextToken());
			pq.add(new Pair(M, M));
			st = new StringTokenizer(in.readLine(), " ");
			Integer arr[] = new Integer[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.valueOf(st.nextToken());
			}
			Arrays.sort(arr, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return o2 - o1;
				}
			});
			int cnt = 1;
			for (int i = 0; i < N; i++) {
				int k = go(arr[i]);
				Queue<Pair> temp = new LinkedList<>();
				boolean flag=false;
				while (!pq.isEmpty()) {
					Pair cur = pq.peek();
					if (k <= cur.r && k <= cur.c) {
						flag=true;
						pq.poll();
						pq.add(new Pair(cur.r - k, cur.c));
						pq.add(new Pair(k, cur.c - k));
						break;
					} else {
						temp.add(pq.poll());
					}
				}
				while(!temp.isEmpty()) {
					pq.add(temp.poll());
				}
				if(!flag) {
					cnt++;
					pq.add(new Pair(M - k, M));
					pq.add(new Pair(k, M - k));
				}
			}
			System.out.println("#" + tc + " " + cnt);
		}
	}

	static int go(int l) {
		int k = 1;
		if(l==0) return 1;
		for (int i = 0; i < l; i++) {
			k = k * 2;
		}
		return k;
	}
}