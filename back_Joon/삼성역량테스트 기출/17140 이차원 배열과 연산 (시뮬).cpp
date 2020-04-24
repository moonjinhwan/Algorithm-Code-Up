#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
int map[100][100];
int R, C, K;
int answer;
int maxRowSize=3;
int maxColSize=3;
void init() {
	cin >> R >> C >> K;
	R--; C--;
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
			cin >> map[i][j];
		}
	}
}
void isRow() {
	for (int i = 0; i < maxRowSize; i++) {
		int list[101] = {0,};
		vector<pair<int, int>> update;
		for (int j = 0; j < maxColSize; j++) {
			if(map[i][j]!=0)
				list[map[i][j]]++;
		}
		for (int j = 1; j <= 100; j++) {
			if (list[j] != 0) {
				update.push_back({ list[j], j });
			}
		}
		int temp = update.size() * 2;
		maxColSize = max(maxColSize, temp);
		sort(update.begin(), update.end());
		int idx = 0;
		for (int j = 0; j < update.size(); j++) {
			map[i][idx++] = update[j].second;
			map[i][idx++] = update[j].first;
		}
		for (int j = idx; j < maxColSize; j++) {
			map[i][j] = 0;
		}
	}
}
void isCol() {
	for (int j = 0; j < maxColSize; j++) {
		int list[101] = { 0, };
		vector<pair<int, int>> update;
		for (int i = 0; i < maxRowSize; i++) {
			if (map[i][j] != 0)
				list[map[i][j]]++;
		}
		for (int i = 1; i <= 100; i++) {
			if (list[i] != 0) {
				update.push_back({ list[i], i });
			}
		}
		int temp = update.size() * 2;
		maxRowSize = max(maxRowSize, temp);
		sort(update.begin(), update.end());
		int idx = 0;
		for (int i = 0; i < update.size(); i ++) {
			map[idx++][j] = update[i].second;
			map[idx++][j] = update[i].first;
		}
		for (int i =idx; i < maxRowSize; i++) {
			map[i][j] = 0;
		}
	}
}
bool checkMap() {
	for (int i = 0; i < maxRowSize; i++) {
		for (int j = 0; j < maxColSize; j++) {
			if (map[R][C] == K) return true;
			else return false;
		}
	}
}
void play() {
	while (1) {
		if (answer > 100) {
			cout << -1<<endl;
			break;
		}
		if (checkMap()) {
			cout << answer<<endl;
			break;
		}
		if (maxRowSize >= maxColSize) {
			isRow();
		}
		else
			isCol();
		answer++;
	}
}
//void print() {
//	for (int i = 0; i < maxRowSize; i++) {
//		for (int j = 0; j < maxColSize; j++) {
//			cout << map[i][j]<<' ';
//		}
//		cout << endl;
//	}
//}
int main() {
	init();
	play();
}