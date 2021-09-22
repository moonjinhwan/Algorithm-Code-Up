import java.util.*;

public class leetcode_1239 {
	static int answer;
	public static void main(String[] args) {
		maxLength(new ArrayList<>(Arrays.asList(new String[]{"yy","bkhwmpbiisbldzknpm"})));
		System.out.println(answer);
	}

	static public int[] solution(int[] nums1, int[] nums2) {
		
		return null;
	}

	static public int maxLength(List<String> arr) {
		answer =0;
		for(int i=1; i<=arr.size(); i++) {
			comb(arr.size(), 0, new String[i], 0, arr);
		}
		return answer;
	}
	static void comb(int size, int depth, String[] s, int idx, List<String> arr) {
		if(idx == s.length) {
			int i=check(s);
			answer=Math.max(answer, i);
			return;
		}
		if(size == depth) {
			return;
		}
		s[idx] = arr.get(depth);
		comb(size, depth+1, s, idx+1, arr);
		comb(size, depth+1, s, idx, arr);
	}
	static int check(String[] s) {
		boolean v[] = new boolean[26];
		int total=0;
		for(String e: s) {
			total+=e.length();
			for(char c : e.toCharArray()) {
				int i = c-'a';
				if(v[i]) {
					return 0;
				}
				v[i]=true;
			}
		}
		return total;
	}
}