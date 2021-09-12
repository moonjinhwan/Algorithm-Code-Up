#include<iostream>
#include<algorithm>
using namespace std;
int dp[1001][1001];
int main() {
	int n, m;
	cin >> n >> m;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			int t;
			cin >> t;
			int maxEle = max({dp[i-1][j-1], dp[i-1][j], dp[i][j-1]});
			dp[i][j] = maxEle + t;
		}
	}
	cout << dp[n][m];
}