import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static int T, N, map[][], perIdx, min;
	static Person per[];
	static int stair[][];

	static class Person implements Comparable<Person> {
		int r, c, d, t;

		public Person(int r, int c) {
			// TODO Auto-generated constructor stub
			this.r = r;
			this.c = c;
		}

		@Override
		public int compareTo(Person o) {
			// TODO Auto-generated method stub
			return this.d - o.d;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		T = Integer.valueOf(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			N = Integer.valueOf(st.nextToken());
			per = new Person[N * N];
			int idx = 0;
			perIdx = 0;
			stair = new int[2][3];// 세로, 가로, 길이
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.valueOf(st.nextToken());
					if (map[i][j] == 1) {
						per[perIdx++] = new Person(i, j);
					}
					if (map[i][j] >= 2) {
						stair[idx][0] = i;
						stair[idx][1] = j;
						stair[idx++][2] = map[i][j];
					}
				}
			}
			min = Integer.MAX_VALUE;
			powerset(0);
			System.out.println("#" + tc + " " + min);
		}
	}

	static void powerset(int idx) {
		if (idx == perIdx) {
			int max = 0;
			for (int i = 0; i < 2; i++) {
				PriorityQueue<Person> pq = new PriorityQueue<>();
				int time[] = new int[100];
				for (int j = 0; j < perIdx; j++) {
					if (per[j].t == i) {
						pq.add(per[j]);
					}
				}
				int end = 0;
				while (!pq.isEmpty()) {
					Person cur = pq.poll();
					int start = cur.d;
					end = start + stair[cur.t][2];
					for (int j = start; j < end; j++) {
						if (time[j] == 3) {
							end++;
							continue;
						}
						time[j]++;
					}
					if (max < end) {
						max = end;
					}
				}
			}
			if (min > max) {
				min = max;
			}
			return;
		}
		// 계단 선택하고, 길이 구하기
		per[idx].d = Math.abs(per[idx].r - stair[0][0]) + Math.abs(per[idx].c - stair[0][1])+1;
		per[idx].t = 0;
		powerset(idx + 1);
		per[idx].d = Math.abs(per[idx].r - stair[1][0]) + Math.abs(per[idx].c - stair[1][1])+1;
		per[idx].t = 1;
		powerset(idx + 1);
	}
}
