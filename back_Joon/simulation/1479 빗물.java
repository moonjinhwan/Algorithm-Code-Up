import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int H,W;
	static int arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		H = Integer.valueOf(st.nextToken());
		W = Integer.valueOf(st.nextToken());
		st = new StringTokenizer(in.readLine());
		arr = new int[W];
		for(int i=0; i<W; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
		}
		int sum=0;
		for(int i=1; i<W-1; i++) {
			int left=0;
			int right=0;
			for(int j=i-1; j>=0; j--) {
				if(left < arr[j]) {
					left = arr[j];
				}
			}
			for(int j=i+1; j<W; j++) {
				if(right < arr[j]) {
					right = arr[j];
				}
			}
			if(left > arr[i] && right > arr[i]) {
				int max=Math.min(left, right);
				sum += max - arr[i];
			}
		}
		System.out.println(sum);
	}
}