import java.util.*;

class LeetCode_1293_Shortest_Path_in_a_Grid_with_Obstacles_Elimination {
	public static void main(String[] args) {
		int grid[][] = {{0,0,0},
		               {1,1,0},
		               {0,0,0},
		               {0,1,1},
		               {0,0,0}};
		shortestPath(grid, 1);
	}

	static public int shortestPath(int[][] grid, int k) {
        int D[][]= {{-1,0},{0,1},{1,0},{0,-1}};
    	Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0,0,k, 0});
        int N = grid.length;
        int M = grid[0].length;
        boolean v[][][] = new boolean[k+1][N][M];
        v[k][0][0]=true;
        int DIST=-1;
        while(!q.isEmpty()) {
        	int cur[] = q.poll();
        	if(cur[0]==N-1 && cur[1]==M-1) {
        		DIST = cur[3];
        		break;
        	}
        	for(int i=0; i<4; i++) {
        		int nr = cur[0]+D[i][0];
        		int nc = cur[1]+D[i][1];
        		if(nr<0||nr>=N||nc<0||nc>=M) continue;
        		if(cur[2]>0 && !v[cur[2]-1][nr][nc] && grid[nr][nc] == 1) {
        			v[cur[2]-1][nr][nc] = true;
        			q.add(new int[] {nr, nc, cur[2]-1, cur[3]+1});
        		}
        		if(!v[cur[2]][nr][nc] && grid[nr][nc]==0){
        			v[cur[2]][nr][nc] = true;
        			q.add(new int[] {nr, nc, cur[2], cur[3]+1});
        		}
        	}
        }
    	return DIST;
    }
}