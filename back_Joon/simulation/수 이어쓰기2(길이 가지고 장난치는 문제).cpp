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
	//K ������ ���� ���ϱ�
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
	//���� K ���� ���̰� �� ���� ���
	if (!tag) {
		cout << -1;
		return 0;
	}
	int mok = (K - res)/len; //���̰�
	int na = (K - res) %len;
	  // ���̿� � ���� �ִ���, 10���� �����ؼ� -1 �Ѵ�
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
9���� ���� ���ϱ� -> 23���� 9 ���� -> ���̰�/���� -> 7 ->
-> 10���� �����ϴ� (7-1) + 10 -> 16���� ������0 6 ������1 1
*/