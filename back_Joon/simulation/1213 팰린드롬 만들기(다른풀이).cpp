#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
int al[26];
string res;
int main() {
	string s;
	cin >> s;
	int odd = 0;
	int even = 0;
	int middle = -1;
	for (int i = 0; i < s.size(); i++) {
		al[s[i] - 'A']++;
	}
	for (int i = 0; i < 26; i++) {
		if (al[i] % 2 == 0) even++;
		else {
			middle = i;
			odd++;
		}
	}
	if (odd >= 2) {
		cout << "I'm Sorry Hansoo";
		return 0;
	}
	for (int i = 0; i < 26; i++) {
		for (int j = 0; j < al[i] / 2; j++) {
			res.push_back('A' + i);
			printf("%c", 'A' + i);
		}
	}
	//�Ųٷ� ���
	if (middle != -1) printf("%c", 'A' + middle);
	for (int i = res.size() - 1; i >= 0; i--) {
		cout << res[i];
	}
}
/*
������ �迭�ϱ�
Ȧ������ ¦���� �̸� �ȵȴ�
���� �����ͷ� �˾Ƴ���
*/