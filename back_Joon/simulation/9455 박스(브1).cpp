#include<iostream>
#include<vector>
using namespace std;
int n, m;
void input(vector<vector<int>> &v) {
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			cin >> v[i][j];
			//cout << v[i][j];
		}
		//cout << '\n';
	}
}
int main() {
	
	int test;
	cin >> test;
	while (test--)
	{
		vector<vector<int>> v(101,vector<int>(101,0));
		cin >> n >> m;
		input(v);
		int res = 0;
		for (int i = 0; i < m; i++)
		{
			int cnt = 0;
			for (int j = n-1, len=0; j >= 0; j--,len++)
			{
				if (v[j][i] == 1) {
					res += len - cnt;
					cnt++;
				}
			}
		}
		cout << res << '\n';
	}
}
/*
for °¡·Î
	cnt=0
	for size ~ 0
		if v[i]==1
			res += len-cnt
			cnt++;

*/