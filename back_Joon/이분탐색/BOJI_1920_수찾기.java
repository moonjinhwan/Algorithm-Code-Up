import java.io.*;
import java.util.*;

public class BOJI_1920_¼öÃ£±â {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = stoi(st.nextToken());
		int arr[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = stoi(st.nextToken());
		}
		Arrays.sort(arr);
		st = new StringTokenizer(br.readLine());
		int M = stoi(st.nextToken());
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		while (M-- > 0) {
			int k = stoi(st.nextToken());
			sb.append(bin(arr, k)).append("\n");
		}
		System.out.println(sb.toString());
	}

	static int bin(int arr[], int T) {
		int l= 0;
		int r =arr.length-1;
		while(l<=r) {
			int mid = (l+r)/2;
			if(arr[mid] < T) {
				l = mid+1;
			}else if(arr[mid] > T) {
				r = mid-1;
			}else {
				return 1;
			}
		}
		return 0;
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}