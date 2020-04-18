#include<iostream>
#include<queue>
#include<cstring>
using namespace std;
int info[100][100];
bool visit[100][100];
int copy2[100][100];
int dy[4] = { 0,0,1,-1 };
int dx[4] = { 1,-1,0,0 };

int main() {
	int n, m;
	cin >> n >> m;
	int sum = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> info[i][j];
			if (info[i][j] == 1) sum++;
		}
	}
	int time = 0;
	int save = 0;

	while (sum != 0) {
		time++;
		save = sum;
		queue<pair<int, int>> q;
		memcpy(copy2, info, sizeof(info));
		memset(visit, false, sizeof(visit));
		q.push({ 0,0 });
		visit[0][0] = true;
		while (!q.empty()) {
			int cx = q.front().second;
			int cy = q.front().first;
			q.pop();
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
				if (info[ny][nx] == 1 && visit[ny][nx] == false) {
					copy2[ny][nx] = 0;
					visit[ny][nx] = true;
					sum--;
					continue;
				}
				else if(info[ny][nx]==0 && visit[ny][nx]==false){
					visit[ny][nx] = true;
					q.push({ ny,nx });
				}
			}
		}
		memcpy(info, copy2, sizeof(copy2));
	}
	cout << time << endl;
	cout << save;
}