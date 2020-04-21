#include<iostream>
#include<cstring>
#include<algorithm>
using namespace std;
int n, m, h;
int map[30][10];
const int INF = 987654321;
int answer = INF;
bool isCheck() {
	for (int j = 0; j < n; j++) {
		int candy = j;
		for (int i = 0; i < h; i++) {
			if (map[i][candy] == 1) {
				candy++;
			}
			else if (map[i][candy] == -1) {
				candy--;
			}
		}
		if (candy != j) {
			return false;
		}
	}
	return true;
}
void simulation(int idx, int y,int x) {
	if (isCheck()) {
		answer = min(idx, answer);
		return;
	}
	if (idx == 3 || answer < idx) {
		return;
	}
	int backUp[30][10];
	memcpy(backUp, map, sizeof(map));
	for (int i = y; i < h; i++) {
		for (int j = 0; j < n - 1; j++) {
			if (map[i][j] == 0 && map[i][j + 1] == 0) {
				map[i][j] = 1;
				map[i][j+1] = -1;
				simulation(idx + 1, i,j);
				memcpy(map, backUp, sizeof(backUp));
			}
		}
	}
}
int main() {
	cin >> n >> m >> h;
	for (int i = 0; i < m; i++) {
		int a, b;
		cin >> a >> b;
		a--; b--;
		map[a][b] = 1; map[a][b + 1] = -1;
	}
	simulation(0, 0,0);
	if (answer == INF) {
		cout << -1;
	}
	else {
		cout << answer;
	}
}