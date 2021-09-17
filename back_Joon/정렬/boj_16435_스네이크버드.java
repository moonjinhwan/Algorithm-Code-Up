import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class boj_16435_스네이크버드 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = stoi(st.nextToken());
		int M = stoi(st.nextToken());
		int arr[] = new int[N];
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = stoi(st.nextToken());
		}
		Arrays.sort(arr);
		for(int a: arr) {
			if(M>=a)
				M++;
		}
		System.out.println(M);
	};

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}