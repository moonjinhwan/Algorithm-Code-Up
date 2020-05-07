#include<iostream>
using namespace std;
char map[502][502];
int n, m;
int ans[5];
void init() {
	
	cin >> n >> m;
	for (int i = 0; i < n * 5 + 1; i++)
	{
		for (int j = 0; j < m * 5 + 1; j++)
		{
			cin >> map[i][j];
		}
	}
}
void go(int y, int x) {
	int cnt = 0;

	for (int i = y; i < y+4; i++)
	{
		for (int j = x; j < x + 4; j++)
		{
			if (map[i][j] == '*') {
				cnt++;
			}
		}
	}
	ans[cnt / 4]++;
}
int main() {
	init();
	for (int i = 0,l=0; i < n; i++,l+=5)
	{
		for (int j = 0, k = 0; j < m; j++, k += 5)
		{
			go(1+l, 1 + k);
		}
	}
	for (auto p : ans) {
		cout << p<<' ';
	}
}