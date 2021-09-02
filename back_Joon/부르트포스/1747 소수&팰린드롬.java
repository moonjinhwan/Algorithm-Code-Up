import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		boolean prime[] = new boolean[1004001];
		int len = 1004000;
		int N = stoi(st.nextToken());
		prime[1] = true;
		// 소수판단
		for (int i = 2; i < len; i++) {
			for (int j = i + i; j <= len; j += i) {
				prime[j] = true;
			}
		}
		List<Integer> ans = new ArrayList<>();
		for (int i = 2; i <= len; i++) {
			if (!prime[i]) {
				String s = String.valueOf(i);
				boolean exit = false;
				int m = s.length() / 2;
				int L, R;
				if (s.length() % 2 == 0) {
					L = m - 1;
					R = m;
				} else {
					L = m;
					R = m;
				}
				while (L >= 0) {
					if (s.charAt(L) != s.charAt(R)) {
						exit = true;
						break;
					}
					L -= 1;
					R += 1;
				}
				if(!exit)
					ans.add(i);
			}
		}
		for (int i = 0; i < ans.size(); i++) {
			if(ans.get(i) >= N) {
				System.out.println(ans.get(i));
				break;
			}
		}
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}