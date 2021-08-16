import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N=stoi(st.nextToken());
		int M=stoi(st.nextToken());
		int K=stoi(st.nextToken());
		int indegree[] = new int[N+1];
		int build[] = new int[N+1];
		List<Integer> arr[] = new ArrayList[N+1];
		for(int i=0;i<=N;i++) {
			arr[i] = new ArrayList<>();
		}
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(in.readLine());
			int from=stoi(st.nextToken());
			int to=stoi(st.nextToken());
			indegree[to]++;
			arr[from].add(to);
		}
		boolean exit=false;
		out:for(int i=0;i<K;i++) {
			st=new StringTokenizer(in.readLine());
			int cmd=stoi(st.nextToken());
			int k=stoi(st.nextToken());
			if(cmd==1) {
				if(indegree[k]<=0) {
					build[k]++;
					for(int j=0;j<arr[k].size();j++) {
						int temp=arr[k].get(j);
						indegree[temp]--;
					}
				}else {
					exit=true;
					break;
				}
			}else {
				if(build[k]>0) {
					build[k]--;
					for(int j=0;j<arr[k].size();j++) {
						int temp=arr[k].get(j);
						indegree[temp]++;
					}
				}else {
					exit=true;
					break;
				}
			}
		}
		if(exit)
			System.out.println("Lier!");
		else
			System.out.println("king-God-Emperor");
	}
	
	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}
//문제분석
//진입차수 구함
//1이면 감소, 2이면 증가
//생성->차수 0->연결된차수감소->
//->차수0아님->리턴
//파괴->차수 0->