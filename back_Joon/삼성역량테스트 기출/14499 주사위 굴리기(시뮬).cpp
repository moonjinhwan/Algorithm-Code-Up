#include<iostream>
#include<vector>
using namespace std;
int map[20][20];
int dx[4] = { 1,-1,0,0 };//0123
int dy[4] = { 0,0,-1,1 };//�����ϳ�
int n, m, x, y, cmdNum;
int dice[6] = { 0, };
void rotate(int cmd) {
	int temp;
	if (cmd == 0) {//��
		temp = dice[4];
		dice[4] = dice[0];
		dice[0] = dice[5];
		dice[5] = dice[2];
		dice[2] = temp;
	}
	else if (cmd == 1) {//��
		temp = dice[0];
		dice[0] = dice[4];
		dice[4] = dice[2];
		dice[2] = dice[5];
		dice[5] = temp;
	}
	else if (cmd == 2) {//��
		temp = dice[3];
		dice[3] = dice[0];
		dice[0] = dice[1];
		dice[1] = dice[2];
		dice[2] = temp;
	}
	else if (cmd == 3) {//�� �Ʒ���
		temp = dice[1];
		dice[1] = dice[0];
		dice[0] = dice[3];
		dice[3] = dice[2];
		dice[2] = temp;
	}
}
void copyDice(int cy, int cx) {
	if (map[cy][cx] == 0) {
		map[cy][cx] = dice[2];
	}
	else {
		dice[2] = map[cy][cx];
		map[cy][cx] = 0;
	}
	cout << dice[0]<<'\n';
}
int main() {
	cin >> n >> m >> y >> x >> cmdNum;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> map[i][j];
		}
	}
	for (int i = 0; i < cmdNum; i++) {
		int cmd;
		cin >> cmd;
		cmd--;
		int ny = y + dy[cmd];
		int nx = x + dx[cmd];
		if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
		rotate(cmd);
		copyDice(ny,nx);
		x = nx;
		y = ny;
	}
	
}
/*
for cmd.size
	if 1
		������ ������Ʈ
		rotage
	else if 2
		���� ������Ʈ
	else if 3
		���� ������Ʈ
	else if 4
		�Ʒ��� ������Ʈ
*/