import java.io.*;
import java.util.*;

public class boj_21318_피아노체조 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = stoi(st.nextToken());

		int a[] = new int[N];
		int d[] = new int[N];
		d[0]=0;
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			a[i] = stoi(st.nextToken());
			if(i>0) {
				if(a[i-1] > a[i]) {
					d[i]=d[i-1]+1;
				}else {
					d[i]=d[i-1];
				}
			}
		}
		st = new StringTokenizer(in.readLine());
		int M = stoi(st.nextToken());
		StringBuilder sb= new StringBuilder();
		while (M-- > 0) {
			st = new StringTokenizer(in.readLine());
			int u = stoi(st.nextToken())-1;
			int v = stoi(st.nextToken())-1;
			sb.append(d[v]-d[u]).append("\n");
		}
		System.out.println(sb);
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}