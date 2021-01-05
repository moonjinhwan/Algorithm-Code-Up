import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int D, N;
	static int arr[];
	static int dep, min;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		D = Integer.valueOf(st.nextToken());
		N = Integer.valueOf(st.nextToken());
		arr = new int[D];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < D; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
		}
		go();// 지름 재설정
		dep = D-1;
		min = Integer.MAX_VALUE;
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			int target = Integer.valueOf(st.nextToken());
			binary(target, 0, dep );
		}
		min++;
		System.out.println(min);
	}

	static void go() {
		for (int i =1; i<D; i++) {
			if(arr[i] > arr[i-1]) {
				arr[i] = arr[i-1];
			}
		}
	}

	static void binary(int target, int topIdx, int botIdx) {
		int res = -1;
		while (topIdx <= botIdx) {
			int mid = (topIdx + botIdx) / 2;
			if (arr[mid] >= target) {
				res = mid;
				topIdx = mid + 1;
			} else {
				botIdx = mid - 1;
			}
		}
		min = Math.min(min, res);
		dep = res-1;
	}
}