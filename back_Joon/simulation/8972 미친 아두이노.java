import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int dr[] = { 0, 1, 1, 1, 0, 0, 0, -1, -1, -1 };
	static int dc[] = { 0, -1, 0, 1, -1, 0, 1, -1, 0, 1 };
	static int R, C;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		R = Integer.valueOf(st.nextToken());
		C = Integer.valueOf(st.nextToken());
		char map[][] = new char[R][C];
		int r = 0, c = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(in.readLine(), "");
			String str = st.nextToken();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'I') {
					r = i;
					c = j;
				}
			}
		}
		String str = in.readLine();
		boolean flag = true;
		int turn=0;
		out: for (int k = 0; k < str.length(); k++) {
			int d = str.charAt(k)-'0';
			char temp[][] = new char[R][C];
			int num[][] = new int[R][C];
			r += dr[d];
			c += dc[d];
			temp[r][c] = 'I';
			//종수가 움직이다가 만나는 경우
			if (map[r][c] == 'R') {
				flag=false;
				turn=k+1;
				break;
			}
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] == 'R') {
						int d1 = findDist(r, c, i, j);
						//미친로봇이 움직이다가 종수와 만나는 경우
						if (temp[i + dr[d1]][j + dc[d1]] == 'I') {
							flag=false;
							turn = k+1;
							break out;
						}
						temp[i + dr[d1]][j + dc[d1]] = 'R';
						num[i + dr[d1]][j + dc[d1]]++;
					}
				}
			}
			// num이 3이상이면 다 파괴하기
			// temp를 다시 원본에 옮기기
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (num[i][j] >= 2)
						temp[i][j] = '.';
					if (temp[i][j] == 'I' || temp[i][j] == 'R')
						map[i][j] = temp[i][j];
					else {
						map[i][j] = '.';
					}
				}
			}
		}
		if(flag) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}else {
			System.out.println("kraj "+turn);
		}
	}

	static public int findDist(int centerr, int centerc, int i, int j) {
		int min = Integer.MAX_VALUE;
		int d = 0;
		for (int k = 1; k <= 9; k++) {
			int nr = i + dr[k];
			int nc = j + dc[k];
			if (nr < 0 || nc < 0 || nr >= R || nc >= C)
				continue;
			int dist = Math.abs(centerr - nr) + Math.abs(centerc - nc);
			if (min > dist) {
				d = k;
				min = dist;
			}
		}
		return d;
	}
}