#include<iostream>
#include<vector>
#include<cstring>
using namespace std;
int main() {
	int n;
	cin >> n;
	int list;
	cin >> list;
	vector<int> v[501];
	bool visit[501];
	memset(visit, false, sizeof(visit));
	for (int i = 0; i < list; i++) {
		int a,b;
		cin >> a >> b;
		v[a].push_back(b);
		v[b].push_back(a);
	}
	for (int i = 0; i < v[1].size(); i++) {
		int tmp = v[1][i];
		visit[tmp] = true;
		for (int j = 0; j < v[tmp].size(); j++) {
			int tmp2 = v[tmp][j];
			visit[tmp2] = true;
		}
	}
	int res = 0;
	for (int i = 2; i <= n; i++) {
		if (visit[i] == true) res++;
	}
	cout << res;
}