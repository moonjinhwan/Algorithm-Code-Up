#include<iostream>
#include<queue>
#include<algorithm>
using namespace std;
int main() {
	int n;
	cin >> n;
	priority_queue < pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
	while (n--) {
		int a;
		cin >> a;
		if(a!=0) pq.push({ abs(a),a });
		else {
			if (!pq.empty()) {
				cout<<pq.top().second << '\n';
				pq.pop();
			}
			else {
				cout << 0<<'\n';
			}
		}
	}
}