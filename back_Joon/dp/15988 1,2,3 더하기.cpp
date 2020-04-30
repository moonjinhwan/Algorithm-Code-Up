#include<iostream>
#include<vector>
using namespace std;
int map[1000000];
const int d = 1000000009;

int main() {
	int TEST;
	cin >> TEST;
	for (int t = 0; t < TEST; t++) {
		int n;
		cin >> n;
		vector<long long> dp(1000001, 0);
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for (int i = 4; i <= n; i++) {
				dp[i] += dp[i - 3];
				dp[i] += dp[i - 2];
				dp[i] += dp[i - 1];
				dp[i] %= d;

		}
		cout << dp[n]<<'\n';
	}
}