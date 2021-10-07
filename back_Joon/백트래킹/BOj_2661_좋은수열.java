import java.io.*;
import java.util.*;

public class BOj_2661_좋은수열 {
	static String ANS;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = stoi(st.nextToken());
		String s = "1";
		dfs("1", N);
		System.out.println(ANS);
	}

	static boolean dfs(String str, int N) {
		if(str.length() == N) {
			ANS = str;
			return true;
		}
		for(int i=1; i<=3; i++) {
			String s = str + String.valueOf(i);
			int start=s.length()-1;
			int end=s.length();
			boolean pass=false;
			for(int j=1; j<=s.length()/2; j++) {
				String sub1 = s.substring(start, end);
				String sub2 = s.substring(start-j, start);
				if(sub1.equals(sub2)) {
					pass=true;
					break;
				}
				start-=1;
			}
			if(!pass) {
				if(dfs(s, N)) return true;
			}
		}
		return false;
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}