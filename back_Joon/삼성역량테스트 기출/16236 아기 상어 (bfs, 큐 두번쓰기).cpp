#include<iostream>
#include<queue>
#include<cstring>
using namespace std;
int n;
int map[20][20];
int sharkSize = 2;
int dist[20][20];
int dx[4] = { 0,-1,0,1 };
int dy[4] = { -1,0,1,0 };
queue<pair<int, int>> sharkSt;
int answer;
void goShark(int y, int x) {
	memset(dist, -1, sizeof(dist));
	queue<pair<int, int>> q;
	dist[y][x] =0;
	q.push({ y,x });
	while (!q.empty()) {
		int curx = q.front().second;
		int cury = q.front().first;
		q.pop();
		if (map[cury][curx]!=0 && map[cury][curx] < sharkSize) {
			sharkSt.push({ cury,curx });
			map[cury][curx] = 0;
			answer += dist[cury][curx];
			break;
		}
		for (int d = 0; d < 4; d++) {
			int nx = curx + dx[d];
			int ny = cury + dy[d];
			if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
			//방문 안 한곳, 크기가 같거나 작은곳 이동 가능
			if (dist[ny][nx] == -1 && sharkSize >= map[ny][nx]) {
				dist[ny][nx] = dist[cury][curx] + 1;
				q.push({ ny,nx });
			}
		}
	}
}
int main() {	
	cin >> n;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> map[i][j];
			if (map[i][j] == 9) {
				sharkSt.push({ i,j });
				map[i][j] = 0;
			}
		}
	}
	int candy = 0;
	while (!sharkSt.empty()) {
		int x = sharkSt.front().second;
		int y = sharkSt.front().first;
		sharkSt.pop();
		if (candy == sharkSize) {
			candy = 0;
			sharkSize++;
		}
		goShark(y,x);
		candy++;
	}
	cout << answer;
}