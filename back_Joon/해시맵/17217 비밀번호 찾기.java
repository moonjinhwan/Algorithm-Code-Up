import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());
		HashMap<String, String> map = new HashMap<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			String site = st.nextToken();
			String pw = st.nextToken();
			map.put(site, pw);
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			String tmp = st.nextToken();
			System.out.println(map.get(tmp));
		}
	}
}
