#include<iostream>
#include<cstring>
#include<string>
#include<algorithm>
using namespace std;
int N, M;
int map[4][4];
int list[16];
bool visit[4][4];
int dx[2] = { 1,0 };
int dy[2] = { 0,1 };
int answer;
int result;
void init() {
	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			scanf("%1d", &map[i][j]);
		}
	}
}
void isRow() {
	result = 0;
	for (int j = 0; j < M; j++) {
		int sum=0;
		for (int i = 0; i < N; i++) {
			if (list[i * M + j] == 1) {
				sum *= 10;
				sum += map[i][j];
			}
			else {
				result += sum;
				sum = 0;
			}
		}
		result += sum;
	}
}
void isCol() {
	for (int i = 0; i < N; i++) {
		int sum=0;
		for (int j = 0; j < M; j++) {
			if (list[i * M + j] == 0) {
				sum *= 10;
				sum += map[i][j];
			}
			else {
				result += sum;
				sum = 0;
			}
		}
		result += sum;
	}
	answer=max(answer, result);
}
void print() {
	cout << "============\n";
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cout << list[i * M + j];
		}
		cout << endl;
	}
}
void go(int idx) {
	if (idx == M*N) {
		//print();
		isRow();
		isCol();
		return;
	}
	list[idx] = 1;
	go(idx + 1);
	list[idx] = 0;
	go(idx + 1);
}
int main() {
	init();
	go(0);
	cout << answer;
}