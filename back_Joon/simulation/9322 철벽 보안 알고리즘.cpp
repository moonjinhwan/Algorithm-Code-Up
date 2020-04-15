#include<iostream>
#include<vector>
using namespace std;
int main() {
	int t;
	cin >> t;
	for (int test = 1; test <= t; test++) {
		int N;
		cin >> N;
		string str[3][1000];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < N; j++) {
				cin >> str[i][j];
			}
		}
		vector<pair<int, int>> info;
		for (int fix = 0; fix < N; fix++) {
			for (int mv = 0; mv < N; mv++) {
				if (str[0][fix] == str[1][mv]) {
					info.push_back({fix,mv});
					break;
				}
			}
		}
		string answer[1000];
		for(auto p : info){
			answer[p.first] = str[2][p.second];
		}
		for (int i = 0; i < N;i++) {
			cout << answer[i] << ' ';
		}
		cout << '\n';
	}
}
/*
for test
	n
	for 3
		for n
			input
	for fix
		for mv
			if fix == mv
				v.push
	for auto p : v
		ans[p.fir] = pass[p.sec]
	for n
		cout ans[i]
*/