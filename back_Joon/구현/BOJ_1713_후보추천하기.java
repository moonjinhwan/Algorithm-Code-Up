import java.io.*;
import java.util.*;

public class BOJ_1713_�ĺ���õ�ϱ� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = stoi(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int K = stoi(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int T[] = new int[101];//�ð�
		int C[] = new int[101];//ī��Ʈ
		int frameNum=0;
		for(int t=0; t<K; t++) {
			int I = stoi(st.nextToken());
			if(C[I] == 0) {
				frameNum++;
				T[I] = t;
			}						
			if(frameNum>N) {
				frameNum--;
				int MIN=987654321;
				int index=0;
				for(int i=1; i<101; i++) {
					if(C[i]==0) continue;
					if(C[i] < MIN) {
						MIN = C[i];
						index = i;
					}else if(MIN == C[i] && T[i] < T[index]) {
						index = i;
					}
				}
				C[index] = 0;
				T[index] = 0;
			}
			C[I]++; 
		}
		for(int i=1; i<101; i++) {
			if(C[i]>0)
				System.out.print(i+" ");
		}
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}