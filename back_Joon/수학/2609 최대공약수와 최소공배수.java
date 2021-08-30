import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N=stoi(st.nextToken());
		int M=stoi(st.nextToken());
		int ans=0;
		if(N>=M) {
			ans=dfs(N,M);
		}else {
			ans=dfs(M, N);
		}
		System.out.println(ans);
		int ans2=(N*M)/ans;
		System.out.println(ans2);
	}
	static int dfs(int a, int b) {
		if(b==0) {
			return a;
		}
		return dfs(b, a%b);
	}
	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}