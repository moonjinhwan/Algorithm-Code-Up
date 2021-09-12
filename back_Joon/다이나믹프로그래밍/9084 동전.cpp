#include<iostream>
#include<cstring>
using namespace std;
int dp[10001];
int main() {
	int t;
	cin >> t;
	while (t--) {
		int n;
		cin >> n;
		int coin[21];
		memset(dp, 0, sizeof(dp));
		for (int i = 1; i <= n; i++) {
			cin >> coin[i];
		}
		int m;
		cin >> m;
		dp[0] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = coin[i]; j <= m; j++) {
				dp[j] += dp[j - coin[i]];
			}
		}
		cout << dp[m] << '\n';
	}
}
/*
for 코인수 
	for 금액
		dp[금액] += [금액-코인]
	 
*/