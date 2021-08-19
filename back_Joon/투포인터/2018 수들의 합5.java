import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = stoi(st.nextToken());
		int result = 0;
		int l = 0, r = 0;
		int sum = 0;
		while (l <= N && r <= N) {
			if (sum < N) {
				r++;
				sum += r;
			} else if (sum > N) {
				sum -= l;
				l++;
			} else {
				result++;
				r++;
				sum += r;
				sum -= l;
				l++;
			}
		}
		System.out.println(result);
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}