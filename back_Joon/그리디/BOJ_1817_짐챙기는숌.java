import java.io.*;
import java.util.*;

public class BOJ_1817_ÁüÃ¬±â´Â¼ò {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N=stoi(st.nextToken());
		int M=stoi(st.nextToken());
		if(N>0)
			st = new StringTokenizer(br.readLine());
		int cnt=0;
		int sum=0;
		for(int i=0; i<N; i++) {
			int k = stoi(st.nextToken());
			if(sum+k==M) {
				cnt++;
				sum=0;
			}else if(sum+k>M) {
				cnt++;
				sum=k;
			}else {
				sum+=k;
			}
		}
		if(sum!=0) cnt++;
		System.out.println(cnt);
	}
	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}