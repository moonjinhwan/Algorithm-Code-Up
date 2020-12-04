import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T, arr[], N;
	static int max, min;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		T = Integer.valueOf(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			N = Integer.valueOf(st.nextToken());
			arr = new int[N];
			st = new StringTokenizer(in.readLine(), " ");
			int op[] = new int[4];
			for (int i = 0; i < 4; i++) {
				op[i] = Integer.valueOf(st.nextToken());
			}
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.valueOf(st.nextToken());
			}
			max = -987654321;
			min = 987654321;
			powerSet(1, op[0], op[1], op[2], op[3], arr[0]);
			int res = max - min;
			System.out.println("#" + tc + " " + res);
		}
	}

	static void powerSet(int idx, int plus, int minus, int mul, int div, int sum) {

		if (idx == N ) {
			if (max < sum) {
				max = sum;
			}
			if (min > sum) {
				min = sum;
			}
			return;
		}
		if (plus > 0)
			powerSet(idx + 1, plus - 1, minus, mul, div, sum + arr[idx]);
		if (minus > 0)
			powerSet(idx + 1, plus, minus - 1, mul, div, sum - arr[idx]);
		if (mul > 0)
			powerSet(idx + 1, plus, minus, mul - 1, div, sum * arr[idx]);
		if (div > 0 && arr[idx]!=0)
			powerSet(idx + 1, plus, minus, mul, div - 1, sum / arr[idx]);
	}
}
