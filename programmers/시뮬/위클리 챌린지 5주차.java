import java.util.*;

public class Solution {
	public static void main(String[] args) {
		solution("I");
	}
	static char[] cArr= {'A','E','I','O','U'};
    static List<String> ans;
	static public int solution(String word) {
        int answer = 0;
        ans=new ArrayList<>();
        for(int i=1; i<=5; i++)
            dfs(0,new String(), i);
        Collections.sort(ans);
        int index=1;
        for(String tmp: ans){
            if(word.equals(tmp)){
                answer=index;
                break;
            }
            index++;
        }
        return answer;
    }
    static void dfs(int dep, String s, int len){
        if(len == dep){
            ans.add(s);
            return;
        }
        for(int i=0; i<len; i++){
            dfs(dep+1, s+cArr[i], len);            
        }
    }
}