import java.io.*;
import java.util.*;

public class BOJ_9536_여우는어떻게울지 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = stoi(st.nextToken());
		String end = "what does the fox say?";
		for(int t=0; t<T; t++) {
			Set<String> set = new HashSet<>();
			List<String> list = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				list.add(st.nextToken());
			}
			while(true) {
				String ss = br.readLine();
				if(ss.equals(end)) break;
				String arr[] = ss.split(" ");
				set.add(arr[2]);
			}
			StringBuilder sb = new StringBuilder();
			for(String k: list) {
				if(!set.contains(k)) {
					sb.append(k+" ");
				}
			}
			System.out.println(sb.toString());
		}
	}
	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}