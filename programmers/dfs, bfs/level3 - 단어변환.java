class Solution {
    static int N, INF= Integer.MAX_VALUE;
    static boolean visited[];
    static String[] Words;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        N = words.length;
        Words = words;
        visited = new boolean[words.length];
        answer = dfs(0, 0, begin, target);
        return answer==INF? 0 : answer;
    }
    static int dfs(int depth, int index, String word, String target){
        ${     }
        if(target.equals(word)){
            return depth;
        }
        if(depth == N){
            return answer;
        }
        for(int i=0; i<N; i++){
            if(!visited[i]){
                if(isValid(word, Words[i])){
                    visited[i] = true;
                    answer = Math.min(dfs(depth+1, i, Words[i], target), answer);
                    visited[i] = false;
                }
            }
        }
        return answer;
    }
    static boolean isValid(String s1, String s2){
        int cnt=0;
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i)==s2.charAt(i))
                cnt++;
        }
        return cnt==s1.length()-1 ? true: false;
    }
}