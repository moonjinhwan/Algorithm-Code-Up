#include<iostream>
#include<string>
using namespace std;
int main() {
	int N, K;
	cin >> N >> K;
	long long res = 0;
	int len = 1;
	bool tag = false;
	int staBackUp = 1;
	//K 전까지 길이 구하기
	for (int sta = 1;sta<=N;sta*=10,len++) {
		int end = sta * 10 - 1;
		if (end > N) {
			end = N;
		}
		long long tmp = (long long)(end - sta + 1) * len;
		if (tmp+res >=K) {
			staBackUp = sta;
			tag = true;
			break;
		}
		else {
			res += tmp;
		}
	}
	//만약 K 보다 길이가 더 작은 경우
	if (!tag) {
		cout << -1;
		return 0;
	}
	int mok = (K - res)/len; //차이값
	int na = (K - res) %len;
	  // 사이에 몇개 숫자 있는지, 10부터 시작해서 -1 한다
	int tar = mok + staBackUp-1;
	if (na == 0) {
		string s = to_string(tar);
		cout << s.back();
	}
	else {
		string s = to_string(tar+1);
		cout << s[na - 1];
	}
}
/*
9까지 길이 구하기 -> 23에서 9 빼기 -> 차이값/길이 -> 7 ->
-> 10부터 시작하니 (7-1) + 10 -> 16에서 나머지0 6 나머지1 1
*/