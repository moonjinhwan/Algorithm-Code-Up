import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static class Fire {
		int r, c, m, s, d;

		public Fire(int r, int c, int m, int s, int d) {
			// TODO Auto-generated constructor stub
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}
	
	static int N, M, K;
	static Stack<Fire> stack[][];
	static int dr[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int dc[] = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		K = Integer.valueOf(st.nextToken());
		stack = new Stack[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				stack[i][j] = new Stack<>();
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			Fire fire = new Fire(Integer.valueOf(st.nextToken())-1, Integer.valueOf(st.nextToken())-1,
					Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken()));
			stack[fire.r][fire.c].push(fire);
		}
		while (K-- > 0) {
			//이동
			move();
			//4개로 나누기
			div();
		}
		System.out.println(check());
	}
	
	//합 확인
	static int check() {
		int ans=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				while(!stack[i][j].isEmpty()) {
					Fire f = stack[i][j].pop();
					ans+=f.m;
				}
			}
		}
		return ans;
	}
	
	//이동
	static void move() {
		Stack<Fire> cpy[][] = new Stack[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				cpy[i][j] = new Stack<>();
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				while (!stack[i][j].isEmpty()) {
					Fire cur = stack[i][j].pop();
					int s = cur.s%N;
					int nr = i + (dr[cur.d] * s);
					int nc = j + (dc[cur.d] * s);			
					// 맵을 나가는 부분
					if (nr >= N) {
						nr -=N;
					} else if (nr < 0) {
						nr += N;
					}
					if (nc >= N) {
						nc -= N;
					} else if (nc < 0) {
						nc += N ;
					}					
					cpy[nr][nc].push(new Fire(nr, nc, cur.m, cur.s, cur.d));
				}
			}
		}
		stack = cpy;
	}
	
	//나누기
	static void div() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(stack[i][j].size()>=2) {
					int nm=0;
					int ns=0;
					int size = stack[i][j].size();
					int nd=0;
					while(!stack[i][j].isEmpty()) {
						Fire cur = stack[i][j].pop();
						nm+= cur.m;
						ns+= cur.s;
						if(cur.d%2==0) {
							nd+=2;
						}else {
							nd+=1;
						}
					}
					nm/=5;
					ns/=size;
					//질량 0 아웃
					if(nm==0) continue;
					if(nd==(size*2) || nd==size) {
						//0 2 4 6
						int d=0;
						for(int k=0; k<4; k++) {
							stack[i][j].push(new Fire(i,j,nm, ns, d));
							d+=2;
						}
					}else {
						//1 3 5 7
						int d=1;
						for(int k=0; k<4; k++) {
							stack[i][j].push(new Fire(i,j,nm, ns, d));
							d+=2;
						}
					}
				}
			}
		}
	}
}