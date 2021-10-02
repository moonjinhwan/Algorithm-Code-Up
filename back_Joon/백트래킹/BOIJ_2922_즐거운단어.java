import java.io.*;
import java.util.*;

public class BOIJ_2922_Áñ°Å¿î´Ü¾î {
	static char alp[];
	static List<Integer> indexs;
	static long ANSWER = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		alp = st.nextToken().toCharArray();
		indexs = new ArrayList<>();
		for (int i = 0; i < alp.length; i++) {
			if (alp[i] == 'A' || alp[i] == 'E' || alp[i] == 'I' || alp[i] == 'O' || alp[i] == 'U') {
				alp[i] = 'A';
			} else if (alp[i] == 'L') {
				continue;
			} else if (alp[i] == '_') {
				indexs.add(i);
			}else {
				alp[i] = 'Z';
			}
		}

		dfs(0, 1);
		System.out.println(ANSWER);
	}

	static void dfs(int i, long CNT) {
		if (indexs.size() == i) {
			if (isAble()) {
				ANSWER = ANSWER + (long)CNT;
			}
			return;
		}
		int level = indexs.get(i);
		if (alp[level] == '_') {
			alp[level] = 'A';
			dfs(i + 1, CNT * 5);
			alp[level] = 'Z';
			dfs(i + 1, CNT * 20);
			alp[level] = 'L';
			dfs(i + 1, CNT);
			alp[level] = '_';
		}
	}

	static boolean isAble() {
		boolean containsL = false;
		boolean RET = true;
		for (int i = 0; i < alp.length; i++) {
			if (alp[i] == 'L') {
				containsL = true;
				break;
			}
		}
		for (int i = 1; i < alp.length - 1; i++) {
			if (alp[i - 1] == 'A' && alp[i] == 'A' && alp[i + 1] == 'A') {
				RET = false;
				break;
			} else if (alp[i - 1] != 'A' && alp[i] != 'A' && alp[i + 1] != 'A') {
				RET = false;
				break;
			}
		}
		if (RET && containsL) {
			return true;
		} else
			return false;
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}