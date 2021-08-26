import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static List<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = stoi(st.nextToken());
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				int k = stoi(st.nextToken());
				list.add(k);
			}
		}
		while (N > 1) {
			int idx_1 = 0;
			int idx_2 = idx_1 + 1;
			int cnt = 0;
			List<Integer> save = new ArrayList<>();
			while (idx_1 < N * N) {
				cnt++;
				int arr[] = new int[] { list.get(idx_1), list.get(idx_2), list.get(idx_1 + N), list.get(idx_2 + N) };
				Arrays.sort(arr);
				if (cnt == N / 2) {
					idx_1 += N;
					cnt = 0;
				}
				idx_1 += 2;
				idx_2 = idx_1 + 1;
				save.add(arr[2]);
			}
			list = save;
			N/=2;
		}
		System.out.println(list.get(0));
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}