#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
int check(vector<string>& v) {
	int max = 1;
	for (int i = 0; i < v.size(); i++)
	{
		int cnt = 1;
		for (int j = 1; j < v.size(); j++)
		{
			if (v[i][j] == v[i][j - 1]) {
				cnt++;
			}
			else
				cnt = 1;
			if (max < cnt) max = cnt;
		}
		cnt = 1;
		for (int j = 1; j < v.size(); j++)
		{
			if (v[j][i] == v[j - 1][i]) {
				cnt++;
			}
			else
				cnt = 1;
			if (max < cnt) max = cnt;
		}
	}
	return max;
}
int main() {
	int n; cin >> n;
	vector<string> v(n);
	int max = 1;
	for (int i = 0; i < n; i++) {
		cin >> v[i];
	}
	for (int i = 0; i < n; i++) {//°¡·Î
		for (int j = 1; j < n; j++) {
			swap(v[i][j], v[i][j - 1]);
			int tmp = check(v);
			if (max < tmp) max = tmp;
			swap(v[i][j], v[i][j - 1]);
		}
		for (int j = 1; j < n; j++) {
			swap(v[j][i], v[j - 1][i]);
			int tmp = check(v);
			if (max < tmp) max = tmp;
			swap(v[j][i], v[j - 1][i]);
		}
	}
	cout << max;
}