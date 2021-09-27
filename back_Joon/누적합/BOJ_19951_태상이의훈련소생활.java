import java.io.*;
import java.util.*;

//나의 인생에는 수학과 함계
public class BOJ_19951_태상이의훈련소생활 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = stoi(st.nextToken());
		int M = stoi(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int arr[] = new int[N+1];
		int dp[] = new int[N+2];
		for(int i=1; i<=N; i++) {
			arr[i] = stoi(st.nextToken());
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s=stoi(st.nextToken());
			int e=stoi(st.nextToken());
			int v = stoi(st.nextToken());
			dp[s]+=v;
			dp[e+1]+=(-v);
		}
		for(int i=2; i<=N; i++) {
			dp[i] += dp[i-1];
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++) {
			dp[i]+=arr[i];
			sb.append(dp[i]).append(" ");
		}
		System.out.println(sb);
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}