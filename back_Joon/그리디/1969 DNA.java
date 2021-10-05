import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = stoi(st.nextToken());
		int M = stoi(st.nextToken());
		char res[] = new char[M];
		int resultmax=0;
		char[][] map = new char[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			map[i] = st.nextToken().toCharArray();
		}
		for (int j = 0; j < M; j++) {
			int arr[] = new int[26];
			for (int i = 0; i < N; i++) {
				int index=map[i][j]-'A';
				arr[index]++;
			}
			int max = 0;
			for(int k=0; k<26; k++) {
				if(max < arr[k]) {
					max = arr[k];
					res[j] = (char)(k+'A'); 
				}
			}
			resultmax+=(N-max);
		}
		StringBuilder sb =new StringBuilder();
		sb.append(String.valueOf(res)+"\n");
		sb.append(resultmax);
		System.out.println(sb.toString());
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}
