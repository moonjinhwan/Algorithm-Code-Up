import java.io.*;
import java.util.*;

public class BOJ_20117_호반우상인의이상한품질계산법 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = stoi(st.nextToken());
		int arr[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			arr[i] = stoi(st.nextToken());
		Arrays.sort(arr);
		int L=0; 
		int R=N-1;
		int sum=0;
		while(L<=R) {
			if(L==R) {
				sum+= (arr[R]);
			}else
				sum+= (arr[R]*2);
			R--;
			L++;
		}
		System.out.println(sum);
	}
	
	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}