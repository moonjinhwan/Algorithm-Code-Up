import java.io.*;
import java.util.*;

public class BOji_20551_Sort마스터배지훈의후계자 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = stoi(st.nextToken());
		int M = stoi(st.nextToken());
		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = stoi(st.nextToken());
		}
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int k = stoi(st.nextToken());
			sb.append(bin(arr, k)).append("\n");
		}
		System.out.println(sb.toString());
	}

	static int bin(int arr[], int T) {
		int R = arr.length - 1;
		int L = 0;
		int result = -1;
		while (L <= R) {
			int mid = (L + R) / 2;
			if (arr[mid] < T) {
				L = mid + 1;
			} else if (arr[mid] >= T) {
				if(T==arr[mid]) result = mid;
				R = mid - 1;
			}
		}
		return result;
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}