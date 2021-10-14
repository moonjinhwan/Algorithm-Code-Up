import java.io.*;
import java.util.*;

public class BOJ_21611_마법사상어와블리자드 {
	static int[][] grid;
	static int N, M, SUM;
	static int[][] D = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int[][] P = { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };
	static List<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		SUM = 0;
		grid = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				grid[i][j] = stoi(st.nextToken());
			}
		}
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int d = stoi(st.nextToken()) - 1;
			int s = stoi(st.nextToken());
			list = new ArrayList<>();
			blizard(d, s);
			changeLine();
			while (true) {// 계속 폭발한다.
				if (!boomb())
					break;
			}
			remake();// 형상변환
			changeSpiral();
		}
		System.out.println(SUM);
	}

	static void changeSpiral() {
		int r = N / 2;
		int c = N / 2;
		int re = 0;
		int idx = 0;
		int[][] copy = new int[N][N];
		copy[r][c] = 0;
		out: while (list.size() > 0) {
			for (int d = 0; d < 4; d++) {
				if (d == 0 || d == 2)
					re++;
				for (int i = 0; i < re; i++) {
					r += P[d][0];
					c += P[d][1];
					if (c < 0 || list.size() == idx)
						break out;
					copy[r][c] = list.get(idx);
					idx++;
				}
			}
		}
		grid = copy;
	}

	static void remake() {// 형태변환
		List<Integer> copy = new ArrayList<>();
		int cnt = 1;
		if(list.size()==0) return;
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i) == list.get(i + 1)) {
				cnt++;
			} else {
				copy.add(cnt);
				copy.add(list.get(i));
				cnt = 1;
			}
		}
		copy.add(cnt);
		copy.add(list.get(list.size() - 1));
		list = copy;
	}

	static boolean boomb() {
		List<Integer> copy = new ArrayList<>();
		int cnt = 1;
		boolean success = false;
		if(list.size()==0) return success;
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i) == list.get(i + 1)) {
				cnt++;
			} else {
				if (cnt < 4) {
					while (cnt-- > 0) {
						copy.add(list.get(i));
					}
				} else {
					int color = list.get(i);
					SUM += (color * cnt);
					success = true;
				}
				cnt = 1;
			}
		}
		if(cnt<4) {
			while(cnt-- > 0) {
				copy.add(list.get(list.size() - 1));
			}
		}else {
			SUM+=(list.get(list.size()-1)*cnt);
		}
		list = copy;
		return success;
	}

	static void changeLine() {
		int r = N / 2;
		int c = N / 2;
		int re = 0;
		out: while (true) {
			for (int d = 0; d < 4; d++) {
				if (d == 0 || d == 2)
					re++;
				for (int i = 0; i < re; i++) {
					r += P[d][0];
					c += P[d][1];
					if (c < 0)
						break out;
					if (grid[r][c] == 0)
						continue;
					list.add(grid[r][c]);
				}
			}
		}
	}

	static void blizard(int d, int s) {
		int r = N / 2;
		int c = N / 2;
		while (s-- > 0) {
			r += D[d][0];
			c += D[d][1];
			grid[r][c] = 0;
		}
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}