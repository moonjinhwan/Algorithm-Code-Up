import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int T;
	static char map[][];
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static int min, move;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		T = Integer.valueOf(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			map = new char[5][9];
			min = 987654321;
			move = 0;
			int cnt = 0;
			for (int i = 0; i < 5; i++) {
				st = new StringTokenizer(in.readLine(),"");
				String str = st.nextToken();
				for (int j = 0; j < 9; j++) {
					map[i][j] = str.charAt(j);
					if (map[i][j] == 'o')
						cnt++;
				}
			}
			in.readLine();
			dfs(cnt, 0);
			System.out.println(min + " " + move);
		}
	}

	static void dfs(int cnt, int mv) {// 남은 o 개수, 이동수
		min = min > cnt ? cnt : min;
		move = mv > move ? mv : move;
		char cpy[][] = new char[5][9];
		cpyMap(cpy);//맵 카피
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 9; j++) {
				if (map[i][j] == 'o') {
					for (int k = 0; k < 4; k++) {
						if (jump(i, j, k)) {
							// 재귀
							dfs(cnt - 1, mv + 1);
							ori(cpy);
						}
					}
				}
			}
		}
	}
	static void ori(char cpy[][]) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 9; j++) {
				map[i][j] = cpy[i][j];
			}
		}
	}
	static void cpyMap(char cpy[][]) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 9; j++) {
				cpy[i][j] = map[i][j];
			}
		}
	}
	
	static boolean jump(int r, int c, int k) {
		int sr = r + dr[k];
		int sc = c + dc[k];
		int nr = sr + dr[k];
		int nc = sc + dc[k];
		if (sr < 0 || sc < 0 || sr >= 5 || sc >= 9)
			return false;
		if (nr < 0 || nc < 0 || nr >= 5 || nc >= 9)
			return false;
		if (map[sr][sc] == 'o' && map[nr][nc] == '.') {
			map[nr][nc] = 'o';
			map[r][c] = '.';
			map[sr][sc] = '.';
			return true;
		}
		return false;
	}
}
