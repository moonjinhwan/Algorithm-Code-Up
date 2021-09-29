import java.io.*;
import java.util.*;

public class BOJ_1120_¹®ÀÚ¿­ {
	static int answer = 987654321;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		char c[]  = st.nextToken().toCharArray();
		char c2[] = st.nextToken().toCharArray();
		for(int i=0; i<c2.length; i++) {
			if(i+c.length>c2.length) break;
			int cnt=0;
			for(int j=0; j<c.length; j++) {
				if(c[j] != c2[j+i]) cnt++;
			}
			answer=Math.min(cnt, answer);
		}
		System.out.println(answer);
	}
	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}