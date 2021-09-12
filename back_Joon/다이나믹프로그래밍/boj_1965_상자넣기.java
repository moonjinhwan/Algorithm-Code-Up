import java.io.*;
import java.util.*;

public class boj_1965_상자넣기 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = stoi(st.nextToken());
		int d[]=new int[N];
		int a[]=new int[N];
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++) {
			a[i]=stoi(st.nextToken());
		}
		for(int i=0; i<N; i++) {
			d[i]=1;
			for(int j=i-1; j>=0; j--) {
				if(a[i]>a[j] && d[i] <= d[j]) {
					d[i]=d[j]+1;
				}
			}
		}
		Arrays.sort(d);
		System.out.println(d[d.length-1]);
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}
