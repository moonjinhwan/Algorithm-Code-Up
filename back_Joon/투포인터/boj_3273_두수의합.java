import java.io.*;
import java.util.*;

public class boj_3273_두수의합 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = stoi(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int arr[] = new int[N];
		for(int i=0; i<N; i++) {
			arr[i]=stoi(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int X = stoi(st.nextToken());
		Arrays.sort(arr);
		int L=0;
		int R=N-1;
		int A=0;
		while(L<R) {
			if(arr[L]+arr[R]==X) {
				A++;
				L++; R--;
			}else if(arr[L]+arr[R]<X) {
				L++;
			}else {
				R--;
			}
		}
		System.out.println(A);
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}