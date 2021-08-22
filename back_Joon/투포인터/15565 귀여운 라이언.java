import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(in.readLine());
		int N=stoi(st.nextToken());
		int K=stoi(st.nextToken());
		int arr[]= new int[N];
		st=new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=stoi(st.nextToken());
		}
		int INF = Integer.MAX_VALUE;
		int l=0,r=0,sum=0, len, ans=INF;
		boolean lflag=false, rflag=true;
		for(int i=0;i<N;i++) {
			if(arr[i]==1) {
				l=i;
				r=i;
				break;
			}
		}
		while(r<N && l<N) {
			if(rflag && arr[r]==1) {
				sum++;
				if(sum==K) {
					rflag=false;
					lflag=true;
					sum--;
					len=r-l+1;
					ans=Math.min(len, ans);
				}
			}
			else if(lflag && arr[l]==1) {
				lflag=false;
				rflag=true;
			}
			if(lflag) {
				l++;
			}else
				r++;
		}
		if(ans==INF)
			System.out.println(-1);
		else
			System.out.println(ans);
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}