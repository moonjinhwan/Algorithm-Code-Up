/*

while(t--)
	backUp=map
	for
		for
			if map != -1,0
				for 4dir
					if map ny,nx !=-1, map bound
						backUp ny,nx += map/5
						cnt++
					backUp cy,cx -= map/5*cnt
	map = backUp
	clean

clean
	//¹Ý½Ã°è
	for i>=0
		map i,0 =map i-1,0
	for j<m
		map 0,j = map 0,j+1
	for i>y
*/
#include<iostream>
#include<vector>
#include<cstring>
using namespace std;
int n, m, t;
int map[50][50];
vector<int> mc;
int dx[4] = { 1,-1,0,0 };
int dy[4] = { 0,0, -1, 1 };
void isPlus() {
	int backUp[50][50];
	memcpy(backUp, map, sizeof(map));
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (map[i][j] != -1 && map[i][j] != 0) {
				int cnt = 0;
				for (int d = 0; d < 4; d++) {
					int ny = i + dy[d];
					int nx = j + dx[d];
					if (ny < 0 || ny >= n || nx < 0 || nx >= m || map[ny][nx] == -1) continue;
					backUp[ny][nx] += map[i][j] / 5;
					cnt++;
				}
				backUp[i][j]-= (map[i][j] / 5*cnt);
			}
		}
	}
	memcpy(map, backUp, sizeof(backUp));
}
void isClean() {
	for (int i = mc[0] - 1; i >= 1; i--) {
		map[i][0] = map[i - 1][0];
	}
	for (int j = 0; j+1 < m; j++) {
		map[0][j] = map[0][j + 1];
	}
	for (int i = 0; i < mc[0]; i++) {
		map[i][m - 1] = map[i+1][m - 1];
	}
	for (int j = m - 1; j >1; j--) {
		map[mc[0]][j] = map[mc[0]][j-1];
	}
	map[mc[0]][1] = 0;
	for (int i = mc[1] + 1; i < n - 1; i++) {
		map[i][0] = map[i + 1][0];
	}
	for (int j = 0; j < m - 1; j++) {
		map[n - 1][j] = map[n-1][j + 1];
	}
	for (int i = n -1; i > mc[1]; i--) {
		map[i][m - 1] = map[i-1][m - 1];
	}
	for (int j = m - 1;j > 1; j--) {
		map[mc[1]][j] = map[mc[1]][j - 1];
	}
	map[mc[1]][1] = 0;
}
int main() {
	cin >> n >> m >> t;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> map[i][j];
			if (map[i][j] == -1)
				mc.push_back(i);
		}
	}
	while (t--) {
		isPlus();
	    isClean();
	}
	int answer = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (map[i][j] != 0 && map[i][j] != -1)
				answer += map[i][j];
			
		}
	}
	cout << answer;
}