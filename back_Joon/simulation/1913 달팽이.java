import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = stoi(st.nextToken());
		st = new StringTokenizer(in.readLine());
		int M = stoi(st.nextToken());
		int val=1;
		int[][] map = new int[N][N];
		int currow=N/2, curcol=N/2;
		int rowstart=currow-1, rowend=currow+1, colstart=curcol-1, colend=curcol+1;
		map[currow][curcol] = val++;
		out:while(val<(N*N)) {
			//up
			for(int i=currow-1; i>=rowstart;i--) {
				if(i<0) break out;
				map[i][curcol] = val++;
			}
			currow=rowstart; rowstart--;			
			//right
			for(int j=curcol+1;j<=colend;j++) {
				map[currow][j] = val++;
			}
			curcol=colend; colend++;	
			//down
			for(int i=currow+1;i<=rowend;i++) {
				map[i][curcol]=val++;
			}
			currow = rowend; rowend++; 
			//left
			for(int j=curcol-1;j>=colstart;j--) {
				map[currow][j]=val++;
			}
			curcol=colstart; colstart--;
		}
		//Ãâ·Â-------------------------------------------------------------------------------
		StringBuilder sb= new StringBuilder();
		for(int i=0;i<N;i++) { 
			for(int j=0;j<N;j++) {
				sb.append(map[i][j]+" ");
			}
			sb.append("\n");
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==M)
					sb.append((i+1)+" "+(j+1));
			}
		}
		System.out.println(sb.toString());
	}
	
	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}