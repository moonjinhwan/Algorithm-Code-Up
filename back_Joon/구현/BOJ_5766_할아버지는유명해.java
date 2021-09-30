import java.io.*;
import java.util.*;

public class BOJ_5766_할아버지는유명해 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while(true) {
			st = new StringTokenizer(br.readLine());
			int N = stoi(st.nextToken());
			int M = stoi(st.nextToken());
			if(N==0 && M==0) break;
			int arr[] = new int[10001];
			int MAX =0;
			int SECMAX = 0;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					int t = stoi(st.nextToken());
					arr[t]++;
				}
			}
			for(int i=1; i<10001; i++) {
				if(arr[i] > MAX) {
					SECMAX = MAX;
					MAX=arr[i];
				}else if(arr[i] > SECMAX) {
					SECMAX = arr[i];
				}
			}
			for(int i=1; i<10001; i++) {
				if(arr[i]==SECMAX) {
					sb.append(i).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}