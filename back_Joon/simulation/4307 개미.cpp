#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
int main() {
	int TEST;
	cin >> TEST;
	for (int t = 0; t < TEST; t++) {
		int N, L;
		cin >> N >> L;
		vector<int> min_time;
		vector<int> max_time;
		for (int i = 0; i < L; i++) {
			int a;
			cin >> a;
			min_time.push_back(min(a, N - a));
			max_time.push_back(max(a, N - a));
		}
		cout << *max_element(min_time.begin(), min_time.end()) << ' ';
		cout << *max_element(max_time.begin(), max_time.end()) << endl;
	}
}