import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N, M;
		N=stoi(st.nextToken());
		M=stoi(st.nextToken());
		Map<String, Integer> keys = new HashMap<>();
		Map<Integer, String> keyi = new HashMap<>();
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(in.readLine());
			String k= st.nextToken();
			keys.put(k, i);
			keyi.put(i, k);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			String temp = st.nextToken();
			if(Character.isLetter(temp.charAt(0))) {
				sb.append(keys.get(temp)).append("\n");
			}else
				sb.append(keyi.get(stoi(temp))).append("\n");
		}
		System.out.println(sb.toString());
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}