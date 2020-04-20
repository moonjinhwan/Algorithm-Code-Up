#include<iostream>
#include<queue>
#include<cstring>
using namespace std;
int n, m;
int map[300][300];
int type[300][300];
bool visit[300][300];
int backUp[300][300];
int dx[4] = { 1,-1,0,0 };
int dy[4] = { 0,0,-1,1 };
void bfs(int y,int x) {
	queue<pair<int, int>> q;
	q.push({ y,x });
	visit[y][x] = true;
	while (!q.empty()) {
		int curx = q.front().second;
		int cury = q.front().first;
		q.pop();
		for (int i = 0; i < 4; i++) {
			int nx = curx + dx[i];
			int ny = cury + dy[i];
			if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
			if (map[ny][nx] != 0 ) {
				backUp[ny][nx]--;
				if (backUp[ny][nx] < 0) backUp[ny][nx] = 0;
			}
			else if (map[ny][nx] == 0 && !visit[ny][nx]) {
				visit[ny][nx] = true;
				q.push({ ny,nx });
			}
		}
	}
}
void bfs2(int y, int x,int cnt) {
	queue<pair<int, int>> q;
	q.push({ y,x });
	type[y][x] = cnt;
	while (!q.empty()) {
		int curx = q.front().second;
		int cury = q.front().first;
		q.pop();
		for (int i = 0; i < 4; i++) {
			int nx = curx + dx[i];
			int ny = cury + dy[i];
			if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
			if (map[ny][nx] != 0 && type[ny][nx] == 0) {
				type[ny][nx] = cnt;
				q.push({ ny,nx });
			}
		}
	}
}
int main() {

	cin >> n >> m;
	for (int i = 0; i < n; i++) 
		for (int j = 0; j < m; j++)
			cin >> map[i][j];
	bool tag = true;
	int time = 0;
	while (tag) {
		memcpy(backUp, map, sizeof(map));
		memset(visit, false, sizeof(visit));
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visit[i][j] && map[i][j] == 0) {
					bfs(i, j);
				}
			}
		}
		memcpy(map, backUp, sizeof(backUp));
		memset(type, 0, sizeof(type));
		//빙하가 나누어졌는지 확인
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != 0 && type[i][j]==0) {
					cnt++;
					bfs2(i, j, cnt);
					
				}
			}
		}
		if (cnt == 0) {
			cout << 0;
			return 0;
		}
		else if (cnt > 1) {
			tag = false;
			break;
		}
		time++;
	}
	cout << time+1;
}