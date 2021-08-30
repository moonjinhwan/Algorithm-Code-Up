import java.util.*;
import java.io.*;

public class Main {
	static boolean visit[];
	static char[] arr;
	static int ans=0;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = stoi(st.nextToken());
		String s= in.readLine();
		arr=s.toCharArray();		
		visit=new boolean[N];
		for(int i=0;i<N;i++) {
			if(!visit[i]) {
				bfs(i);
			}
		}
		System.out.println(ans);
	}
	static void bfs(int st) {
		Queue<Integer> q = new LinkedList<>();
		visit[st]=true;
		q.add(st);
		while(!q.isEmpty()) {
			int cur=q.poll();
			int next;
			if(arr[cur]=='E') {
				next=cur+1;
				if(!visit[next]) {
					visit[next]=true;
					q.add(next);
				}
			}else {
				next=cur-1;
				if(visit[next]) {
					if(arr[next]=='E') {
						ans++;
						return;
					}
				}else {
					visit[next]=true;
					q.add(next);
				}
			}
		}
	}
	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}