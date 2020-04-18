#include<iostream>
#include<queue>
#include<cstring>
using namespace std;
char info[12][6];
char backUp[12][6];
bool visit[12][6] = { false, };
int dy[4] = {0,0,1,-1};
int dx[4] = { 1,-1, 0,0 };
bool tag = true;
void isDel() {
	for (int j = 0; j < 6; j++) {//가로
		for (int i = 11; i >= 1; i--) {//세로
			if (info[i][j] == '.') {
				for (int k = i-1; k >= 0; k--) {//세로 한칸 위
					if (info[k][j] !='.') {
						info[i][j] = info[k][j];
						info[k][j] = '.';
						break;
					}
				}
			}
		}
	}
}
void bfs(int y,int x) {
	int count = 1;
	memcpy(backUp, info, sizeof(info));
	queue<pair<int,int>> q;
	q.push({ y,x });
	visit[y][x] = true;
	backUp[y][x] = '.';
	while (!q.empty()) {
		int cy = q.front().first;
		int cx = q.front().second;
		q.pop();
		for (int i = 0; i < 4; i++) {
			int ny = cy + dy[i];
			int nx = cx + dx[i];
			if (ny < 0 || ny >= 12 || nx < 0 || nx >= 6) continue;
			if (!visit[ny][nx] && info[ny][nx] == info[cy][cx]) {
				backUp[ny][nx] = '.';
				visit[ny][nx] = true;
				count++;
				q.push({ ny,nx });
			}
		}
	}
	if (count >= 4) {
		memcpy(info, backUp, sizeof(backUp));
		tag = true;
	}
}
int main() {
	int answer = 0;
	for (int i = 0; i < 12; i++) {
		for (int j = 0; j < 6; j++) {
			cin >> info[i][j];
		}
	}
	while (tag) {
		tag = false;
		memset(visit, false, sizeof(visit));
		
		for(int j=0;j<6;j++){
			for(int i=11;i>=0;i--){
				if (!visit[i][j] && info[i][j] != '.') {
					bfs(i,j);
				}
			}
		}
		if (tag) {
			isDel();//중력
			answer++;
		}
	}
	cout << answer<<endl;
}
