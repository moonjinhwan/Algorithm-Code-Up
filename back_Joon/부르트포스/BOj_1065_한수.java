import java.io.*;
import java.util.*;

//백준 1065 한수
public class BOj_1065_한수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = stoi(st.nextToken());
		int cnt = 0;
		if(N<100) {
			cnt = N;
		}else {
			cnt=99;
			for(int i=101; i<=N; i++) {
				if(i==1000) continue;
				int arr[] = new int[3];
				int M=i;
				for(int j=0; j<3; j++) {
					arr[j]=M%10;
					M/=10;
				}
				if(arr[0]-arr[1] == arr[1]-arr[2]) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}