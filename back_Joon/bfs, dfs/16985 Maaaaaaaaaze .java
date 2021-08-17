import java.util.*;
import java.io.*;

public class Main {
	static int map[][][], newmap[][][];
	static int arr[][] = { { 0, 0 }, { 0, 4 }, { 4, 0 }, { 4, 4 } };
	static int D[][] = { { -1, 0, 0 }, { 1, 0, 0 }, { 0, -1, 0 }, { 0, 0, 1 }, { 0, 1, 0 }, { 0, 0, -1 } };
	static int INF = 987654321, result = INF;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new int[5][5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				st = new StringTokenizer(in.readLine());
				for (int k = 0; k < 5; k++) {
					map[i][j][k] = stoi(st.nextToken());
				}
			}
		}
		recur(0);
		if (result == INF) {
			System.out.println(-1);
		} else
			System.out.println(result);
	}

	static void recur(int dep) {
		if (dep == 5) {
			// 판 쌓기
			upstair(new ArrayList<>());
			return;
		}
		// 회전
		for (int n = 0; n < 4; n++) {
			int[][] copy = new int[5][5];
			for (int i = 0; i < 5; i++) {
				System.arraycopy(map[dep][i], 0, copy[i], 0, 5);
			}

			for (int r = 0; r < 5; r++) {
				for (int c = 0; c < 5; c++) {
					map[dep][c][4 - r] = copy[r][c];// 시계방향 회전
				}
			}
			recur(dep + 1);
		}
	}

	static void upstair(List<Integer> list) {
		if (list.size() == 5) {
			newmap = new int[5][5][5];
			// 층을 재배열
			for (int i = 0; i < 5; i++) {
				int dep = list.get(i);
				for (int j = 0; j < 5; j++) {
					newmap[dep][j] = Arrays.copyOf(map[i][j], 5);
				}
			}
			// 시작, 끝값 구하기
			for (int i = 0; i < 4; i++) {
				int start[] = arr[i];
				int end[] = { 4 - start[0], 4 - start[1] };
				if (newmap[0][start[0]][start[1]] == 1 && newmap[4][end[0]][end[1]] == 1)
					bfs(start, end);
			}
			return;
		}
		// 재배열할 순서 구하기
		for (int i = 0; i < 5; i++) {
			if (!list.contains(i)) {
				list.add(i);
				upstair(list);
				list.remove(list.size() - 1);
			}
		}
	}

	static void bfs(int start[], int end[]) {
		Queue<int[]> q = new LinkedList<>();
		boolean visit[][][] = new boolean[5][5][5];
		q.add(new int[] { 0, start[0], start[1], 0 });
		visit[0][start[0]][start[1]] = true;
		while (!q.isEmpty()) {
			int cur[] = q.poll();
			if (cur[0] == 4 && cur[1] == end[0] && cur[2] == end[1]) {
				result = Math.min(result, cur[3]);
				return;
			}
			for (int k = 0; k < 6; k++) {
				int nh = cur[0] + D[k][0];
				int nr = cur[1] + D[k][1];
				int nc = cur[2] + D[k][2];
				if (nh < 0 || nh >= 5 || nr < 0 || nr >= 5 || nc < 0 || nc >= 5 || visit[nh][nr][nc]
						|| newmap[nh][nr][nc] == 0)
					continue;
				visit[nh][nr][nc] = true;
				q.add(new int[] { nh, nr, nc, cur[3] + 1 });
			}
		}
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}
