#include<iostream>
using namespace std;
int dp[1025][1025];
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	int n, m;
	cin >> n >> m;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			cin >> dp[i][j];
			dp[i][j] += dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1];
		}
	}
	while (m--) {
		int x, y, x2, y2;
		cin >> y >> x >> y2 >> x2;
		int sum = dp[y2][x2] - dp[y2][x - 1] - dp[y - 1][x2] + dp[y - 1][x - 1];
		cout << sum << '\n';
	}
}