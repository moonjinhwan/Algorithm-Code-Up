#include<iostream>
#include<algorithm>
using namespace std;
int dx[4] = {1,0,-1,0};//µ¿,³²,¼­,ºÏ
int dy[4] = {0,-1,0,1};
int main() {
	int T;
	cin >> T;
	while (T--)
	{
		int min_x=0, max_x=0, min_y=0, max_y=0;
		string str;
		cin >> str;
		int x = 0;
		int y = 0;
		int dir = 3;
		for (int i = 0; i < str.size(); i++) {
			if (str[i] == 'F') {
				x += dx[dir];
				y += dy[dir];
			}
			else if (str[i] == 'B') {
				x -= dx[dir];
				y -= dy[dir];
			}
			else if (str[i] == 'L') {
				dir -= 1;
				if (dir < 0) dir = 3;
			}
			else if (str[i] == 'R') {
				dir = (dir + 1) % 4;
			}
			min_x = min(x, min_x);
			min_y = min(y, min_y);
			max_x = max(x, max_x);
			max_y = max(y, max_y);
		}
		printf("%d\n",(max_y - min_y) * (max_x - min_x));
	}
}