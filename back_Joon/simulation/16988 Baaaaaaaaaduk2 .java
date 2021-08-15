import java.util.*;
import java.io.*;

public class Main {
	static int N, M, res = 0;
	static int[][] matrix;
	static int[][] D = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		matrix = new int[N][M];
		List<int[]> combList = new ArrayList<>();
		List<int[]> startList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				matrix[i][j] = stoi(st.nextToken());
				if (matrix[i][j] == 2)
					startList.add(new int[] { i, j });
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < 4; k++) {
					int r = D[k][0] + i;
					int c = D[k][1] + j;
					if (r < 0 || r >= N || c < 0 || c >= M)
						continue;
					if (matrix[i][j]==0 && matrix[r][c] == 2)
						combList.add(new int[] { i, j });
				}
			}
		}
		for (int i = 0; i < combList.size(); i++) {
			for (int j = i + 1; j < combList.size(); j++) {
				//조합으로 두점 선택
				int a[] = combList.get(i);
				int b[] = combList.get(j);
				matrix[a[0]][a[1]] = 1;
				matrix[b[0]][b[1]] = 1;
				int count = 0;
				boolean visit[][] = new boolean[N][M];
				//2의 시작점 선택
				for (int k = 0; k < startList.size(); k++) {
					int[] arr = startList.get(k);
					if(!visit[arr[0]][arr[1]]) {
						count += bfs(arr[0], arr[1], visit);
						res = Math.max(res, count);
					}
				}
				matrix[a[0]][a[1]] = 0;
				matrix[b[0]][b[1]] = 0;
			}
		}
		System.out.println(res);
	}

	static int bfs(int r, int c, boolean visit[][]) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c });
		visit[r][c] = true;
		boolean exit = false;
		int count = 0;
		while (!q.isEmpty()) {
			count++;
			int cur[] = q.poll();
			for (int k = 0; k < 4; k++) {
				int nr = cur[0] + D[k][0];
				int nc = cur[1] + D[k][1];
				if (nr < 0 || nr >= N || nc < 0 || nc >= M || visit[nr][nc] || matrix[nr][nc] == 1)
					continue;
				if (matrix[nr][nc] == 0) {
					exit = true;
					continue;
				}
				visit[nr][nc] = true;
				q.add(new int[] { nr, nc });
			}
		}
		if(exit)
			return 0;
		else
			return count;
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}
//문제분석
//조합, BFS

//코딩화
//2주변 탐색해서 List저장
//2개 선택
//2만 담은 List를 BFS시작점
//bfs에서 중복확인
//중간에 그만뒀는지 잘 갔는지 확인해서 갱
//startList, combList
//시작점에서 bfs->