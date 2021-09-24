import java.io.*;
import java.util.*;

public class boj_1967_트리의지름
{
	static int N, dp[];
	static List<int[]> list[];
	static boolean V[];
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		V=new boolean[N+1];
		dp=new int[N+1];
		list = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++)
		{
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < N-1; i++)
		{
			st = new StringTokenizer(br.readLine());
			int a = stoi(st.nextToken());
			int b = stoi(st.nextToken());
			int c = stoi(st.nextToken());
			list[a].add(new int[] { b, c });
			list[b].add(new int[] { a, c });
		}
		V[1]=true;
		dfs(1, 0);
		int m = Arrays.stream(dp).max().getAsInt();
		System.out.println(m);
	}
	static int dfs(int n, int w) {
		int maxone =0;
		int maxtwo =0;
		for(int next[]: list[n]) {
			if(!V[next[0]]) {
				V[next[0]]=true;
				int temp = dfs(next[0], next[1]);
				if(maxone < temp) {
					maxtwo = maxone;
					maxone = temp;
				}
				else if(maxone >= temp && maxtwo < temp) {
					maxtwo = temp;
				}
			}
		}
		dp[n] = maxone + maxtwo;
		return w+ maxone;
	}
	static int stoi(String s)
	{
		return Integer.valueOf(s);
	}
}