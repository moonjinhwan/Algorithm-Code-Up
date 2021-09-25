import java.io.*;
import java.util.*;

//나의 인생에는 수학과 함계
public class BOJ_17265_나의인생에는수학과함께 {
	static char[][] mat;
	static int D[][] = {{0,1},{1,0}}, N, MAXVAL=-Integer.MAX_VALUE, MINVAL=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		mat = new char[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				mat[i][j] = st.nextToken().charAt(0);
			}
		}
		dfs(0,0, mat[0][0]-'0', ' ');
		System.out.println(MAXVAL+" "+MINVAL);
	}

	static void dfs(int r, int c, int s, char cmd) {
		if(r == N-1 && c==N-1) {
			MAXVAL=Math.max(MAXVAL, s);
			MINVAL=Math.min(MINVAL, s);
			return;
		}
		
		for(int k=0; k<2; k++) {
			int nr = r+D[k][0];
			int nc = c+D[k][1];
			if(nc<0||nc>=N||nr<0||nr>=N) continue;
			if (Character.isDigit(mat[nr][nc])) {
				int CALC_RET=calc(s, mat[nr][nc]-'0', cmd);
				dfs(nr, nc, CALC_RET, cmd);
			} else {
				dfs(nr, nc, s, mat[nr][nc]);
			}
		}
	}

	static int calc(int s, int cur, char cmd) {
		int ss=0;
		switch (cmd) {
		case '+':
			ss = s+cur;
			break;
		case '-':
			ss = s-cur;
			break;
		case '*':
			ss = s*cur;
			break;
		}
		return ss;
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}