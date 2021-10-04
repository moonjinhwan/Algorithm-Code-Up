import java.io.*;
import java.util.*;

public class BOJ_1758_알바생강호 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = stoi(st.nextToken());
		long sum =0;
		List<Integer> list = new ArrayList<>();
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int k = stoi(st.nextToken());
			list.add(k);
		}
		Collections.sort(list, (a, b)->{return b-a;});
		for(int i=1; i<=N; i++) {
			int temp = list.get(i-1) -(i-1);
			if(temp>0) {
				sum+=temp;
			}else {
				continue;
			}
		}
		System.out.println(sum);
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}