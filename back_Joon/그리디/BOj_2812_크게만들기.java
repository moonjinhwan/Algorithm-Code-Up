import java.io.*;
import java.util.*;

public class BOj_2812_크게만들기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = stoi(st.nextToken());
		int M = stoi(st.nextToken());
		st = new StringTokenizer(br.readLine());
		char c[] = st.nextToken().toCharArray();
		int delCnt = 0;
		Deque<Character> deque = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			while (!deque.isEmpty() && deque.peekLast() < c[i] && delCnt < M) {
				delCnt++;
				deque.removeLast();
			}
			deque.addLast(c[i]);
		}
		StringBuilder sb = new StringBuilder();
		while(!deque.isEmpty()) {
			sb.append(deque.removeFirst());
			if(sb.length() == N-M) break;
		}
		System.out.println(sb.toString());
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}