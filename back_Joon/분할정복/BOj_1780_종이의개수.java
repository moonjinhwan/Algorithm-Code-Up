import java.io.*;
import java.util.*;

public class BOj_1780_종이의개수 {
	static int N, grid[][], save[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		grid = new int[N][N];
		save = new int[3];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				grid[i][j] = stoi(st.nextToken());
			}
		}
		if(possible(N, 0, 0)) {
			int target = grid[0][0];
			save[target+1] ++;
		}else
			dfs(N, N/3, 0, 0);
		for(int k: save) {
			System.out.println(k);
		}
	}
	static void dfs(int large_len, int small_len, int r, int c) {
		
		for(int i=0; i<large_len; i+=small_len) {
			for(int j=0; j<large_len; j+=small_len) {
				if(possible(small_len, r+i, c+j)) {
					int target = grid[r+i][c+j];
					save[target+1]++;
				}else {
					dfs(small_len, small_len/3, r+i, c+j);
				}
			}
		}
	}
	static boolean possible(int len, int r, int c) {
		int target = grid[r][c];
		for(int i=0; i<len; i++) {
			for(int j=0; j<len; j++) {
				if(target != grid[i+r][j+c]) {
					return false;
				}
			}
		}
		return true;
	}
	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}