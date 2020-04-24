#include<iostream>
#include<queue>
#include<cstring>
using namespace std;
int N, M,time;
int map[100][100];
bool off;
bool visit[100][100];
int contactAir[100][100] = { 0, };
int dx[4] = { 0,0,-1,1 };
int dy[4] = { 1,-1,0,0 };
void del() {
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (contactAir[i][j] >= 2) {
				map[i][j] = 0;
			}
		}
	}
}
void bfs(int y,int x) {
	memset(contactAir, 0, sizeof(contactAir));
	memset(visit, false, sizeof(visit));
	queue<pair<int,int>> q;
	q.push({ y,x });
	visit[y][x]=true;
	while (!q.empty()) {
		int cx = q.front().second;
		int cy = q.front().first;
		q.pop();
		for (int i = 0; i < 4; i++) {
			int ny = cy + dy[i];
			int nx = cx + dx[i];
			if (ny < 0 || ny >= N || nx < 0 || nx >= M|| visit[ny][nx])continue;
			if (map[ny][nx] == 1) {
				contactAir[ny][nx]++;
				off = false;
			}
			else {
				visit[ny][nx] = true;
				q.push({ ny,nx });
			}
		}
	}
	if (!off) {
		del();
		time++;
	}
}
int main() {
	scanf("%d%d", &N, &M);
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			scanf("%d", &map[i][j]);
		}
	}
	while (!off) {
		off = true;
		bfs(0,0);
	}
	cout << time;
}
/*
main
	while !off
		off = true
		bfs 0,0


bfs
	while !q empty
		for 4dir
			if bound
			if map i,j==1
				contAir i,j +=1
				off=false
			else
				push,visit
	if !off
		del
		time++

del contAir
	for
		for
			if contAir ==2 
				map i,j =0
*/