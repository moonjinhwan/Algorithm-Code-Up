#include<iostream>
using namespace std;
int main() {
	int n;
	cin >> n;
	if (n == 3 || n == 1) {
		cout << -1;
		return 0;
	}
	int mok = n / 5;
	int res = n-mok * 5;
	int result=0;
	if (res % 2 != 0) {
		mok--;
		res = n-mok*5;
	}
	result = mok + res / 2;
	cout << result;
}