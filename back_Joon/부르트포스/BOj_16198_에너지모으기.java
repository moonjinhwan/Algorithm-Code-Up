import java.io.*;
import java.util.*;

public class BOj_16198_에너지모으기 {
	static int N, MAX;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> list = new ArrayList<>();
		int N = stoi(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			list.add(stoi(st.nextToken()));
		}
		dfs(N, 0, 0, list);
		System.out.println(MAX);
	}
	static void dfs(int L, int level, int sum, List<Integer> list) {
		 if(level == L-2) {
			 MAX = Math.max(sum, MAX);
			 return;
		 }
		for(int i=1; i<list.size()-1; i++) {
			List<Integer> sub = new ArrayList<>(list);
			sub.remove(i);
			int k =0;
			k+=(list.get(i-1)*list.get(i+1));
			dfs(L, level+1, sum+k, sub);
		}
	}
	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}