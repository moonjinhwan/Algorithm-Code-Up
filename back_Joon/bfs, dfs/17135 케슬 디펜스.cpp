#include<iostream>
#include<queue>
#include<cstring>
#include<vector>
#include<algorithm>
#include<tuple>
using namespace std;
int N, M, D;
int map[16][15];
int backUp[16][15];
int pos[3];
bool visit[16][15];
int dx[3] = { 0,-1,1 };
int dy[3] = { -1,0,0 };
int answer, result;
vector<tuple<int, int, int>> candidate[3];
void init() {
	cin >> N >> M >> D;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> map[i][j];
		}
	}
}
void killEnemy() {
	for (int num = 0; num < 3; num++) {
		if (!candidate[num].empty()) {
			sort(candidate[num].begin(), candidate[num].end());
			int d, x, y;
			tie(d, x, y) = candidate[num][0];
			if (map[y][x] != 0) {
				map[y][x] = 0;
				result++;
			}
			candidate[num].clear();
		}
	}
}
bool checkMap() {
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (map[i][j] == 1) {
				return true;
			}
		}
	}
	return false;
}
void moveDown() {
	for (int j=0;j<M;j++) {
		for (int i = N - 1; i >= 1; i--) {
			map[i][j] = map[i-1][j];
		}
	}
	for (int j = 0; j < M; j++) {
		map[0][j] = 0;
	}
}
void battle() {
	result = 0;
	while (1) {
		if (!checkMap()) {
			break;
		}
		int flag = false;
		for (int num = 0; num < 3; num++) {
			memset(visit, false, sizeof(visit));
			queue<pair<int, int>> q;
			q.push({ N, pos[num] });
			visit[N][pos[num]];
			while (!q.empty()) {
				int y = q.front().first;
				int x = q.front().second;
				q.pop();
				for (int i = 0; i < 3; i++) {
					int ny = y + dy[i];
					int nx = x + dx[i];
					if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
					if (map[ny][nx] == 0 && visit[ny][nx] == false) {
						q.push({ ny,nx });
						visit[ny][nx] = true;
					}
					else if (map[ny][nx] == 1 && visit[ny][nx] == false) {
						int dist = abs(N - ny) + abs(pos[num] - nx);
						if (dist <= D) {
							candidate[num].push_back({ dist,nx,ny });
							visit[ny][nx] = true;
							flag = true;
						}
					}
				}
			}
		}
		if (flag)
			killEnemy();
		moveDown();
	}
}
void setPosition(int idx, int pick) {
	if (pick == 3) {
		memcpy(backUp, map, sizeof(map));
		battle();
		answer = max(result, answer);
		memcpy(map, backUp, sizeof(backUp));
		return;
	}
	if (idx == M) return;
	pos[pick] = idx;
	setPosition(idx + 1, pick + 1);
	setPosition(idx + 1, pick);
}
int main() {
	init();
	setPosition(0, 0);
	cout << answer;
}