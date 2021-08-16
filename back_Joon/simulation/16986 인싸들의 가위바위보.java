import java.util.*;
import java.io.*;

public class Main {
	static int N,M,result=0;
	static int[][] map;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N=stoi(st.nextToken());
		M=stoi(st.nextToken());
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=stoi(st.nextToken());
			}
		}
		arr=new int[3][20];
		for(int i=1;i<=2;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<20;j++) {
				arr[i][j]=stoi(st.nextToken())-1;
			}
		}
		permu(0, new boolean[N]);
		System.out.println(result);
	}
	static void permu(int index, boolean visit[]) {
		if(index==N) {
			//solve
			solve(0, 1, new int[3], new int[3]);
			return;
		}
		for(int i=0;i<N;i++) {
			if(!visit[i]) {
				arr[0][index]=i;
				visit[i]= true;
				permu(index+1, visit);
				visit[i]=false;
			}
		}
	}
	static void solve(int p1, int p2, int wins[], int idx[]) {
		if(wins[0]==M || wins[1]==M || wins[2]==M) {
			if(wins[0]==M)
				result=1;
			return;
		}
		int pattern1=arr[p1][idx[p1]];
		int pattern2=arr[p2][idx[p2]];
		int res = map[pattern1][pattern2];
		idx[p1]++; idx[p2]++;
		if(res==0) {
			wins[p2]++;
			solve(p2, 3-(p1+p2), wins, idx);
			wins[p2]--;
		}else if(res == 1) {
			int temp = p1 < p2 ? p2: p1;
			wins[temp]++;
			solve(temp, 3-(p1+p2), wins, idx);
			wins[temp]--;
		}else {
			wins[p1]++;
			solve(p1, 3-(p1+p2), wins, idx);
			wins[p1]--;
		}
		idx[p1]--; idx[p2]--;
	}
	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}
//문제분석
//무승부->뒷사람이이김
// 이전승자 vs 경기안함사람
//지우가 모든 손동작을 다르게냄
//1 비간다, 2 이긴다, 0 진다
//경희
//민호
//순서는 지우,경희, 민호
//지우, 경희
//순열->승부판단->