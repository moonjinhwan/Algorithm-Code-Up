import java.io.*;
import java.util.*;

public class boj_5347_LCM {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = stoi(st.nextToken());
		while (N-- > 0) {
			st = new StringTokenizer(in.readLine());
			int a = stoi(st.nextToken());
			int b = stoi(st.nextToken());
			int s;
			if (a > b) {
				s = rec(a, b);
			} else
				s = rec(b, a);
			System.out.println((a/s) * (b/s) * s);
		}
	}

	static int rec(int a, int b) {
		if (b == 0) {
			return a;
		}
		return rec(b, a % b);
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}