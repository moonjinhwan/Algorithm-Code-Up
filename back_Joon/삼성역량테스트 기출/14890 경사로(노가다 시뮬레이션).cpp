#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;
int map[100][100];
bool visit[100];
int N, L, answer;
void init() {
	cin >> N >> L;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> map[i][j];
		}
	}
}
bool incline(int y,int x) {
	int cnt = 0;
		for (int k = 0; k < L; k++) {
			if (x-k>=0 && map[y][x] == map[y][x - k] && !visit[x-k]) {
				visit[x-k] = true;
				cnt++;
			}
		}
		if (cnt == L) {
			return true;
		}
		return false;
}
bool decline(int y,int x) {
	int cnt = 0;
	for (int k = 0; k < L; k++) {
		if (x+k<N && map[y][x] == map[y][x+k] && !visit[x+k]) {
			visit[x + k] = true;
			cnt++;
		}
	}
	if (cnt == L) {
		return true;
	}
	else
		return false;
}
bool rowIncline(int y, int x) {
	int cnt = 0;
	for (int k = 0; k < L; k++) {
		if (y - k >=0 && map[y][x] == map[y-k][x] && !visit[y - k]) {
			visit[y - k] = true;
			cnt++;
		}
	}
	if (cnt == L) {
		return true;
	}
	return false;
}
bool rowDecline(int y, int x) {
	int cnt = 0;
	for (int k = 0; k < L; k++) {
		if (y + k < N && map[y][x] == map[y+k][x] && !visit[y + k]) {
			visit[y + k] = true;
			cnt++;
		}
	}
	if (cnt == L) {
		return true;
	}
	else
		return false;
}
void go() {
	//열을 탐색하며 경사로 확인
	for (int i = 0; i < N; i++) {
		bool pass = true;
		memset(visit, false, sizeof(visit));
		for (int j = 0; j < N; j++) {
			if (abs(map[i][j] - map[i][j + 1]) > 1 && j + 1 < N) {//2차이
				pass = false;
				break;
			}
			if (j + 1 < N && map[i][j] + 1 == map[i][j + 1]) {//오르막
				if (incline(i, j) == false) {
					pass = false;
					memset(visit, false, sizeof(visit));
					break;
				}
			}
			if (j + 1 < N && map[i][j] == map[i][j + 1] + 1) {//내리막
				if (rowDecline(i, j + 1) == false) {
					pass = false;
					memset(visit, false, sizeof(visit));
					break;
				}
			}
		}
		if (pass) {
			answer++;
		}
	}
	//행 탐색하며 경사로 확인
	for (int j = 0; j < N; j++) {
		bool pass = true;
		memset(visit, false, sizeof(visit));
		for (int i = 0; i < N; i++) {
			if (abs(map[i][j] - map[i + 1][j]) > 1 && i + 1 < N) {//2차이
				pass = false;
				break;
			}
			if (i + 1 < N && map[i][j] + 1 == map[i + 1][j]) {//오르막
				if (rowIncline(i, j) == false) {
					pass = false;
					memset(visit, false, sizeof(visit));
					break;
				}
			}
			if (i + 1 < N && map[i][j] == map[i + 1][j] + 1) {//내리막
				if (decline2(i + 1, j) == false) {
					pass = false;
					memset(visit, false, sizeof(visit));
					break;
				}
			}
		}
		if (pass) {
			answer++;
		}
	}
}
int main() {
	init();
	go();
	cout << answer;
}