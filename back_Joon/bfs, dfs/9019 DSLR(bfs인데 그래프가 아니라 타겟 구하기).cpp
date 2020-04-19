/*
dslr
d->n을 두배
s->n-1
l->맨 앞을 맨 뒤로
r->맨 뒤를 맨 앞으로
제한 조건은????

bfs
	while
		if cur == b 
			break
		next= 두배
		if visit false
			push
		next = -1
		if visit false
			
		next = l
		next = r

for 테스트 케이스
	bfs
*/
#include<iostream>
#include<queue>
#include<string>
#include<cstring>
using namespace std;
int a, b;
const int INF = 10000;
bool visit[INF];
void bfs() {
	queue <pair<int, string>> q;
	q.push({ a,"" });
	visit[a] = true;
	while (!q.empty()) {
		int cur = q.front().first;
		string cmd = q.front().second;
		if (cur == b) {
			cout << cmd << '\n';
			break;
		}
		q.pop();
		int next = cur * 2;
		next = (next > 9999) ? next % INF : next;
		if (!visit[next]) {
			visit[next] = true;
			q.push({ next, cmd + "D" });
		}

		next = cur - 1;
		next = (next < 0) ? 9999 : next;
		if (!visit[next]) {
			visit[next] = true;
			q.push({ next, cmd + "S" });
		}
		
		next = (cur % 1000) * 10 + cur / 1000;
		if (!visit[next]) {
			visit[next] = true;
			q.push({ next, cmd + "L" });
		}

		next = (cur % 10) * 1000 + cur/10;
		if (!visit[next]) {
			visit[next] = true;
			q.push({ next, cmd + "R" });
		}
	}
}
int main() {
	int t;
	cin >> t;
	for (int i = 0; i < t; i++) {
		cin >> a >> b;
		memset(visit, false, sizeof(visit));
		bfs();
	}
}