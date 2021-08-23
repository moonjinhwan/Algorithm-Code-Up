import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		String s = st.nextToken();
		long N = Long.valueOf(s);
		long l = 0, r = Long.MAX_VALUE, q = Long.MAX_VALUE;

		while (l <= r) {
			long mid = (l + r) / 2;
			long z = (long) Math.pow(mid, 2);
			if (z >= N) {
				q = Math.min(q, mid);
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		System.out.println(q);
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}