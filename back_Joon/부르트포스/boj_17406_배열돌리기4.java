import java.io.*;
import java.util.*;

public class boj_17406_배열돌리기4 {
	static List<Integer> list[];
	static boolean visit[][], flag = false;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		String s = st.nextToken();
		st = new StringTokenizer(in.readLine());
		String t = st.nextToken();
		int n;
		if (s.length() <= t.length()) {
			n = number(t.length(), s.length());
		} else
			n = number(s.length(), t.length());
		n = s.length() * t.length() * n;
		String origin=s;
		while(s.length()<n) {
			s+=origin;
		}
		origin=t;
		while(t.length()<n) {
			t+=origin;
		}
		int answer=0;
		if(t.equals(s)) {
			answer=1;
		}else
			answer=0;
		System.out.println(answer);
	}

	static int number(int a, int b) {
		if (b == 0) {
			return a;
		}
		return number(b, a % b);
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}