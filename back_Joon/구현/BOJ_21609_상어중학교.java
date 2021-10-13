import java.io.*;
import java.util.*;

public class BOJ_21609_상어중학교 {
	static int grid[][], N, M, SUM;
	static boolean visit[][];
	static int D[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static Queue<int[]> pq;
	static List<int[]> area;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		grid = new int[N][N];
		SUM = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				grid[i][j] = stoi(st.nextToken());
			}
		}
		while (true) {
			boolean success = false;
			visit = new boolean[N][N];
			int t = 1;
			area = new ArrayList<>();
			pq = new PriorityQueue<>((a, b) -> {
				if (a[0] == b[0]) {
					if (a[1] == b[1]) {
						if (b[2] == a[2]) {
							return b[3] - a[3];
						}
						return b[2] - a[2];
					}
					return b[1] - a[1];
				}
				return b[0] - a[0];
			});

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (grid[i][j] >= 1 && !visit[i][j]) {
						if (bfs(i, j))
							success = true;
					}
				}
			}
			if (!success) {// 종료 체크
				break;
			}
			int cur[] = pq.poll();
			SUM += (cur[0] * cur[0]);
			// 블록을 0으로 바꿔야함. -2로 초기화
			zeroCover();
			// 내리기
			down();
			// 돌리기
			rotate();
			// 내리기
			down();
		}
		System.out.println(SUM);
	}

	static void down() {
		for (int j = 0; j < N; j++) {
			Queue<int[]> q = new LinkedList<>();
			for (int i = N - 1; i >= 0; i--) {
				if (grid[i][j] >= -1) {
					q.add(new int[] { i, j, grid[i][j] });
					if (grid[i][j] >= 0)
						grid[i][j] = -2;
				}
			}
			int row = N - 1;
			while (!q.isEmpty()) {
				int pos[] = q.poll();
				int val = pos[2]; int r = pos[0]; int c = pos[1];
				if (val == -1) {
					row = r;
				} else {
					grid[row][c] = val;
				}
				row--;
			}
		}
	}

	static void rotate() {
		int origin[][] = new int[N][N];
		for (int i = 0; i < N; i++) {
			origin[i] = grid[i].clone();
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				grid[N - j - 1][i] = origin[i][j];
		}
	}

	static boolean bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		List<int[]> list = new ArrayList<>();
		q.add(new int[] { r, c });
		int rainbowCnt = 0;
		int nomalCnt = 1;
		int color = grid[r][c];
		visit[r][c] = true;
		list.add(new int[] { r, c });
		while (!q.isEmpty()) {
			int cur[] = q.poll();
			for (int k = 0; k < 4; k++) {
				int nr = cur[0] + D[k][0];
				int nc = cur[1] + D[k][1];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N || visit[nr][nc] || grid[nr][nc] == -1)
					continue;
				if (grid[nr][nc] != color && grid[nr][nc] != 0)
					continue;
				visit[nr][nc] = true;
				if (grid[nr][nc] != 0)
					nomalCnt++;
				if (grid[nr][nc] == 0)
					rainbowCnt++;
				q.add(new int[] { nr, nc });
				list.add(new int[] { nr, nc });
			}
		}
		if (nomalCnt + rainbowCnt <= 1) {// 블록크기가 1이하이면 종료
			return false;
		}
		int point[] = new int[] { rainbowCnt + nomalCnt, rainbowCnt, r, c };
		pq.add(point);
		if (pq.peek() == point) {// 우선순위가 바뀌면 area를 갱신해야함.
			area = list;
		}
		rollback(list);// 무지개는 다시 미방문 처리함.
		return true;
	}

	static void rollback(List<int[]> list) {//무지개는 다시 미방문상태로 전환
		for (int[] p : list) {
			int r = p[0];
			int c = p[1];
			if (grid[r][c] == 0) {
				visit[r][c] = false;
			}
		}
	}

	static void zeroCover() {//우선순위 높은 블록을 모두 빈칸으로 전환
		for (int[] pos : area) {
			int r = pos[0];
			int c = pos[1];
			grid[r][c] = -2;
		}
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}