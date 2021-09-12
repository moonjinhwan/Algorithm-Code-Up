#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
int N;
int map[1000];

void init() {
	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> map[i];
	}
}
void go() {
	int result = 1000;
	vector<int> dp(1001, 1000);
	dp[0] = 0;
	for (int i = 0; i < N; i++) {
		int d = map[i];
		if (d == 0) continue;
		for (int j = 1; j <= d; j++) {
			if (i + j >= N) break;
			dp[i + j] = min(dp[i] + 1, dp[i + j]);
		}
	}
	if (dp[N - 1] == 1000) {
		cout << -1;
	}
	else {
		cout << dp[N - 1];
	}

}
int main() {
	init();
	go();
}