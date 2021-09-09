import java.io.*;
import java.util.*;

public class boj_5671_호텔방번호 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String s = in.readLine();
			if(s==null) break;
			StringTokenizer st = new StringTokenizer(s);
			int N = stoi(st.nextToken());
			int M = stoi(st.nextToken());
			int cnt = 0;
			for (int i = N; i <= M; i++) {
				char c[] = String.valueOf(i).toCharArray();
				boolean vit[] = new boolean[10];
				boolean exit = false;
				for (int j = 0; j < c.length; j++) {
					if (vit[c[j]-'0']) {
						exit = true;
						break;
					}
					vit[c[j]-'0']=true;
				}
				if (!exit) {
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}
