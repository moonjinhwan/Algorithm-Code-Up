import java.io.*;
import java.util.*;

public class BOJI_1244_스위치켜고끄기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = stoi(st.nextToken());
		int arr[] = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			arr[i] = stoi(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int M = stoi(st.nextToken());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int gen = stoi(st.nextToken());
			int n = stoi(st.nextToken());
			if(gen == 1) {
				int idx = n;
				while(idx <= N) {
					arr[idx] = (arr[idx]+1)%2;
					idx+=n;
				}
			}else {
				arr[n] = (arr[n]+1)%2;
				int left=n-1;
				int right=n+1;
				while(left>0 && right<=N) {
					if(arr[left] != arr[right]) break;
					else {
						arr[left] =(arr[left]+1)%2;
						arr[right] =(arr[right]+1)%2;
						left--; right++;
					}
				}
			}
		}
		for(int i=1; i<=N; i++) {
			if(i>20 && i%20==1) {
				System.out.println();
			}
			System.out.print(arr[i]+" ");
		}
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}