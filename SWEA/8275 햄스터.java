import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T, N, X, M, max, res[];
	static Pair list[];

	static class Pair {
		int l, r, s;

		public Pair(int l, int r, int s) {
			// TODO Auto-generated constructor stub
			this.l = l;
			this.r = r;
			this.s = s;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(),"");
		T = Integer.valueOf(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			N = Integer.valueOf(st.nextToken());
			X = Integer.valueOf(st.nextToken());
			M = Integer.valueOf(st.nextToken());
			list = new Pair[M];
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				int l = Integer.valueOf(st.nextToken())-1;
				int r = Integer.valueOf(st.nextToken())-1;
				int s = Integer.valueOf(st.nextToken());
				list[i] = new Pair(l, r, s);
			}
			int sel[] = new int[N];
			res = new int[N];
			max=-1;
			perm(0, sel);
			if(max==-1) {
				System.out.println("#"+tc+" "+-1);
			}else {
				StringBuilder sb = new StringBuilder();
				sb.append("#").append(tc+" ");
				for(int i=0; i<N; i++) {
					sb.append(res[i]+" ");
				}
				System.out.println(sb);
			}
		}
	}
	static void perm(int idx, int sel[]) {
		if(idx==N) {
			for(int i=0; i<M; i++) {
				if(!check(list[i], sel)) 
					return;
			}
			int sum=0;
			for(int i=0; i<N; i++)
				sum+=sel[i];
			if(max < sum)
			{
				max = sum;
				for(int i=0; i<N; i++) {
					res[i] = sel[i];
				}
			}
			return;
		}
		for(int i=0; i<=X; i++) {
			sel[idx] = i;
			perm(idx+1, sel);
		}
	}
	static boolean check(Pair tmp, int sel[]) {
		int sum=0;
		for(int i=tmp.l; i<=tmp.r; i++) {
			sum+=sel[i];
		}
		if(sum== tmp.s) {
			return true;
		}else {
			return false;
		}
	}
}
