import java.io.*;
import java.util.*;

public class boj_21314_¹Î°â¼ö {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		char c[] = st.nextToken().toCharArray();
		
		System.out.println(getMax(c));
		System.out.println(getMin(c));
	}
	static String getMin(char []c) {
		int cnt=0;
		StringBuilder minval = new StringBuilder();
		for(int i=0; i<c.length; i++) {
			if(c[i]=='K') {
				if(cnt!=0) {
					minval.append(1);
					for(int j=0; j<cnt-1; j++) {
						minval.append(0);
					}
				}
				minval.append(5);
				cnt=0;
			}else {
				cnt++;
			}
		}
		if(cnt!=0) {
			minval.append(1);
			for(int i=0; i<cnt-1; i++) {
				minval.append(0);
			}
		}
		return minval.toString();
	}
	
	static String getMax(char[] c) {
		int cnt=0;
		StringBuilder maxval = new StringBuilder();
		for(int i=0; i<c.length; i++) {
			if(c[i]=='K') {
				maxval.append(5);
				for(int j=0; j<cnt; j++) {
					maxval.append(0);
				}
				cnt=0;
			}else {//MÀÏ¶§
				cnt++;
			}
		}
		if(cnt!=0) {
			for(int i=0; i<cnt; i++) {
				maxval.append(1);
			}
		}
		return maxval.toString();
	}
	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}
