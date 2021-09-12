#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
int dp[101][100001];

int main() {
	int N, K;//물품수, 제한 무게
	cin >> N >> K;
	vector<pair<int,int>> w;
	
	w.push_back({0,0});
	for (int i = 1; i <= N; i++) {
		int p, q;
		cin >> p >> q;
		w.push_back({ p,q });
	}
	sort(w.begin(), w.end());
	for (int i = 1; i <= N; i++) {//물품수
		for (int j = 1; j <= K; j++) {//무게
			dp[i][j] = dp[i-1][j];
			if(j-w[i].first>=0)
				dp[i][j] = max(dp[i][j], dp[i-1][j - w[i].first] + w[i].second);
		}
	}
	cout << dp[N][K];
}