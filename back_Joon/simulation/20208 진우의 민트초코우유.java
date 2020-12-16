import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M, H, max = 0;
	static boolean visit[];
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static int sr,sc;
	static ArrayList<Pair> p;
	static class Pair{
		int r,c;
		public Pair(int r, int c) {
			// TODO Auto-generated constructor stub
			this.r=r;
			this.c=c;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		H = Integer.valueOf(st.nextToken());
		int map[][] = new int[N][N];
		p = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.valueOf(st.nextToken());
				if (map[i][j] == 1) {
					sr = i;
					sc = j;
				}else if(map[i][j]==2) {
					p.add(new Pair(i,j));
				}
			}
		}
		visit = new boolean[p.size()];
		int arr[] = new int[p.size()];
		perm(0, arr);
		System.out.println(max);
	}
	static void perm(int idx, int arr[]) {
		if(idx==p.size()) {
			findMint(arr);
			return;
		}
		for(int i=0; i<p.size(); i++) {
			if(visit[i]) continue;
			visit[i]=true;
			arr[idx] = i;
			perm(idx+1, arr);
			visit[i]=false;
		}
	}
	
	static void findMint(int arr[]) {
		int hp = M;
		int r=sr;
		int c=sc;
		int cnt=0;
		for(int i=0; i<arr.length; i++) {
			//거리구하기
			int k = arr[i];
			int dist = Math.abs(r-p.get(k).r)+Math.abs(c-p.get(k).c);
			int toHome = Math.abs(sr-p.get(k).r)+Math.abs(sc-p.get(k).c);
			if(hp >= dist) {//다음 민트 찾으러감
				cnt++;
				hp -= dist;//체력씀
				hp += H;//회복
				if(hp >= toHome) {//집 갈 체력이 됨
					max = max < cnt ? cnt : max;//간다
				}
				r = p.get(k).r;
				c = p.get(k).c;
			}
			else {
				return;
			}
		}
	}
}