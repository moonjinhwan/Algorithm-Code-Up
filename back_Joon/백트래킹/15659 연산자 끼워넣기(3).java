import java.util.*;
import java.io.*;

public class Main {
	static int N, arr[], cmdcount[];
	static int maxAns, minAns;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = stoi(st.nextToken());
		maxAns=-Integer.MAX_VALUE;
		minAns=Integer.MAX_VALUE;
		arr=new int[N];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i]=stoi(st.nextToken());
		}
		cmdcount=new int[4];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < cmdcount.length; i++) {
			cmdcount[i]=stoi(st.nextToken());
		}
		combine(0, new int[N-1], cmdcount[0],cmdcount[1],cmdcount[2],cmdcount[3]);
		System.out.println(maxAns);
		System.out.println(minAns);
	}
	static void combine(int dep, int cmdArr[], int plusCount, int minusCount, int multiCount, int divCount) {
		if(dep==N-1) {
			calc(cmdArr);
			return;
		}
		//´õÇÏ±â
		if(plusCount>0) {
			cmdArr[dep]=0;
			combine(dep+1,cmdArr,plusCount-1,minusCount,multiCount,divCount);
		}
		if(minusCount>0) {
			cmdArr[dep]=1;
			combine(dep+1, cmdArr,plusCount,minusCount-1,multiCount,divCount);
		}
		if(multiCount>0) {
			cmdArr[dep]=2;
			combine(dep+1, cmdArr,plusCount,minusCount,multiCount-1,divCount);
		}
		if(divCount>0) {
			cmdArr[dep]=3;
			combine(dep+1, cmdArr,plusCount,minusCount,multiCount,divCount-1);
		}
	}
	static void calc(int cmdArr[]) {
		List<Integer> cmdList=new ArrayList<>();
		List<Integer> numList=new ArrayList<>();
		numList.add(arr[0]);
		for (int i = 0; i < cmdArr.length; i++) {
			switch(cmdArr[i]) {
			case 0:
			case 1:
				numList.add(arr[i+1]);
				cmdList.add(cmdArr[i]);
				break;
			case 2:
				numList.add(numList.remove(numList.size()-1) * arr[i+1]);
				break;
			case 3:
				numList.add(numList.remove(numList.size()-1) / arr[i+1]);
				break;
			}
		}
		int ret=numList.get(0);
		if(!cmdList.isEmpty()) {
			for (int i = 0; i < cmdList.size(); i++) {
				int cmd=cmdList.get(i);
				if(cmd==0) {
					ret+=numList.get(i+1);
				}else {
					ret-=numList.get(i+1);
				}
			}
		}
		maxAns=Math.max(maxAns, ret);
		minAns=Math.min(minAns, ret);
	}
	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}