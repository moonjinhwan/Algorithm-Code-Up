/*
cctv마다 볼수 있는 공간 최대값을 구한다
cctv가 보는 방향 정하고 또 다음 cctv가 정하는 방향....이렇게
모든 경우의 수를 탐색한다.
전부 더해서 최대값을 구하고 map에서 최대값을 빼면 정답
*/
#include<iostream>
#include<vector>
#include<algorithm>
#include<cstring>
using namespace std;
struct CCTV {
	int y;
	int x;
	int type;
};
int answer;
vector<CCTV> tv;
int cctvNum;
int n, m;
int map[8][8];
bool visit[8][8];
int countArea(int dir, int y,int x) {
	int sum = 0;
	if (dir == 0) {
		for (int j = x + 1; j < m; j++) {
			if (map[y][j] == 0 && !visit[y][j]) {
				sum++; 
				visit[y][j] = true;
			}
			else if (map[y][j] == 6) break;
		}
	}
	else if (dir == 1) {
		for (int j = y + 1; j < n; j++) {
			if (map[j][x] == 0 && !visit[j][x]) {
				sum++;
				visit[j][x] = true;
			}
			else if (map[j][x] == 6) break;
		}
	}
	else if (dir == 2) {
		for (int j = x - 1; j>=0; j--) {
			if (map[y][j] == 0 && !visit[y][j]) {
				sum++;
				visit[y][j] = true;
			}
			else if (map[y][j] == 6) break;
		}
	}
	else if (dir == 3) {
		for (int j = y - 1; j>=0; j--) {
			if (map[j][x] == 0 && !visit[j][x]) {
				sum++;
				visit[j][x] = true;
			}
			else if (map[j][x] == 6) break;
		}
	}
	return sum;
}
void simul(int idx, int sum) {
	if (idx == tv.size()) {
		answer = max(answer, sum);
		return;
	}
	int tmp = 0;
	bool backUp[8][8];
	memcpy(backUp, visit, sizeof(visit));
	if (tv[idx].type == 1) {
		
		for (int i = 0; i < 4; i++) {
			tmp = 0;
			tmp += countArea(i % 4, tv[idx].y, tv[idx].x);
			simul(idx + 1, sum+tmp);
			memcpy(visit, backUp, sizeof(visit));
		}
	}
	else if (tv[idx].type == 2) {
		for (int i = 0; i < 2; i++) {			
			tmp = 0;
			tmp += countArea(i % 4, tv[idx].y, tv[idx].x);
			tmp += countArea((i + 2) % 4, tv[idx].y, tv[idx].x);
			simul(idx + 1, sum + tmp);
			memcpy(visit, backUp, sizeof(visit));
		}
	}
	else if (tv[idx].type == 3) {
		for (int i = 0; i < 4; i++) {
			tmp = 0;
			tmp += countArea(i % 4, tv[idx].y, tv[idx].x);
			tmp += countArea((i + 1) % 4, tv[idx].y, tv[idx].x);
			simul(idx + 1, sum + tmp);
			memcpy(visit, backUp, sizeof(visit));
		}
	}
	else if (tv[idx].type == 4) {
		for (int i = 0; i < 4; i++) {
			tmp = 0;
			tmp += countArea(i % 4, tv[idx].y, tv[idx].x);
			tmp += countArea((i + 1) % 4, tv[idx].y, tv[idx].x);
			tmp += countArea((i + 2) % 4, tv[idx].y, tv[idx].x);
			simul(idx + 1, sum + tmp);
			memcpy(visit, backUp, sizeof(visit));
		}
	}
	else if (tv[idx].type == 5) {
		for (int i = 0; i < 4; i++) {
			tmp+= countArea(i % 4, tv[idx].y, tv[idx].x);
		}
		simul(idx + 1, sum + tmp);
		memcpy(visit, backUp, sizeof(visit));
	}
}
int main() {
	cin >> n >> m;
	int zeroToal=0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> map[i][j];
			if (map[i][j] == 0) zeroToal++;
			else if(map[i][j]!=6)
			{
				tv.push_back({ i,j,map[i][j] });
			}
		}
	}
	simul(0,0);
	cout << zeroToal - answer;
}