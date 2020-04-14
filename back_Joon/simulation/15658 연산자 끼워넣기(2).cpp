/*
초기값 설정에 주의
*/
#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
int n;
int maxEle = -987654321;
int minEle = 987654321;
void go(vector<int> info, int idx, int p, int mi, int mul, int d, int sum) {
	if (p < 0 || mi < 0 || mul < 0 || d < 0) {
		return;
	}
	if (idx == n) {
		maxEle = max(maxEle, sum);
		minEle = min(minEle, sum);
		return;
	}
	go(info, idx + 1, p - 1, mi, mul, d, sum + info[idx]);
	go(info, idx + 1, p, mi - 1, mul, d, sum - info[idx]);
	go(info, idx + 1, p, mi, mul - 1, d, sum * info[idx]);
	go(info, idx + 1, p, mi, mul, d - 1, sum / info[idx]);
}
int main() {

	cin >> n;
	vector<int> info;
	int a[4];
	for (int i = 0; i < n; i++) {
		int t;
		cin >> t;
		info.push_back(t);
	}
	for (int i = 0; i < 4; i++) {
		cin >> a[i];
	}
	go(info, 1, a[0], a[1], a[2], a[3], info[0]);
	cout << maxEle << '\n';
	cout << minEle;
}