#include<iostream>
using namespace std;
int main() {
	int n, m, k;
	cin >> n >> m >> k;
	int dp[15][15] = { 0, };
	int y;
	int x;
	if (k > 0) {
		y = (k - 1) / m;
		x = (k - 1) % m;
	}
	else {
		y = 0;
		x = 0;
	}
	dp[0][0] = 1;
	int first = 0, second = 0;
	for (int i = 0; i <= y; i++) {
		for (int j = 0; j <= x; j++) {
			if (i == 0 && j == 0) continue;
			if (i - 1 >= 0)
				dp[i][j] += dp[i - 1][j];
			if (j - 1 >= 0)
				dp[i][j] += dp[i][j - 1];
		}
	}
	first = dp[y][x];
	for (int i = y; i < n; i++) {
		for (int j = x; j < m; j++) {
			if (i == y && j == x) {
				dp[y][x] = 1;
				continue;
			}
			if (i - 1 >= 0)
				dp[i][j] += dp[i - 1][j];
			if (j - 1 >= 0)
				dp[i][j] += dp[i][j - 1];
		}
	}
	second = dp[n - 1][m - 1];
	cout << second * first;
}