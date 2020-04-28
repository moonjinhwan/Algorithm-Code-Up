#include<iostream>
#include<vector>
#include<algorithm>
#include<cstring>
using namespace std;
int T;
int map[1000000];
void init(int N) {
	memset(map, 0, sizeof(map));
	for (int i = 0; i < N; i++) {
		cin >> map[i];
	}
}
int main() {
	cin >> T;
	while (T--) {
		int N;
		cin >> N;
		init(N);
		int maxx = map[N - 1];
		long long answer = 0;
		for (int i = N-2; i>=0; i--) {
			if (maxx < map[i]) {
				maxx = map[i];
			}
			else {
				answer += (maxx - map[i]);
			}
		}
		cout << answer<<endl;
	}
}