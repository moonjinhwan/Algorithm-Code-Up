import java.util.*;
import java.io.*;

public class Main {
	static int N, K, M;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = stoi(st.nextToken());
		K = stoi(st.nextToken());
		M = stoi(st.nextToken());
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int gb = stoi(st.nextToken());
			if (gb > (2 * K))
				list.add(gb-(2*K));
			if(2*K > gb && gb>K)
				list.add(gb-K);				
		}
		int start = 1, end = 1000000000;
		int ans = -1;
		while (start <= end) {
			int mid = (start + end) / 2;
			int count = calc(list, mid);
			if (count >= M) {
				ans = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		System.out.println(ans);
	}

	static int calc(List<Integer> list, int mid) {
		int sum = 0;
		for (int k : list) {
			sum += (k / mid);
		}
		return sum;
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}