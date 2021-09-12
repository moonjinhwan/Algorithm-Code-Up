#include<iostream>
#include<algorithm>
using namespace std;
int N;
int map[1000];
int dp[1000];
void init() {
	int N;
	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> map[i];
	}
}
int main() {
	init();
	int result = 1000;
	for (int i = 0; i < N; i++) {
		int d = map[i];
		for (int j = 1; j <= d; j++) {
			if (i + j != N - 1) {
				dp[i + j] = dp[i] + 1;
			}
			else {
				result = min(result, dp[i]+1);
			}
		}
	}
	cout << result;
}
/*
int result=100
dp[0]=map[0]
for i=0, i<N, i++
	d = map[i]
		for j=1, j<=d, j++
			if i+j != N-1
				dp[i+j] = dp[i] + 1
			else
				result = min(result, dp[i] + 1)			
*/