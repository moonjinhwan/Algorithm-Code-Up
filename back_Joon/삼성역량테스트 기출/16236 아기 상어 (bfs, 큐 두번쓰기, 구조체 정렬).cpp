#include<iostream>
#include<queue>
#include<cstring>
#include<algorithm>
using namespace std;
const int INF = 987654321;
int n;
int map[20][20];
int sharkSize = 2;
int dist[20][20];
int dx[4] = { 0,-1,0,1 };
int dy[4] = { -1,0,1,0 };
queue<pair<int, int>> sharkPos;
int answer;
int firstDist = INF;
struct FISH {
	int y, x, time;
};
vector<FISH> smallFish;
bool cmp(FISH a, FISH b) {
	if (a.time == b.time) {
		if (a.y == b.y) {
			return a.x < b.x;
		}
		return a.y < b.y;
	}
	return a.time < b.time;
}
void goShark(int y, int x) {
	memset(dist, -1, sizeof(dist));
	queue<pair<int, int>> q;
	q.push({ y,x });
	dist[y][x] = 0;
	while (!q.empty()) {
		int curx = q.front().second;
		int cury = q.front().first;
		q.pop();
		for (int d = 0; d < 4; d++) {
			int nx = curx + dx[d];
			int ny = cury + dy[d];
			if (nx < 0 || nx >= n || ny < 0 || ny >= n || dist[ny][nx] != -1)continue;
			if (map[ny][nx] <= sharkSize) {
				q.push({ ny,nx });
				dist[ny][nx] = dist[cury][curx] + 1;
				if (map[ny][nx] > 0 && map[ny][nx] < sharkSize) {
					smallFish.push_back({ ny,nx, dist[ny][nx] });
				}
			}
		}
	}
	firstDist = INF;
}
int main() {
	cin >> n;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> map[i][j];
			if (map[i][j] == 9) {
				sharkPos.push({ i,j });
				map[i][j] = 0;
			}
		}
	}
	int eatCount = 0;
	while (!sharkPos.empty()) {
		goShark(sharkPos.front().first, sharkPos.front().second);
		sharkPos.pop();
		if (smallFish.size() != 0) {
			sort(smallFish.begin(), smallFish.end(), cmp);
			sharkPos.push({ smallFish[0].y, smallFish[0].x });
			map[smallFish[0].y][smallFish[0].x] = 0;
			eatCount++;
			answer += smallFish[0].time;
			smallFish.clear();

		}
		if (eatCount == sharkSize) {
			eatCount = 0;
			sharkSize++;
		}
	}
	cout << answer;
}