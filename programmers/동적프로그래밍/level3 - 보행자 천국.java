class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        int dp[][][] = new int[2][m][n];
        int dir[][] = {{-1,0}, {0,-1}};//상, 좌
        dp[0][0][0] = 1;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(cityMap[i][j] == 1) continue;
                for(int k=0; k<2; k++){
                    int pr = i+dir[k][0];
                    int pc = j+dir[k][1];
                    if(pr<0 || pc<0 ) continue;
                    if(cityMap[pr][pc] == 2){
                        dp[k][i][j] += (dp[k][pr][pc]%MOD);
                    }else{
                        dp[k][i][j] += ((dp[0][pr][pc]+dp[1][pr][pc])%MOD);
                    }
                }
            }
        }
        answer = dp[0][m-1][n-1] + dp[1][m-1][n-1];                                                 
        return answer%MOD;
    }
}