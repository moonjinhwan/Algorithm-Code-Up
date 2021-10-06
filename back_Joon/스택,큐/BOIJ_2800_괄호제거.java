import java.io.*;
import java.util.*;

public class BOIJ_2800_°ýÈ£Á¦°Å {
	static int idx[], N;
	static char cArr[];
	static List<String> list;
	static Set<String> set;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		cArr = st.nextToken().toCharArray();
		N = cArr.length;
		set = new HashSet<>();
		idx = new int[N];
		int cnt=1;
		list =new ArrayList<>();
		for(int i=0; i<N; i++) {
			if(cArr[i] == '(') {
				idx[i] = cnt++;
			}else if(cArr[i]==')') {
				idx[i] = --cnt;
			}
		}
		dfs(0, new Stack<>(), new String());
		for(String s: set) list.add(s);
		Collections.sort(list);
		for(String s: list) {
			if(N == s.length()) continue;
			System.out.println(s);
		}
	}
	static void dfs(int level, Stack<Integer> stack, String str) {
		if(level == N) {
			set.add(str);
			return;
		}
		if(cArr[level] == '(') {
			stack.add(idx[level]);
			dfs(level+1, stack, str+'(');
			stack.pop();
			dfs(level+1, stack, str);
		}else if(cArr[level] == ')') {
			if(!stack.isEmpty() && stack.peek() == idx[level]) {
				stack.pop();
				dfs(level+1, stack, str+')');
				stack.add(idx[level]);
			}else {
				dfs(level+1, stack, str);
			}
		}else {
			dfs(level+1, stack, str+cArr[level]);
		}
	}
	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}