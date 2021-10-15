import java.io.*;
import java.util.*;

public class BOIJ_16401_과자나눠주기{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = stoi(st.nextToken());
		int M = stoi(st.nextToken());
		int[] arr= new int[M];
		 st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			arr[i] = stoi(st.nextToken());
		}
		int left=1;
		int right=1000000000;
		while(left <= right) {
			int mid = (left+right)/2;
			int sum=0;
			for(int i=0; i<M; i++) {
				sum += (arr[i]/mid);
			}
			if(sum >= N) {
				left = mid+1;
			}else {
				right = mid-1;
			}
		}
		System.out.println(right);
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}