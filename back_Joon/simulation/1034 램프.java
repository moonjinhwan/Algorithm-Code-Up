import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K, arr[], max = 0;
	static String str[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		str = new String[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			str[i] = st.nextToken();
		}
		st = new StringTokenizer(in.readLine());
		K = Integer.valueOf(st.nextToken());
		int oddEven=K%2;
		if(K>50) {
			K=50;
		}
		int max =0;
		int idx=-1;
		for(int i=0; i<N; i++) {
			int zeroNum=0;
			String tmp = str[i];
			//0갯수 파악
			for(int j=0; j<M; j++) {
				if(tmp.charAt(j) == '0')
					zeroNum++;
			}
			//짝수 홀수  맞아야함
			if(zeroNum%2 != oddEven) {
				continue;
			}
			int patern =1;
			//같은 패턴이 몇개인지 파악
			for(int k=0; k<N; k++) {
				if(k!=i && tmp.equals(str[k])) {
					patern++;
				}
			}
			//0갯수가 K개 이하여야함
			if(zeroNum<=K && patern > max) {
				max = patern;
				idx = i;
			}
		}
		if(idx!=-1) {
			System.out.println(max);
		}else {
			System.out.println(0);
		}
	}
}
