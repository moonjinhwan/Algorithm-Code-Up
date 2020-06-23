#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
vector<bool> vis(100001, false);
int main() {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	int n;
	cin >> n;
	int cnt = 0;
	int res = 0;
	for (int i = 0; i < 2*n; i++)
	{
		int tmp;
		cin >> tmp;
		if (vis[tmp] == false) {
			cnt++;
			vis[tmp] = true;
		}
		else {
			vis[tmp] = false;
			cnt--;
		}
		res = max(cnt, res);
	}
	cout << res;
	
}