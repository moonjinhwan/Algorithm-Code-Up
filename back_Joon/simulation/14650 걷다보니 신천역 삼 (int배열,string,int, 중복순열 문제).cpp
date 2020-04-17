#include<iostream>
#include<string>
using namespace std;
int n;
int answer;
int s[9];
void go(int idx) {
	if (idx==n) {
		if (s[0] == 0) return;
		string tmp;
		for (int i = 0; i < n; i++) {
			tmp += s[i] + '0';
		}
		int res =stoi(tmp);
		if (res % 3 == 0)answer++;
		return;
	}
	for (int i = 0; i <=2; i++) {
		s[idx] = i;
		go(idx+1);
	}
}
int main() {
	cin >> n;
	go(0);
	cout << answer;
}