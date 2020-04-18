#include<iostream>
using namespace std;
int dx[4] = { 0,1,0,-1 };
int dy[4] = { -1,0,1,0 };
int info[50][50];
bool visit[50][50];
int CleanNum;
int cnt;
int n, m, r, c, d;/*����,����,y,x*/
bool off;
void simulation() {
	while (true) {
		cnt = 0;
		if (visit[r][c] == false && info[r][c] == 0) {
			visit[r][c] = true;
			CleanNum++;
		}
		while (true) {
			if (cnt == 4) {//4���� �� ���Ҵµ� ���� ����
				cnt = 0;
				//�ڿ� ���ִ� ���, �κ� ����
				if (info[r + dy[(d + 2) % 4]][c + dx[(d + 2) % 4]] == 1) {
					off = true;
					break;
				}
				else {//�ڿ� ���� ������ ���� ����, �ڷ� ��ĭ
					r += dy[(d + 2) % 4];
					c += dx[(d + 2) % 4];
					continue;
				}
			}
			//���ʿ� û�� �� �Ѱ� ����
			if (info[r + dy[(d + 3) % 4]][c + dx[(d + 3) % 4]] == 0 &&
				visit[r + dy[(d + 3) % 4]][c + dx[(d + 3) % 4]] == false) {
				visit[r + dy[(d + 3) % 4]][c + dx[(d + 3) % 4]] = true;
				r += dy[(d + 3) % 4];
				c += dx[(d + 3) % 4];
				d = (d + 3) % 4;
				CleanNum++;
				break;
			}
			//���� û�� ����, ���⸸ �ٲ�
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