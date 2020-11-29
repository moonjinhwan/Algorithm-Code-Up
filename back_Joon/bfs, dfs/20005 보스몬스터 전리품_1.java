import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, P, BOSS;
	static int bossr, bossc;
	static int dr[] = { -1, 0, 1, 0 };
	static int dc[] = { 0, 1, 0, -1 };
	static char map[][];
	static Queue<Player> q;
	static int dps[];
	static class Player {
		int r, c, id;

		public Player(int r, int c, int id) {
			this.r = r;
			this.c = c;
			this.id = id;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		P = Integer.valueOf(st.nextToken());
		map = new char[N][M];
		q = new LinkedList<>();
		dps = new int[P];
		for (int i = 0; i < N; i++) {
			String str = in.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] >= 'a' && map[i][j] <= 'z') {
					q.add(new Player(i, j, map[i][j] - 'a'));
				}
				if (map[i][j] == 'B') {
					bossr = i;
					bossc = j;
				}
			}
		}
		for (int i = 0; i < P; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			char tmp=st.nextToken().charAt(0);
			dps[tmp - 'a'] = Integer.valueOf(st.nextToken());
		}
		BOSS = Integer.valueOf(in.readLine());
		System.out.println(bfs());
	}

	static int bfs() {
		boolean attack[] = new boolean[P];
		boolean[][][] visit = new boolean[P][N][M];
		while (BOSS > 0) {
			int size = q.size();
			while (size-- > 0) {
				Player cur = q.poll();
				if (cur.r == bossr && cur.c == bossc) {
					attack[cur.id] = true;
					continue;
				}
				for (int i = 0; i < 4; i++) {
					int nr = cur.r + dr[i];
					int nc = cur.c + dc[i];
					if (nr < 0 || nc < 0 || nr >= N || nc >= M || visit[cur.id][nr][nc])
						continue;
					if(map[nr][nc]=='X')
						continue;
					visit[cur.id][nr][nc] = true;
					q.add(new Player(nr, nc, cur.id));
				}
			}
			for(int i=0; i<P; i++) {
				if(attack[i]) {
					BOSS-=dps[i];
				}
			}
		}
		int res=0;
		for(int i=0; i<P; i++) {
			if(attack[i]) res++; 
		}
		return res;
	}
}