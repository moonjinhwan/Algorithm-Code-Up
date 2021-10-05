#include<iostream>
using namespace std;
int main() {
	long long n;
	cin >> n;
	long long sum = 0;
	int answer;
	for (int i = 1; i <= n; i++) {
		sum += i;
		if (sum > n) {
			answer = i;
			break;
		}
	}
	cout << answer - 1;
}