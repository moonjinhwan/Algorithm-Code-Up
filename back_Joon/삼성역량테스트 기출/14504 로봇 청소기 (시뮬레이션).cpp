#include<iostream>
using namespace std;
int dx[4] = { 0,1,0,-1 };
int dy[4] = { -1,0,1,0 };
int info[50][50];
bool visit[50][50];
int CleanNum;
int cnt;
int n, m, r, c, d;/*세로,가로,y,x*/
bool off;
void simulation() {
	while (true) {
		cnt = 0;
		if (visit[r][c] == false && info[r][c] == 0) {
			visit[r][c] = true;
			CleanNum++;
		}
		while (true) {
			if (cnt == 4) {//4방향 다 돌았는데 갈곳 없음
				cnt = 0;
				//뒤에 벽있는 경우, 로봇 종료
				if (info[r + dy[(d + 2) % 4]][c + dx[(d + 2) % 4]] == 1) {
					off = true;
					break;
				}
				else {//뒤에 갈곳 있으면 방향 유지, 뒤로 한칸
					r += dy[(d + 2) % 4];
					c += dx[(d + 2) % 4];
					continue;
				}
			}
			//왼쪽에 청소 안 한곳 있음
			if (info[r + dy[(d + 3) % 4]][c + dx[(d + 3) % 4]] == 0 &&
				visit[r + dy[(d + 3) % 4]][c + dx[(d + 3) % 4]] == false) {
				visit[r + dy[(d + 3) % 4]][c + dx[(d + 3) % 4]] = true;
				r += dy[(d + 3) % 4];
				c += dx[(d + 3) % 4];
				d = (d + 3) % 4;
				CleanNum++;
				break;
			}
			//왼쪽 청소 했음, 방향만 바꿈
			else if (visit[r + dy[(d + 3) % 4]][c + dx[(d + 3) % 4]] == true) {
				d = (d + 3) % 4;
				cnt++;
				continue;
			}

		}
		if (off)
			break;
	}
}
int main() {
	cin >> n >> m >> r >> c >> d;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> info[i][j];
			if (info[i][j] == 1)
				visit[i][j] = true;
		}
	}
	simulation();
	cout << CleanNum;
}