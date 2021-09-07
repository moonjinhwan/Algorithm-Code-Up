import java.util.*;
import java.io.*;

public class boj_14405_ÇÇÄ«Ãò {
	static String E="Error!";
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		char c[] = st.nextToken().toCharArray();
		boolean exit=false;
		for(int i=0; i<c.length; i++) {
			if(c[i]=='p') {
				if(i+1<c.length && c[i+1]=='i') {
					i++;
					continue;
				}else {
					exit=true;
					break;
				}
			}else if(c[i]=='k') {
				if(i+1<c.length && c[i+1]=='a') {
					i++;
					continue;
				}else {
					exit=true;
					break;
				}
			}else if(c[i]=='c') {
				if(i+2<c.length && c[i+1]=='h' && c[i+2]=='u') {
					i+=2;
					continue;
				}else {
					exit=true;
					break;
				}
			}else {
				exit=true;
				break;
			}
		}
		if(exit) {
			System.out.println("NO");
		}else
			System.out.println("YES");
	}
	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}