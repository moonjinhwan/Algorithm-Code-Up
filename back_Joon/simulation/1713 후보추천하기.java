import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int N, K;

	static class Pair implements Comparable<Pair> {
		int val, up, day;

		public Pair(int val, int up, int day) {
			this.val = val;
			this.up = up;
			this.day = day;
		}

		@Override
		public int compareTo(Pair o) {
			if (this.up == o.up) {
				return this.day - o.day;
			}
			return this.up - o.up;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.valueOf(st.nextToken());
		st = new StringTokenizer(in.readLine());
		K = Integer.valueOf(st.nextToken());
		st = new StringTokenizer(in.readLine());
		ArrayList<Pair> list = new ArrayList<>();
		for (int i = 0; i < K; i++) {
			int num = Integer.valueOf(st.nextToken());
			boolean flag = false;
			for (Pair pair : list) {// 같은게 있는지 파악
				if (pair.val == num) {
					flag = true;
					pair.up++;
					break;
				}
			}
			if (!flag) {
				if (list.size() == N) {
					list.remove(0);
					list.add(new Pair(num, 1, i));
				}else {// 아직 프레임이 꽉 안참
					list.add(new Pair(num, 1, i));
				}
			} 
			Collections.sort(list);
		}
		Collections.sort(list, new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				return o1.val - o2.val;
			}
		});
		for (Pair p : list) {
			System.out.print(p.val + " ");
		}
	}
}