import java.io.*;
import java.util.*;

public class BOJ_10815_숫자카드 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = stoi(st.nextToken());
		st = new StringTokenizer(br.readLine());
		Set<Integer> set = new HashSet<>();
		for(int i=0; i<N; i++) {
			set.add(stoi(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		int M = stoi(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int k;
		StringBuilder sb= new StringBuilder();
		for(int i=0; i<M; i++) {
			k=stoi(st.nextToken());
			if(set.contains(k)) {
				sb.append(1).append(" ");
			}else
				sb.append(0).append(" ");
		}
		System.out.println(sb);
	}
	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}