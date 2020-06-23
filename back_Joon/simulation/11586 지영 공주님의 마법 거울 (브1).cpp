#include<iostream>
#include<vector>
using namespace std;
void solve(int n, vector<string> v, int cmd) {
	if (cmd == 3) {
		for (int i = n-1; i >= 0; i--)
		{
			for (int j = 0; j < n; j++)
			{
				cout << v[i][j];
			}
			cout << '\n';
		}
	}
	else if (cmd == 2) {
		for (int i = 0; i < n; i++)
		{
			for (int j = n-1; j >= 0; j--)
			{
				cout << v[i][j];
			}
			cout << '\n';
		}
	}
	else {
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				cout << v[i][j];
			}
			cout << '\n';
		}
	}
}
int main() {
	int n;
	cin >> n;
	vector<string> v(n);
	for (int i = 0; i < n; i++)
	{
		cin >> v[i];
	}
	int cmd;
	cin >> cmd;
	solve(n,v,cmd);
}
/*
for	n
	ют╥б
if cmd ==3
	for n~0
		for 0~size
else if cmd==2
	for 0~n
		for size-0
else
	for
		for
*/