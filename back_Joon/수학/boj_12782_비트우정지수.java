import java.io.*;
import java.util.*;

public class boj_12782_비트우정지수 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = stoi(st.nextToken());
		StringBuilder sb= new StringBuilder();
		while (N-- > 0) {
			st = new StringTokenizer(in.readLine());
			char a[] = st.nextToken().toCharArray();
			char b[] = st.nextToken().toCharArray();
			int totalCnt=0;
			int aCnt=0;
			int bCnt=0;
			for (int i = 0; i < a.length; i++) {
				if(a[i]!=b[i]) {
					totalCnt++;
				}
				if(a[i]=='1')
					aCnt++;
				if(b[i]=='1')
					bCnt++;
			}
			int diff=Math.abs(aCnt-bCnt);
			int ans=((totalCnt-diff)/2) + diff;
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}
