#include<iostream>
#include<cstring>
#include<algorithm>
using namespace std;
int board[700][700];
int leftTop[1400] = { 0, };
int main() {
	int m, n;
	cin >> m >> n;
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < m; j++) {
			board[i][j] = 1;
		}
	}
	while (n--){
		int zero, one, two;
		cin >> zero >> one >> two;
		for (int i = zero; i < one + zero; i++) {
			leftTop[i] += 1;
		}
		for (int i = zero+one; i < 2*m-1; i++) {
			leftTop[i] += 2;
		}
	}
	
	int idx = 0;
	for (int i = m - 1; i >= 0; i--) {
		board[i][0] += leftTop[idx++];
	}
	for (int j = 1; j < m; j++) {
		board[0][j] += leftTop[idx++];
	}
	for (int i = 1; i < m; i++) {
		for (int j = 1; j < m; j++) {
			board[i][j] = board[i - 1][j];
		}
	}
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < m; j++) {
			cout << board[i][j]<<' ';
		}
		cout << endl;
	}
}