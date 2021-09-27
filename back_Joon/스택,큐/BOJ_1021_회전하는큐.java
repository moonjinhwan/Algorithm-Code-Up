import java.io.*;
import java.util.*;

//나의 인생에는 수학과 함계
public class BOJ_1021_회전하는큐 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = stoi(st.nextToken());
		int K = stoi(st.nextToken());
		st = new StringTokenizer(br.readLine());
		Deque<Integer> q = new LinkedList<>();
		int arr[] = new int[K];
		for (int i = 0; i < K; i++) {
			int t = stoi(st.nextToken());
			arr[i] = t;
		}
		for (int i = 1; i <= N; i++) q.addLast(i);
		int index=0;
		int answer=0;
		while (K-->0) {
			int F=0;
			int B=0;
			for(int a: q) {
				if(a == arr[index]) {
					index++;
					break;
				}
				F++;
			}
			B = q.size() - F-1;
			if(F<=B) {
				answer += F;
				while(F-->0) {
					int p = q.pollFirst();
					q.addLast(p);
				}
			}
			else {
				answer += (B+1);
				B++;
				while(B-->0) {
					int p = q.pollLast();
					q.addFirst(p);
				}
				
			}
			q.pollFirst();
		}
		System.out.println(answer);
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}