import java.util.*;
import java.io.*;

public class Main {
	static List<List<Integer>> res;
	static int N, K;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = stoi(st.nextToken());
		K = stoi(st.nextToken());
		res = new ArrayList<>();
		dfs(new ArrayList<>(), 0);
		if(res.size() < K) {
			System.out.println(-1);
		}else {
			List<Integer> list = res.get(K-1);
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<list.size()-1; i++) {
				sb.append(list.get(i)+"+");
			}
			sb.append(list.get(list.size()-1));
			System.out.println(sb.toString());
		}
	}
	static void dfs(List<Integer> list, int sum) {
		if(sum == N) {
			res.add(new ArrayList<>(list));
			return;
		}else if(sum > N) {
			return;
		}
		for(int i=1; i<=3; i++) {
			list.add(i);
			dfs(list, sum+i);
			list.remove(list.size()-1);
		}
	}
	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}