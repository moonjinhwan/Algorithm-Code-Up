/*
for �ð�
	for ������
		if 1�� ����
			1�� ��ġ = ���ڸ�+1, ������+1�� �� ū ��
			2�� ��ġ = ���ڸ�, ������
		if 2�� ����
			1�� ��ġ = ���ڸ�, ������
			2�� ��ġ = ���ڸ�+1, ������+1 �� �� ū ��
*/
#include<iostream>
#include<algorithm>
using namespace std;
int list[1001];
int dp[3][1001][32];
int main() {
	int t, w;
	cin >> t >> w;
	for (int i = 1; i <= t; i++) {
		cin >> list[i];
	}
	if (list[1] == 1) {
		dp[1][1][0] = 1;
	}
	else if(list[1]==2){
		dp[2][1][1] = 1;
	}
	for (int i = 2; i <= t; i++) {
		for (int j = 0; j <= w; j++) {
			if (list[i] == 1) {
				dp[1][i][j] = max(dp[1][i - 1][j] + 1, dp[2][i - 1][j - 1] + 1);
				dp[2][i][j] = max(dp[1][i-1][j-1], dp[2][i-1][j]);
			}
			else if (list[i] == 2) {
				dp[1][i][j] = max(dp[1][i - 1][j], dp[2][i - 1][j - 1]);
				dp[2][i][j] = max(dp[1][i - 1][j - 1]+1, dp[2][i - 1][j]+1);
			}
		}
	}
	int result = 0;
	int answer = 0;
	for (int i = 0; i <= w; i++) {
		result = max(dp[1][t][i], dp[2][t][i]);
		answer = max(answer, result);
	}
	cout << answer;

}