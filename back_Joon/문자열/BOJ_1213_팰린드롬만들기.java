import java.io.*;
import java.util.*;

public class BOJ_1213_팰린드롬만들기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		char carr[] = st.nextToken().toCharArray();
		int A[] = new int[26];
		int N = carr.length;
		for(char c: carr) {
			A[c-'A']++;
		}
		int odd=0;
		char oddChar='-';
		for(int i=0; i<26; i++) {
			if(A[i]%2!=0) {
				odd++;
				oddChar = (char)(i+'A');
			}
		}
		if(odd>1) {
			System.out.println("I'm Sorry Hansoo");
		}else {
			int front=0;
			int end=carr.length-1;
			for(int i=0; i<26; i++) {
				while(A[i]>1) {
					carr[front++]=(char)('A'+i);
					carr[end--] = (char)('A'+i);
					A[i]-=2;
				}
			}
			if(odd==1) {
				carr[N/2] = oddChar;
			}
			String s = new String(carr);
			System.out.println(s.toString());
		}
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}