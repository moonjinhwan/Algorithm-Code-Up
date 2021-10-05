#include<iostream>
#include<algorithm>
using namespace std;
int main() {
	int N;
	cin >> N;
	int list[100];
	for (int i = 0; i < N; i++) {
		cin >> list[i];
	}
	int result=0;
	for (int i = N-1; 0 < i; i--) {
		if (list[i-1] >= list[i]) {
			int temp = abs(list[i] - list[i - 1]) + 1;
			list[i - 1] -= temp;
			result+=temp;
		}
	}
	cout << result;
}