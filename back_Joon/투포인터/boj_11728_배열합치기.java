import java.io.*;
import java.util.*;

public class boj_11728_배열합치기 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N=stoi(st.nextToken());
		int M=stoi(st.nextToken());
		st = new StringTokenizer(in.readLine());
		int arr1[]=new int[N];
		for(int i=0; i<N; i++) {
			arr1[i]=stoi(st.nextToken());
		}
		int arr2[]=new int[M];
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<M; i++) {
			arr2[i]=stoi(st.nextToken());
		}
		int len = N>M ? N : M;
		int p1=0;
		int p2=0;
		StringBuilder sb = new StringBuilder();
		while(p1<N && p2<M) {
			if(arr1[p1] < arr2[p2]) {
				sb.append(arr1[p1]).append(" ");
				p1++;
			}else {
				sb.append(arr2[p2]).append(" ");
				p2++;
			}
		}
		if(p1==N) {
			for(int i=p2; i<M; i++) {
				sb.append(arr2[i]).append(" ");
			}
		}else {
			for(int i=p1; i<N; i++) {
				sb.append(arr1[i]).append(" ");
			}
		}
		System.out.println(sb.toString());
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}
