import java.io.*;
import java.util.*;

public class boij_9548_¹«Á¦ {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = stoi(st.nextToken());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			StringBuffer bf = new StringBuffer(s);
			while (true) {
				st = new StringTokenizer(br.readLine());
				String cmd = st.nextToken();
				if ("END".equals(cmd))
					break;
				if("I".equals(cmd)) {
					String X = st.nextToken();
					int Y = Integer.valueOf(st.nextToken());
					bf.insert(Y, X);
				}else {
					int X = stoi(st.nextToken());
					int Y = stoi(st.nextToken());
					System.out.println(bf.substring(X, Y+1));
				}
			}
		}
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}