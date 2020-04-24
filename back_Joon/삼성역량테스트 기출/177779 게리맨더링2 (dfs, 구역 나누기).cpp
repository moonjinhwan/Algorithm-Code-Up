/*
main
	init
	pickPos
pickPos
	for d1
		for d2
			for y
				if y-d1<0 || y+d2>=N break;
				for x
					if x+d1+d2>=N break
					marking y,x,d1,d2

marking y,x,d1,d2
	5번 마킹
	idx=y
	for j=x ~ x+d1
		group[idx--][j]
	idx=y-d1
	for j=x+d1 ~ x+d1+d2
		group[idx++][j]
	for
		
	for
		
*/
#include<iostream>
#include<cstring>
#include<vector>
#include<algorithm>
using namespace std;
int N;
int map[20][20];
int mark[20][20];
int dx[4] = { 1,0,-1,0 };
int dy[4] = { 0,1,0,-1 };
bool visit[20][20];
int answer = 987654321;
void init() {
	cin >> N;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> map[i][j];
		}
	}
}
//void print() {
//	cout << "=================\n";
//	for (int i = 0; i < N; i++) {
//		for (int j = 0; j < N; j++) {
//			cout << mark[i][j] << ' ';
//		}
//		cout << endl;
//	}
//	cout << "=================\n";
//}
void dfs(int y,int x,int color) {
	visit[y][x] = true;
	mark[y][x] = color;
	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];
		if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
		if (visit[ny][nx] == false && mark[ny][nx]==0) {
			dfs(ny,nx,color);
		}
	}
}
void isCount() {
	int color[6] = { 0, };
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (mark[i][j] == 1) color[1]+=map[i][j];
			else if (mark[i][j] == 2) color[2] += map[i][j];
			else if (mark[i][j] == 3)color[3] += map[i][j];
			else if (mark[i][j] == 4)color[4] += map[i][j];
			else if (mark[i][j] == 5 || mark[i][j] == 0) color[5] += map[i][j];
		}
	}
	int maxColor=*max_element(color + 1, color + 6);
	int minColor = *min_element(color + 1, color + 6);
	int result = maxColor - minColor;
	answer = min(answer, result);
}
void isMarking(int y,int x,int d1,int d2) {
	memset(mark, 0, sizeof(mark));
	memset(visit, false, sizeof(visit));
	for (int k = 0;k<=d1; k++) {
		mark[y - k][x + k] = 5;
		mark[y + d2 - k][x + d2 + k] = 5;
	}
	for (int k = 0; k <= d2; k++) {
		mark[y + k][x + k] = 5;
		mark[y - d1 + k][x + d1 + k] = 5;
	}
	//왼가로 3
	for (int k = x-1; k >= 0; k--) mark[y][k] = 3;
	//오른가로 2
	for (int k = x + d1 + d2+1; k < N; k++) mark[y - d1 + d2][k] = 2;
	//아래세로 1
	for (int k = y - d1-1; k >= 0; k--) mark[k][x + d1] = 1;
	//위세로 4
	for (int k = y + d2+1; k < N; k++) mark[k][x + d2] = 4;
	dfs(0, 0, 1);
	dfs(0, N-1, 2);
	dfs(N-1, 0, 3);
	dfs(N-1, N-1, 4);
	isCount();
}
void solve() {
	for (int i = 1; i < N-1; i++) {
		for (int j = 0; j < N-2; j++) {
			for (int d1 = 1; d1 < 20; d1++) {
				for (int d2 = 1; d2 < 20; d2++) {
					if (i - d1 < 0 || j + d1 + d2 >= N || i + d2 >= N) continue;
					isMarking(i,j,d1,d2);
				}
			}
		}
	}
}
int main() {
	init();
	solve();
	cout << answer;
}