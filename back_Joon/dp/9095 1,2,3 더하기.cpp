#include<iostream>
#include<cstring>
using namespace std;
int main() {
	int TEST;
	cin >> TEST;
	while (TEST--) {
		int N;
		cin >> N;
		int dp[11] = { 0 };
		dp[1] = 1, dp[2] = 2, dp[3] = 4;
		for (int i = 4; i <= N; i++) {
			if (i - 1 > 0)
				dp[i] += dp[i - 1];
			if (i - 2 > 0)
				dp[i] += dp[i - 2];
			if (i - 3 > 0)
				dp[i] += dp[i - 3];
		}
		cout << dp[N] << endl;
	}
}
/*
dp[1]=1 dp[2]=2 dp[3]=4
for
	if i-1>0
		sum+=dp[i-1]
	if i-2>0
		sum+=dp[i-2]
	if i-3>0
		sum+=dp[i-3]
	dp[i]=sum
//*/