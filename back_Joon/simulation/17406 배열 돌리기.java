import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K, map[][];
	static boolean visit[];
	static int min = Integer.MAX_VALUE;
	static class Pair {
		int r, c, t;

		public Pair(int r, int c, int t) {
			// TODO Auto-generated constructor stub
			this.r = r;
			this.c = c;
			this.t = t;
		}
	}

	static Pair p[];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		K = Integer.valueOf(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.valueOf(st.nextToken());
			}
		}
		p = new Pair[K];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine());
			int r = Integer.valueOf(st.nextToken())-1;
			int c = Integer.valueOf(st.nextToken())-1;
			int t = Integer.valueOf(st.nextToken());
			p[i] = new Pair(r, c, t);
		}
		visit = new boolean[K];
		int arr[] = new int[K];
		dfs(0, arr);
		System.out.println(min);
	}

	static void dfs(int idx, int arr[]) {
		if (idx == K) {
			//복사
			int cpyMap[][] = new int[N][M];
			for(int i =0; i<N; i++) {
				for(int j=0; j<M; j++) {
					cpyMap[i][j] = map[i][j];
				}
			}
			for (int i = 0; i < K; i++) {
				int n = arr[i];
				// 시작점 끝점 구하기
				int sR = p[n].r - p[n].t;
				int sC = p[n].c - p[n].t;
				int dR = p[n].r + p[n].t;
				int dC = p[n].c + p[n].t;
				while (true) {
					// 회전
					
					if(sR==dR || sC==dC) {
						break;
					}else {
						rotate(sR,sC,dR,dC);
						sR+=1;
						sC+=1;
						dR-=1;
						dC-=1;
					}
				}
			}
			sum();
			//복구
			map = cpyMap;
			return;
		}
		for (int i = 0; i < K; i++) {
			if (visit[i])
				continue;
			visit[i] = true;
			arr[idx] = i;
			dfs(idx + 1, arr);
			visit[i] = false;
		}
	}

	static void rotate(int sR, int sC, int dR, int dC) {
		int rowSize = dR - sR + 1;
		int colSize = dC - sC + 1;
		int tmp = map[sR][sC];
		// 왼면
		for (int i = sR; i < dR; i++) {
			map[i][sC] = map[i + 1][sC];
		}
		// 아랫면
		for (int j = sC; j < dC; j++) {
			map[dR][j] = map[dR][j + 1];
		}
		// 오른면
		for (int i = dR; i > sR; i--) {
			map[i][dC] = map[i - 1][dC];
		}
		// 아랫면
		for (int j = dC; j > sC+1; j--) {
			map[sR][j] = map[sR][j - 1];
		}
		map[sR][sC+1] = tmp;
	}
	static void sum() {
		for(int i=0; i<N; i++) {
			int sum=0;
			for(int j=0; j<M; j++) {
				sum+=map[i][j];
			}
			if(min > sum)
				min = sum;
		}
	}
}