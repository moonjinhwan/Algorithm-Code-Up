import java.io.*;
import java.util.*;

public class boj_17266_어두운굴다리 {
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = stoi(st.nextToken());
		st = new StringTokenizer(in.readLine());
		M = stoi(st.nextToken());
		int a[]=new int[M];
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<M; i++) {
			a[i] = stoi(st.nextToken());
		}
		int L=0, R=N, answer=0;
		while(L<=R) {
			int m = (L+R)/2;
			if(check(a, m)) {
				R=m-1;
				answer = m;
			}else
				L=m+1;
		}
		System.out.println(answer);
	}
	static boolean check(int a[], int m) {
		if(! (a[0]-m<=0 && a[M-1]+m>=N)) 
			return false;
		for(int i=0; i<M-1; i++) {
			int x = a[i]+m;
			int x2 = a[i+1]-m;
			if(x2-x>0) {
				return false;
			}
		}
		return true;
	}
	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}