#include<iostream>
using namespace std;
int main() {
	int n; cin >> n;
	int a[10] = { 0, };
	int left;
	for (int i = 0; i < n; i++) {
		cin >> left;
		for (int j = 0; j < n; j++) {
			if (left == 0 && a[j] == 0) {
				a[j] = i + 1;
				break;
			}
			else if (a[j] == 0) {
				left--;
			}
		}
	}
	for (int i = 0; i < n; i++) {
		cout << a[i] << ' ';
	}
}