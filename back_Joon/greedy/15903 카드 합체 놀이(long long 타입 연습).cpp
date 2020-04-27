#include<iostream>
#include<algorithm>
using namespace std;
long long list[1000];
int main() {
	int N, M;
	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		cin >> list[i];
	}

	while (M--) {
		sort(list, list + N);
		long long sum = list[0] + list[1];
		list[0] = sum;
		list[1] = sum;
	}
	long long answer = 0;
	for (int i = 0; i < N; i++) {
		answer += list[i];
	}
	cout << answer;
}