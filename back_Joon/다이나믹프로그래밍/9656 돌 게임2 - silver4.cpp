#include<iostream>
using namespace std;
int d[1001];
int main() {
	int n;
	cin >> n;
	d[1] = 1;
	d[2] = 0;
	for (int i = 3; i <= n; i++) {
		d[i] = 1 - d[i - 1];
	}
	if (d[n] == 0) {
		cout << "SK";
	}
	else {
		cout << "CY";
	}
}