import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static char cmd[];
	static List<String> list;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = stoi(st.nextToken());
		list=new ArrayList<>();
		st = new StringTokenizer(in.readLine());
		cmd=new char[N];
		for(int i=0; i<N; i++) {
			cmd[i]=st.nextToken().charAt(0);
		}
		for(int i=0; i<10; i++) {
			dfs(0, new boolean[10], String.valueOf(i), i);
		}
		Collections.sort(list);
		System.out.println(list.get(list.size()-1));
		System.out.println(list.get(0));
	}
	static void dfs(int dep, boolean vit[], String sum, int pre) {
		vit[pre] = true;
		if(dep==N) {
			list.add(sum);
			return;
		}
		if(cmd[dep]=='>') {
			for(int i=0; i<pre; i++) {
				if(!vit[i]) {
					dfs(dep+1, vit, sum+String.valueOf(i), i);
					vit[i]=false;
				}
			}
		}else {
			for(int i=pre+1; i<10; i++) {
				if(!vit[i]) {
					dfs(dep+1, vit, sum+String.valueOf(i), i);
					vit[i]=false;
				}
			}
		}
	}
	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}