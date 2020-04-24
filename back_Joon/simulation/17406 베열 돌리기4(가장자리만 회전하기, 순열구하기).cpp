#include<iostream>
#include<cstring>
#include<algorithm>
using namespace std;
int N, M, K;
int map[50][50];
int backUp[50][50];
int cmd[6][3];
bool use[6];
int list[6];
const int INF = 987654321;
int answer=INF;
//void print() {
//	for (int i = 0; i < N; i++) {
//		for (int j = 0; j < M; j++) {
//			cout << map[i][j] << ' ';
//		}
//		cout << endl;
//	}
//	cout << "=============================\n";
//}
void init() {
	cin >> N >> M >> K;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> map[i][j];
		}
	}
	for (int i = 0; i < K; i++) {
		cin >> cmd[i][0] >> cmd[i][1] >> cmd[i][2];
		cmd[i][0]--;
		cmd[i][1]--;
	}
}
void checkMap(){
	int result = INF;
	for (int i = 0; i < N; i++) {
		int temp=0;
		for (int j = 0; j < M; j++) {
			temp += map[i][j];
		}
		result = min(result, temp);
	}
	answer = min(result, answer);
}
void spin() {
	for (int num = 0; num < K; num++) {
		int cy = cmd[list[num]][0]- cmd[list[num]][2],
			cx = cmd[list[num]][1]- cmd[list[num]][2];
		int ny = cmd[list[num]][0] + cmd[list[num]][2], 
			nx = cmd[list[num]][1] + cmd[list[num]][2];
		while (1) {
			if (ny == cy && cx == nx) {
				break;
			}
			int temp = map[cy][nx];
			for (int j = nx; j > cx; j--) {
				map[cy][j] = map[cy][j-1];
			}
			for (int i = cy; i < ny; i++) {
				map[i][cx] = map[i + 1][cx];
			}
			for (int j = cx; j < nx; j++) {
				map[ny][j] = map[ny][j + 1];
			}
			for (int i = ny; i > cy; i--) {
				map[i][nx] = map[i-1][nx];
			}
			map[cy+1][nx] = temp;
			cx++; cy++;
			nx--; ny--;
			
		}
	}
	checkMap();
}

void pick(int idx) {
	if (idx == K) {
		memcpy(backUp, map, sizeof(map));
		spin();
		//print();
		memcpy(map, backUp, sizeof(backUp));
		return;
	}
	for (int i = 0; i < K; i++) {
		if (use[i] == false) {
			use[i] = true;
			list[idx] = i;
			pick(idx + 1);
			use[i] = false;
		}
	}
}
int main() {
	init();
	pick(0);
	cout << answer;
}
