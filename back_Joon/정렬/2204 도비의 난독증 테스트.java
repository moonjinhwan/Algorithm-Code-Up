import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(in.readLine());
			int N = stoi(st.nextToken());
			if(N==0) break;
			List<String> list = new ArrayList<>();
			Map<String, String> map = new HashMap<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				String str = st.nextToken();
				map.put(str.toLowerCase(), str);
				list.add(str.toLowerCase());
			}
			Collections.sort(list);
			System.out.println(map.get(list.get(0)));
		}
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}