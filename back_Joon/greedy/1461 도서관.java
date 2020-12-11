import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());
		int arr[] = new int[N];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
		}
		Arrays.sort(arr);
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < N;) {
			int x = arr[i];
			int cnt = 0;
			for (int j = 0; j < M; j++) {
				if (i+j<N && arr[i + j] > 0) {
					break;
				}
				cnt++;
			}
			if (cnt != 0) {
				list.add(Math.abs(x));
				i += cnt;
			} else {
				break;
			}
		}

		// 양수 찾기
		for (int i = N - 1; i >= 0;) {
			int x = arr[i];
			int cnt = 0;
			for (int j = 0; j < M; j++) {
				if (i-j>=0 && arr[i - j] < 0) {
					break;
				}
				cnt++;
			}
			if (cnt != 0) {
				list.add(x);
				i -= M;
			} else {
				break;
			}
		}
		Collections.sort(list);
		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			if (i == list.size() - 1) {
				sum += list.get(i);
			} else {
				sum += (list.get(i) * 2);
			}
		}
		System.out.println(sum);
	}
}