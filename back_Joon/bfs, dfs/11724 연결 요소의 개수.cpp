#include<iostream>
#include<queue>
#include<vector>
using namespace std;
vector<int> v[1001];
bool vis[1001];
int n, m;
void bfs(int node) {
	queue<int> q;
	q.push(node);
	vis[node] = true;
	while (!q.empty())
	{
		int cur = q.front();
		q.pop();
		for (int i = 0; i < v[cur].size(); i++)
		{
			int next = v[cur][i];
			if (vis[next] == false) {
				vis[next] = true;
				q.push(next);
			}
		}
	}
}
int main() {
	cin >> n >> m;
	for (int i = 0; i < m; i++)
	{
		int from, to;
		cin >> from >> to;
		v[from].push_back(to);
		v[to].push_back(from);
	}
	int cnt = 0;
	for (int i = 1; i <= n; i++)
	{
		if (vis[i] == false) {
			cnt++;
			bfs(i);
		} 
	}
	cout << cnt;
}