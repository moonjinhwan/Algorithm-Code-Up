#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
int d[1500002];
vector<pair<int, long long>> v;
int main() {
	int n;
	cin >> n;
	v.push_back({ 0,0 });
	for (int i = 1; i <= n; i++) {
		int a, b;
		cin >> a >> b;
		v.push_back({ a,b });
	}
	v.push_back({ 0,0 });
	int maxx = 0;
	for (int i = 1; i <= n+1; i++) {
		int day = v[i].first;
		int pay = v[i].second;
		maxx = max(maxx, d[i]);
		if (i + day <= n+1) {
			d[i + day] = max(maxx + pay, d[i+day]);
		}
	}
	cout << maxx;
}