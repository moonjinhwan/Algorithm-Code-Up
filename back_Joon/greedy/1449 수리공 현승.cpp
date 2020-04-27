#include<iostream>
#include<algorithm>
using namespace std;
int list[1000];
int main() {
	int N, L;
	cin >> N >> L;
	for (int i = 0; i < N; i++) {
		cin >> list[i];
	}
	sort(list, list + N);
	int answer = 0;
	for (int i = 0; i < N; i++) {
		int len = 0;
		for (int j = i; j < N - 1; j++) {
			len += (list[j + 1] - list[j]);
			if (len > L) {
				i = j;
				//cout << j<<' ';
				answer++;
				break;
			}
		}
		if (len == 0) {
			//cout << i << ' ';
			answer++;
		}
	}
	cout << answer;
}