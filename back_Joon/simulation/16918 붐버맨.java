import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R, C, N;

	static class Pair {
		char b;
		int time;

		public Pair(char b, int time) {
			// TODO Auto-generated constructor stub
			this.b = b;
			this.time = time;
		}
	}

	static Pair p[][];
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.valueOf(st.nextToken());
		C = Integer.valueOf(st.nextToken());
		N = Integer.valueOf(st.nextToken());
		p = new Pair[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(in.readLine());
			String tmp = st.nextToken();
			for (int j = 0; j < C; j++) {
				p[i][j] = new Pair(tmp.charAt(j), 1);
			}
		}
		for (int i = 2; i <= N; i++) {
			Pair cpy[][] = new Pair[R][C];
			for(int r=0; r<R; r++) {
				for(int c=0; c<C; c++) {
					if(p[r][c].b == '.') {
						p[r][c].b='O';
						p[r][c].time=0;
					}else {
						p[r][c].time++;
					}
				}
			}
			for(int r=0; r<R; r++) {
				for(int c=0; c<C; c++) {
					cpy[r][c] = new Pair(p[r][c].b, p[r][c].time);
				}
			}
			for(int r=0; r<R; r++) {
				for(int c=0; c<C; c++) {
					if(cpy[r][c].b=='O' && cpy[r][c].time==3) {
						p[r][c].b = '.';
						p[r][c].time = 0;
						for(int k=0; k<4; k++) {
							int nr = r+dr[k];
							int nc = c+dc[k];
							if(nr<0 || nr>=R || nc<0 || nc>=C) continue;
							p[nr][nc].b = '.';
							p[nr][nc].time = 0;
						}
					}
				}
			}
		}
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++){
				System.out.print(p[i][j].b);
			}
			System.out.println();
		}
	}
}