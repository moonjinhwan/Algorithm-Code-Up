#include<iostream>
#include<vector>
#include<cstring>
#include<queue>
#include<algorithm>
using namespace std;

int n, m, st;
vector<int> v[1001];
bool use[1001];
void dfs(int st) {
	use[st] = true;
	cout << st<<' ';
	for (int i = 0; i < v[st].size(); i++)
	{
		int next = v[st][i];
		if (use[next] == false) {
			dfs(next);
		}
	}
}
void bfs(int st) {
	memset(use, false, sizeof(use));
	queue<int> q;
	use[st] = true;
	q.push(st);
	while (!q.empty())
	{
		int node = q.front();
		q.pop();
		cout << node<<' ';
		for (int i = 0; i < v[node].size(); i++)
		{
			int next = v[node][i];
			if (use[next] == false) {
				use[next] = true;
				q.push(next);
			}
		}
	}
}
int main() {
	cin >> n >> m >> st;
	for (int i = 0; i < m; i++)
	{
		int from, to;
		cin >> from>>to;
		v[from].push_back(to);
		v[to].push_back(from);
	}
	for (int i = 1; i <=n; i++)
	{
		sort(v[i].begin(), v[i].end());
	}
	dfs(st);
	cout << '\n';
	bfs(st);
}