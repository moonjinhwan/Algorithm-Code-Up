import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		// 더 높은 음이 나올 경우 손을 땐다.
		int N = Integer.valueOf(st.nextToken());
		int P = Integer.valueOf(st.nextToken());
		Stack<Integer> stack[] = new Stack[7];
		for (int i = 0; i < 7; i++) {
			stack[i] = new Stack<>();
		}
		int num = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int n = Integer.valueOf(st.nextToken());
			int p = Integer.valueOf(st.nextToken());
			if (stack[n].isEmpty() || stack[n].peek() < p) {
				stack[n].push(p);
				num++;
			} else if (stack[n].peek() > p) {
				while (!stack[n].isEmpty() && stack[n].peek() > p) {
					stack[n].pop();
					num++;
				}
				if (stack[n].isEmpty() || (!stack[n].isEmpty()&&stack[n].peek() != p)) {
					stack[n].push(p);
					num++;
				}
			}
		}
		System.out.println(num);
	}
}