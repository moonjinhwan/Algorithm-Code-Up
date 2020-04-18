#include<iostream>
#include<cstring>
using namespace std;
int a, b;//가로,세로
int n, m;//로봇수, 명령
int dx[4] = { 1,0,-1,0};//동남서북
int dy[4] = { 0,-1,0,1};
int visit[100][100] = { 0, };
int tag = false;
struct ROBOT {
	int x;
	int y;
	int d;
};
ROBOT rob[100];
void simulation(int num, char cmd, int re) {
	int x = rob[num - 1].x;
	int y = rob[num - 1].y;
	int d = rob[num - 1].d;
	for (int i = 0; i < re; i++) {
		
		if (cmd == 'F') {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx < 0 || nx >= a || ny < 0 || ny >= b) {//맵 나감
				printf("Robot %d crashes into the wall\n", num);
				tag = true;
				return;
			}
			if (visit[ny][nx] != 0) {
				printf("Robot %d crashes into robot %d\n",num, visit[ny][nx]);
				tag = true;
				return;
			}
			else {
				visit[y][x] = 0;
				visit[ny][nx] = num;
				x = nx; y = ny;
			}
		}
		else if (cmd == 'L') {
			d = (d + 3) % 4;
		}
		else if (cmd == 'R') {
			d = (d + 1) % 4;
		}
	}
	//마지막 위치를 갱신 해준다
	rob[num - 1].x = x;
	rob[num - 1].y = y;
	rob[num - 1].d = d;
}
int main() {
	cin >> a >> b;
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		int p, q;
		char spin;
		cin >> p >> q;
		p--;
		q--;
		rob[i].x = p; rob[i].y = q;
		cin >> spin;
		if (spin == 'E') rob[i].d = 0;
		else if (spin == 'S') rob[i].d = 1;
		else if (spin == 'W') rob[i].d = 2;
		else if (spin == 'N') rob[i].d = 3;
	}
	for (int i = 0; i < n; i++) {
		visit[rob[i].y][rob[i].x] = i + 1;
	}
	for (int i = 0; i < m; i++) {

		int num, re;
		char cmd;
		cin >> num >> cmd >> re;		
		simulation(num,cmd,re);
		if (tag) {
			break;
		}
	}if(!tag)
		cout << "OK";
}
