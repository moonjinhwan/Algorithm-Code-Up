#include<iostream>
#include<cstring>
using namespace std;
int dp[5000];
int main() {
	int N;
	cin >> N;
	memset(dp, -1, sizeof(dp));
	dp[3] = 1,dp[5]=1;
	for (int i = 4; i <= N; i++) {
		if (i - 5 > 0 && dp[i - 5] > 0) {
			dp[i] = dp[i - 5] + 1;
		}
		else if (i - 3 > 0 && dp[i - 3] > 0) {
			dp[i] = dp[i - 3] + 1;
		}
	}
	cout << dp[N];
}