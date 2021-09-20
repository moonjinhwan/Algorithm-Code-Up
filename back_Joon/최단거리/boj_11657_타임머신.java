import java.io.*;
import java.util.*;

public class boj_11657_Ÿ�Ӹӽ� {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N, M;
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		List<int[]> list[] = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken()) - 1;
			int b = Integer.valueOf(st.nextToken()) - 1;
			int c = Integer.valueOf(st.nextToken());
			list[a].add(new int[] { b, c });
		}
		int INF = 987654321;
		long s[] = new long[N];
		Arrays.fill(s, INF);
		s[0] = 0;
		boolean update = false;
		for (int i = 0; i <= N; i++) {// �ݺ���
			update = false;
			for (int j = 0; j < N; j++) {// ���� ���
				for (int next[] : list[j]) {// ���� ��忡 ����� ����
					if (s[j] != INF && s[next[0]] > s[j] + next[1]) {
						s[next[0]] = s[j] + next[1];
						update = true;
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		if (update) {
			sb.append(-1);
		} else {
			for (int i = 1; i < N; i++) {
				if (s[i] == INF)
					sb.append(-1 + "\n");
				else
					sb.append(s[i] + "\n");
			}
		}
		System.out.println(sb.toString());
	}
}
