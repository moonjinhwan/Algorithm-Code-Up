#include<iostream>
bool vip[41];
int d[41];
using namespace std;
int main() {
	int n,m;
	cin >> n>>m;
	for (int i = 1; i <= m; i++) {
		int t;
		cin >> t;
		vip[t]=true;
	}
	d[0]=1, d[1] = 1, d[2] = 2;
	for (int i = 3; i <= n; i++) {
		d[i] = d[i - 1] + d[i - 2];
	}
	int ans=1;
	int idx=0;
	for (int i = 1; i <= n; i++) {
		if (vip[i]) {
			ans *= d[i - idx - 1];
			idx = i;
		}
	}
	ans *= d[n - idx];
	cout << ans;
}