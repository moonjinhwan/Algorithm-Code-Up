import java.util.*;

class LeetCode_1328 {
	public static void main(String[] args) {
		breakPalindrome("abccba");
	}
	 static public String breakPalindrome(String palindrome) {
		 char[] cs = palindrome.toCharArray();
		 int N = cs.length;
		 int mid = N/2;
		 boolean v=false;
		 for(int i=0; i<N; i++) {
			 if(N%2 == 1 && mid == i) continue;
			 if(cs[i]>'a') {
				 cs[i]= 'a';
				 v=true;
				 break;
			 }
		 }
		 if(!v) {
			 cs[N-1] = 'b';
		 }
         String ANS = "";
		 if(cs.length >1){
             ANS = new String(cs);
         }
		 return ANS;
	 }
}