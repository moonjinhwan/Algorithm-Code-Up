import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		String s = st.nextToken();
		Set<String> set = new HashSet<>(Arrays.asList("c=", "c-", "d-", "lj", "nj", "s=", "z="));
		int pos=0;
		int cnt=0;
		while(pos<s.length()) {
			if(pos+2 <= s.length()) {
				String tmp=s.substring(pos, pos+2);
				if(set.contains(tmp)) {
					pos+=2;
					cnt++;
					continue;
				}
			}
			if(pos+3<=s.length()) {
				String tmp=s.substring(pos, pos+3);
				if(tmp.equals("dz=")) {
					pos+=3;
					cnt++;
					continue;
				}
			}
			pos++;
			cnt++;
		}
		System.out.println(cnt);
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}