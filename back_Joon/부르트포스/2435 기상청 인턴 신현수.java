import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = stoi(st.nextToken());
		int K = stoi(st.nextToken());
		int sum = 0, answer =-100;
		int arr[] = new int[N];
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = stoi(st.nextToken());
			sum+=arr[i];
			if(i==K-1) {
				answer = Math.max(sum, answer);
			}
			if(i>=K) {
				sum-=arr[i-K];
				answer = Math.max(sum, answer);
			}
		}
		System.out.println(answer);
	}
	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}