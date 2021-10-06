import java.io.*;
import java.util.*;

public class BOJ_1764_µË∫∏¿‚ {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = stoi(st.nextToken());
		int M = stoi(st.nextToken());
		Set<String> set= new HashSet<>();
		List<String> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			set.add(s);
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			if(set.contains(s)) {
				list.add(s);
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		StringBuilder sb = new StringBuilder();
		for(String s: list) {
			sb.append(s+"\n");
		}
		System.out.println(sb);
	}
	
	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}