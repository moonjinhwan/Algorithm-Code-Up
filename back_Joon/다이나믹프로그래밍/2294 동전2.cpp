#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
const int INF = 987654321;
vector<int> dp(10001,INF);
int main() {
	int n, k;
	cin >> n >> k;
	int coin[100];
	for (int i = 0; i < n; i++) {
		cin >> coin[i];
	}
	dp[0] = 0;
	for (int i = 0; i < n; i++) {
		for (int j = coin[i]; j <= k; j++) {
			if (j - coin[i] >= 0)
				dp[j] = min(dp[j - coin[i]] + 1, dp[j]);
		}
	}
	if (dp[k] == INF) {
		cout << -1;
	}
	else {
		cout << dp[k];
	}
}
/*
	1 2 3 4 5 6 7 8
1	1 2 3 4 5 6 7 8
2	  1 2 2

동전수 = mins(동전수 [금액-코인]+1 , 동전수)
*/