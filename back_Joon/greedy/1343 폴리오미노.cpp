#include<iostream>
using namespace std;
string s,answer;
bool pass;
void init() {
	cin >> s;
}
void go() {
	int cnt = 0;
	for (int i = 0; i < s.size(); i++) {
		if (s[i] == 'X') {
			cnt++;
		}
		else if (s[i] == '.') {
			if (cnt != 0) {
				if (cnt % 4 == 0) {
					for (int j = 0; j < cnt / 4; j++) {
						answer+= "AAAA";
					}
				}
				else if (cnt % 4 == 2) {
					for (int j = 0; j < cnt / 4; j++) {
						answer += "AAAA";
					}
					answer += "BB";
				}
				else {
					cout << -1;
					pass = true;
					return;
				}
				answer += '.';
			}
			else if (cnt == 0) {
				answer += '.';
			}
			cnt = 0;
		}
	}
	if (cnt % 4 == 0) {
		for (int j = 0; j < cnt / 4; j++) {
			answer += "AAAA";
		}
	}
	else if (cnt % 4 == 2) {
		for (int j = 0; j < cnt / 4; j++) {
			answer += "AAAA";
		}
		answer += "BB";
	}
	else {
		cout << -1;
		pass = true;
		return;
	}
}
int main() {
	init();
	go();
	if (!pass) {
		cout << answer;
	}
}