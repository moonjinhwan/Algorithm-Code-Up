import java.io.*;
import java.util.*;

public class BOJ_17352_여러분의다리가되어드리겠습니다 {
	static int p[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = stoi(st.nextToken());
		p = new int[N+1];
		for(int i=1; i<=N; i++) p[i] = i;
		for(int i=0; i<N-2; i++) {
			st = new StringTokenizer(br.readLine());
			int a = stoi(st.nextToken());
			int b = stoi(st.nextToken());
			union(a, b);
		}
		//System.out.println(Arrays.toString(p));
		StringBuilder sb = new StringBuilder();
		sb.append(1);
		for(int i=1; i<=N; i++) {
			p[i]=find(i);
			if(p[i]!=1) {
				sb.append(" ").append(i);
				break;
			}
		}
		//System.out.println(Arrays.toString(p));
		System.out.println(sb.toString());
	}
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a>=b) {
			p[a]=b;
		}else {
			p[b]=a;
		}
	}
	static int find(int a) {
		if(a == p[a]) {
			return a;
		}
		return p[a] = find(p[a]);
	}
	
	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}