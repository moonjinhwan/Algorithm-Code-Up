#include<iostream>
#include<algorithm>
#include<string>
using namespace std;
int r1, c1, r2, c2;
int map[50][6];
int dx[4] = { 1,0,-1,0 };//동북서남
int dy[4] = { 0,-1,0,1 };//동북서남

int main() {
	scanf("%d%d%d%d", &r1, &c1, &r2, &c2);
	int x = 0;
	int y = 0;
	int len = 1;
	int d = 0;
	int num = 1;
	if (x - c1 >= 0 && c2 - c1 >= x - c1 && y - r1 >= 0 && y - r1 <= r2 - r1) {
		map[y - r1][x - c1] = num;
	}
	while (map[0][0] == 0 || map[r2 - r1][0] == 0|| map[0][c2 - c1] == 0 || map[r2 - r1][c2 - c1] == 0) {//네 모서리 중 한곳이라도 0이면 반복 더 한다
		for (int i = 0; i < len; i++) {
			x += dx[d];
			y += dy[d];
			num++;
			if (x - c1 >= 0 && c2 - c1 >= x - c1 && y - r1 >= 0 && y - r1 <= r2 - r1) {
				map[y - r1][x - c1] = num;
			}
		}
		if (d == 1 || d == 3) len++;
		d = (d + 1) % 4;
	}

	//출력조건
	int cnt = 0;
	int maxLen = 0;
	for(int i=0;i<50;i++)
		maxLen = max(maxLen,*max_element(map[i], map[i] + 5));
	while (maxLen > 0) {
		maxLen /= 10;
		cnt++;
	}
	for (int i = 0; i <= (r2 - r1); i++) {
		for (int j = 0; j <= (c2 - c1); j++) {
			string tmp = to_string(map[i][j]);
				for(int k=0;k<cnt-tmp.size();k++)
					printf(" ");
			printf("%d ", map[i][j]);
		}
		cout << endl;
	}
}