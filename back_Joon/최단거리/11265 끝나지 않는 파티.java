import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = stoi(st.nextToken());
		int M = stoi(st.nextToken());
		int map[][] = new int[N][N];
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < map.length; j++) {
				map[i][j]=stoi(st.nextToken());
			}
		}
		for(int mid=0; mid<N; mid++) {
			for(int start=0; start<N; start++) {
				for(int end=0; end<N; end++) {
					if(map[start][mid] + map[mid][end] < map[start][end]) {
						map[start][end] = map[start][mid] + map[mid][end];
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int a=stoi(st.nextToken())-1;
			int b=stoi(st.nextToken())-1;
			int c=stoi(st.nextToken());
			if(c >= map[a][b]) {
				sb.append("Enjoy other party\n");
			}else {
				sb.append("Stay here\n");
			}
		}
		System.out.println(sb.toString());
	}
	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}