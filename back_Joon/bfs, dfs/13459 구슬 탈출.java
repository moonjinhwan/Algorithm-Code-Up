import java.util.*;
import java.io.*;

public class Main {
	static int N, M, ans = 0;
	static char[][] map;
	static int d[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		map = new char[N][M];
		int r = 0, c = 0, r2 = 0, c2 = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			map[i] = st.nextToken().toCharArray();
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'R') {
					r = i;
					c = j;
					map[i][j]='.';
				} else if (map[i][j] == 'B') {
					r2 = i;
					c2 = j;
					map[i][j]='.';
				}
			}
		}
		dfs(0, r, c, r2, c2);
		System.out.println(ans);
	}

	static void dfs(int dep, int r, int c, int r2, int c2) {
		if (ans == 1)
			return;
		if (dep == 10) {
			return;
		}
		for (int k = 0; k < 4; k++) {
			int red[] = { r, c };
			int blue[] = { r2, c2 };
			move(red, k);
			move(blue, k);
			int type = check(red, blue);//0: 실패, 1: 성공, 2: 빈칸
			if (type == 0) {
				continue;
			} else if (type == 1) {
				// 정답
				ans = 1;
				return;
			} else {
				if (red[0] == blue[0] && red[1] == blue[1]) {
					if (k == 0) {// 상
						if (r < r2) {// 처음 레드가 더 위에 있음
							blue[0] += 1;
						} else {
							red[0] +=1;
						}
					}else if(k==2) {
						if (r > r2) {
							blue[0] -= 1;
						} else {
							red[0] -=1;
						}
					}else if(k==1) {
						if (c > c2) {
							blue[1] -= 1;
						} else {
							red[1] -=1;
						}
					}
					else if(k==3){// 좌
						if (c < c2) {
							blue[1] += 1;
						} else
							red[1] += 1;
					}
				}
			}
			dfs(dep + 1, red[0], red[1], blue[0], blue[1]);
		}
	}

	static int check(int red[], int blue[]) {
		int r = red[0], c = red[1], r2 = blue[0], c2 = blue[1];
		if (map[r][c] == 'O' && map[r2][c2] == 'O') {
			return 0;
		}
		if (map[r][c] == 'O' && map[r2][c2] != 'O') {
			return 1;
		}
		if (map[r][c] != 'O' && map[r2][c2] == 'O') {
			return 0;
		}
		if (map[r][c] != 'O' && map[r2][c2] != 'O') {
			return 2;
		}
		return 0;
	}

	static void move(int pair[], int k) {
		int r = pair[0], c = pair[1];
		while (true) {
			r+=d[k][0];
			c+=d[k][1];
			if (map[r][c] == '#') {
				r-=d[k][0];
				c-=d[k][1];
				break;
			} else if (map[r][c] == 'O') {
				break;
			}
		}
		pair[0] = r;
		pair[1] = c;
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}