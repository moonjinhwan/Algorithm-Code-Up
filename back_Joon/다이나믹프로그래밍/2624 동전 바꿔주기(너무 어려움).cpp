#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
vector<pair<int, int>> coin;
int dp[10001][101] = { 0, };
int main() {
	int T,K;
	cin >> T >> K;
	coin.push_back({0,0});
	for (int i = 0; i < K; i++) {
		int a, b;
		cin >> a >> b;
		coin.push_back({ a,b });
	}
	sort(coin.begin(), coin.end());
	/*for (int i = 0; i < coin.size(); i++) {
		cout << coin[i].first<<' ';
	}*/
	dp[0][0] = 1;
	for (int i = 1; i <= K; i++) {//동전가지수
		for (int j = 0; j <= coin[i].second; j++) {
			for (int k = 0 ;k<=T; k++) {//지폐의 금액
				if (k + coin[i].first * j > T) break;
				dp[k + coin[i].first * j][i] += dp[k][i - 1];
			}
		}
	}
	cout << dp[T][K];
}
/*
*/