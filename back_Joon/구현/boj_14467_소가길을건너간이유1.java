import java.io.*;
import java.util.*;

public class boj_14467_소가길을건너간이유1 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N=stoi(st.nextToken());
		int arr[]=new int[11];
		int answer=0;
		for(int i=0; i<arr.length; i++) {
			arr[i]= -1;
		}
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			int a =stoi(st.nextToken());
			int b= stoi(st.nextToken());
			if(arr[a]==-1) {
				arr[a]=b;
			}else if(arr[a]!=b) {
				answer++;
				arr[a]=b;
			}else {
				continue;
			}
		}
		System.out.println(answer);
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}