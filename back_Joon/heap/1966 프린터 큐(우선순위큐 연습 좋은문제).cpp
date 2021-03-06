#include <iostream>
#include<queue>
#include<algorithm>
using namespace std;
bool cmp(pair<int, int> a, pair<int, int> b) {
	if (a.first == b.first) {
		return a.second > b.second;
	}
	return a.first > b.first;
}
int main() {
	int TEST;
	cin >> TEST;
	for (int t = 0; t < TEST; t++) {
		int N;
		int M;
		cin >> N >> M;
		priority_queue<int> pq;
		queue<pair<int, int>> q;
		for (int i = 0; i < N; i++) {
			int tmp;
			cin >> tmp;
			pq.push(tmp);
			q.push({ i,tmp });
		}
		int cnt = 0;
		while (!q.empty()) {
			int index = q.front().first;
			int val = q.front().second;
			q.pop();
			if (pq.top() == val) {
				cnt++;
				pq.pop();
				if (index == M) {
					cout << cnt << endl;
					break;
				}
			}
			else {
				q.push({ index, val });
			}
		}
	}
}