import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = stoi(st.nextToken());
		int maxval = 0;
		List<Integer> ans = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			int origin = N;
			int next = i;
			int cnt = 2;
			List<Integer> list = new ArrayList<>();
			list.add(N);
			list.add(i);
			while (true) {
				int tmp = origin - next;
				if(tmp < 0) break;
				origin = next;
				next = tmp;
				cnt++;
				list.add(tmp);
			}
			if (maxval < cnt) {
				ans = list;
				maxval = cnt;
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(maxval).append("\n");
		for (int i = 0; i < ans.size(); i++)
			sb.append(ans.get(i) + " ");
		System.out.println(sb);
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}