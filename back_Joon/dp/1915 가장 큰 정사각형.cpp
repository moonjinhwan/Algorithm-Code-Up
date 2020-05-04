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
			scanf("%1d", &t);
			if (t == 1) {
				dp[i][j] = min({dp[i - 1][j], dp[i][j - 1] , dp[i - 1][j-1] })+1;
			}
			else {
				dp[i][j] = 0;
			}
		}
	}
	int maxEle = 0;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			if (maxEle < dp[i][j]) {
				maxEle = dp[i][j];
			}
		}
	}
	cout << maxEle * maxEle;
}
