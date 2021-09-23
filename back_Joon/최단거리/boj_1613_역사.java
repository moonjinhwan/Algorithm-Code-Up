import java.io.*;
import java.util.*;

//https://www.acmicpc.net/problem/1613
//백준 1613번 역사

public class boj_1613_역사 {
	static int INF = 160000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = stoi(st.nextToken());
		int K = stoi(st.nextToken());
		int m[][] = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(m[i], INF);
		}
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = stoi(st.nextToken()) - 1;
			int b = stoi(st.nextToken()) - 1;
			m[a][b] = 1;
		}
		for (int mid = 0; mid < N; mid++) {
			for (int from = 0; from < N; from++) {
				for (int to = 0; to < N; to++) {
					if (from == to)
						continue;
					if (m[from][mid] + m[mid][to] < m[from][to]) {
						m[from][to] = m[from][mid] + m[mid][to];
					}
				}
			}
		}
		st = new StringTokenizer(br.readLine());
		int S=stoi(st.nextToken());
		while (S-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = stoi(st.nextToken()) - 1;
			int b = stoi(st.nextToken()) - 1;
			if(m[a][b]!=m[b][a]) {
				if(m[a][b]!=INF) {
					System.out.println(-1);
				}else
					System.out.println(1);
			}else {
				System.out.println(0);
			}
		}
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}