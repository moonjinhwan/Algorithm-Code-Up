import java.io.*;
import java.util.*;

public class BOJ_1541_ÀÒ¾î¹ö¸°°ýÈ£ {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String s = st.nextToken();
		String arr[]=s.split("[+-]");
		char cmds[] = new char[arr.length-1];
		int idx=0;
		for(int i=0; i<s.length(); i++) {
			if(!Character.isDigit(s.charAt(i))) {
				cmds[idx++]=s.charAt(i);
			}
		}
		int sum = stoi(arr[0]);
		boolean flag = false;
		for(int i=0; i<cmds.length; i++) {
			if(cmds[i]=='-') {
				flag = true;
			}			
			if(flag) {
				sum-=stoi(arr[i+1]);
			}else {
				sum+=stoi(arr[i+1]);
			}
		}
		System.out.println(sum);
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}