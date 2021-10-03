import java.io.*;
import java.util.*;

public class BOj_1302_º£½ºÆ®¼¿·¯ {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = stoi(st.nextToken());
		Map<String ,Integer> m = new HashMap<>();
		int MAXVAL = 0;
		while(N-->0) {
			st = new StringTokenizer(br.readLine());
			String s= st.nextToken();
			m.put(s, m.getOrDefault(s, 0)+1);
			MAXVAL=Math.max(MAXVAL, m.get(s));
		}
		String firstStr = "";
		for(int i=0; i<50; i++) firstStr+='z';
		for(String key: m.keySet()) {
			if(m.get(key) == MAXVAL) {
				if(key.compareTo(firstStr)<0) {
					firstStr=key;
				}
			}
		}
		System.out.println(firstStr);
	}
	
	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}