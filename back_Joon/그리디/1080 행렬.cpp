#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;
int N, M;
int map[50][50];
int target[50][50];
int result = 0;
const int INF = 987654321;
int answer=INF;
void init(){
	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			scanf("%1d", &map[i][j]);
		}
	}
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			scanf("%1d", &target[i][j]);
		}
	}
}
bool isCheck() {
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (map[i][j] != target[i][j]) {
				return false;
			}
		}
	}
	return true;
}
void flip(int y,int x) {
	for (int i = y; i < y + 3; i++) {
		for (int j = x; j < x + 3; j++) {
			map[i][j] = 1 - map[i][j];
		}
	}
}
void go() {
	bool tag=false;
	for (int i = 0; i < N - 2; i++) {
		for (int j = 0; j < M - 2; j++) {
			if (map[i][j]!=target[i][j]) {
				flip(i, j);
				result++;
			}
		}
	}
	if (isCheck()) {
		cout << result;
	}
	else {
		cout << -1;
	}
}
int main() {
	init();
	go();
}