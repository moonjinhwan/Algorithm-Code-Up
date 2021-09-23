import java.io.*;
import java.util.*;

public class boj_17255_N으로만들기 {
	static char[] arr;
	static Set<String> set;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = st.nextToken().toCharArray();
		set = new HashSet<>();
		for(int i=0; i<arr.length; i++) {
			dfs(i,i, ""+arr[i], ""+arr[i]);
		}
		System.out.println(set.size());
	}
	static void dfs(int L, int R, String s, String path) {
		if(L==0 && R==arr.length-1) {
			set.add(path);
			return;
		}
		if(L-1>=0) {
			dfs(L-1, R, arr[L-1]+s, path+" "+arr[L-1]+s);
		}
		if(R+1<arr.length) {
			dfs(L, R+1, s+arr[R+1], path+" "+s+arr[R+1]);
		}
	}
	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}