import java.util.*;
import java.io.*;

public class Main {
	static String E="Error!";
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		char[] arr = st.nextToken().toCharArray();
		boolean java=true;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == '_') {
				java=false;
			}
		}
		String ans;
		if(java) {
			ans=isJava(arr);
		}else {
			ans=isCplus(arr);
		}
		System.out.println(ans);
	}
	static String isJava(char arr[]) {
		StringBuilder sb = new StringBuilder();
		if(Character.isUpperCase(arr[0])) {
			return E;
		}else {
			for(int i=0; i<arr.length; i++) {
				if(Character.isUpperCase(arr[i])) {
					sb.append('_').append(Character.toLowerCase(arr[i]));
				}else
					sb.append(arr[i]);
			}
		}
		return sb.toString();
	}
	static String isCplus(char arr[]) {
		StringBuilder sb = new StringBuilder();
		if(arr[arr.length-1] == '_' || arr[0]=='_')
			return E;
		for(int i=0; i<arr.length; i++) {
			if(Character.isUpperCase(arr[i]))
				return E;
		}
		for(int i=0; i<arr.length; i++) {
			if(arr[i]=='_') {
				if(arr[i+1]=='_')
					return E;
				i++;
				sb.append(Character.toUpperCase(arr[i]));
			}else {
				sb.append(arr[i]);
			}
		}
		return sb.toString();
	}
	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}