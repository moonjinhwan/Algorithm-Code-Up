import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N  =stoi(st.nextToken());
		int arr[] = new int[N];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i]= stoi(st.nextToken());	
		}
		st = new StringTokenizer(in.readLine());
		int M = stoi(st.nextToken());
		Arrays.sort(arr);
		int left=0, right=987654321;
		boolean find=false;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]>M) {
				right=Math.min(right, arr[i]);
			}else if(arr[i]<M){
				left=Math.max(left, arr[i]);
			}else {
				find=true;
				break;
			}
		}
		int L = (M-left-1);
		int R = (right-M-1);
		int answer = L + R +(L*R);
		if(find)
			System.out.println(0);
		else
			System.out.println(answer);
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}