import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int T, res;
	static int D, W, K, map[][];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		T = Integer.valueOf(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			D = Integer.valueOf(st.nextToken());
			W = Integer.valueOf(st.nextToken());
			K = Integer.valueOf(st.nextToken());
			map = new int[D][W];
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.valueOf(st.nextToken());
				}
			}
			res = Integer.MAX_VALUE;
			int cnt = 0;
			if (K == 1) {
				System.out.println("#" + tc + " " + "0");
			} else {
				comb(0, 0);
				System.out.println("#" + tc + " " + res);
			}
		}
	}

	static boolean checkPass() {
		int total = 0;
		for (int j = 0; j < W; j++) {
			int cnt = 1;
			boolean flag = false;
			for (int i = 1; i < D; i++) {
				if (map[i][j] == map[i - 1][j]) {
					cnt++;
				} else {
					cnt = 1;
				}
				if (cnt >= K) {
					total++;
					flag = true;
					break;
				}
			}
			if (!flag) {
				return false;
			}
		}
		if (total == W)
			return true;
		else
			return false;
	}

	static void comb(int arr_idx, int cnt) {
		if (res < cnt) {
			return;
		}
		if (arr_idx == D) {
			if (checkPass()) {
				res = res > cnt ? cnt : res;
			}
			return;
		}
		//원래 배열중에서 한 행을 복사
		int tmp[] = new int[W];
		for (int j = 0; j < W; j++) {
			tmp[j] = map[arr_idx][j];
		}

		// 아무것도 안 넣음
		comb(arr_idx + 1, cnt);

		// a넣음
		for (int j = 0; j < W; j++) {
			map[arr_idx][j] = 0;
		}
		comb(arr_idx + 1, cnt + 1);

		// b넣음
		for (int j = 0; j < W; j++) {
			map[arr_idx][j] = 1;
		}
		comb(arr_idx + 1, cnt + 1);
		
		//a와 b를 넣어서 바뀐 행을 원상복귀
		for (int j = 0; j < W; j++) {
			map[arr_idx][j] = tmp[j];
		}
	}
}