#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
bool cmp(int a, int b) { return a > b; }

int check(vector<int>& a, vector<int>& b) {
	int len = min(a.size(), b.size());
	sort(a.begin(), a.end(), cmp);
	sort(b.begin(), b.end(), cmp);
	for (int i = 0; i < len; i++)
	{
		if (a[i] > b[i]) {
			return 1;
		}
		else if (a[i] < b[i]) {
			return 2;
		}
	}
	if (a.size() == b.size()) return 0;
	return a.size() > b.size() ? 1 : 2;
}
int main() {
	int n; cin >> n;

	while (n--) {
		vector<int> a(101);
		vector<int> b(101);
		int p; cin >> p;
		for (int i = 0; i < p; i++)
		{
			cin >> a[i];
		}
		int q; cin >> q;
		for (int i = 0; i < q; i++)
		{
			cin >> b[i];
		}
		if (check(a, b) == 1) {
			cout << 'A'<<'\n';
		}
		else if (check(a, b) == 2) cout << 'B' << '\n';
		else
			cout << 'D' << '\n';
	}
}
/*
check
	 len = 더 작은 사이즈
	 for 
		if a[i] > b[i]
			return true
		else <
			return false
	return a.size < b.size ? false:true
while
	a,b
	for a
		cin
	for b
		cin
	sort내림차순
	if check
		cout<<A
	else
		cout<<B
*/