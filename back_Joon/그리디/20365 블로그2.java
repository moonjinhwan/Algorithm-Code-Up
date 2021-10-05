import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = stoi(st.nextToken());
		st = new StringTokenizer(in.readLine());
		String s = st.nextToken();
		int rcnt=0, bcnt=0;
		char arr[] = s.toCharArray();
		for(int i=0; i<arr.length; i++) {
			char c = arr[i];
			if(i==0) {
				if(c=='B') bcnt++;
				else rcnt++;
			}
			else {
				if(arr[i-1]==c) continue;
				else {
					if(c=='B') bcnt++;
					else rcnt++;
				}
			}
		}
		int ans = 0;
		if(rcnt>=bcnt)
			ans = bcnt+1;
		else
			ans = rcnt+1;
		System.out.println(ans);
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}