import java.util.*;
import java.io.*;

public class Main {
	static int N, M, K, arr[], parent[];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		K = stoi(st.nextToken());
		arr = new int[N + 1];
		parent = new int[N + 1];
		for (int i = 1; i <=N; i++) {
			parent[i] = i;
		}
		st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = stoi(st.nextToken());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int a = stoi(st.nextToken());
			int b = stoi(st.nextToken());
			union(a,b);
		}
		boolean visit[]=new boolean[N+1];
		int answer=0;
		for(int i=1; i<=N; i++) {
			int p = getParent(parent[i]);
			if(!visit[p]) {
				answer+=arr[p];
				visit[p]=true;
			}
		}
		if(answer <= K) {
			System.out.println(answer);
		}else {
			System.out.println("Oh no");
		}
	}

	static void union(int a, int b) {
		a = getParent(a);
		b = getParent(b);
		if (arr[a] <= arr[b]) {
			parent[b] = a;
		} else {
			parent[a] = b;
		}
	}

	static int getParent(int n) {
		if (parent[n] == n) {
			return n;
		}
		return parent[n]=getParent(parent[n]);
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}