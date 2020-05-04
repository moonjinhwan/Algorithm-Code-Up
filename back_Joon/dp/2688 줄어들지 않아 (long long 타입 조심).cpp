#include<iostream>
#include<cstring>
using namespace std;
long long d[65][10] = { 0 };
int main() {
	int t;
	cin >> t;
	while (t --) {
		int a;
		cin >> a;
		memset(d, 0, sizeof(d));
		for (int i = 0; i <= 9; i++) {
			d[1][i] = 1;
		}
		for (int i = 1; i <= a; i++) {//현재 자리수
			for (int j = 0; j <= 9; j++) {//현재 추가할 수
				for (int k = j; k <= 9; k++) {//과거에 구해 놓은 자리수
					d[i][j] += d[i - 1][k];
				}
			}
		}
		long long sum = 0;
		for (int i = 0; i <= 9; i++) {
			sum += d[a][i];
		}
		cout << sum << endl;
	}

}