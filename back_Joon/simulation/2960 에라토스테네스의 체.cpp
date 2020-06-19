#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
int main() {
	int n, k;
	cin >> n >> k;
	int cnt = 0;
	vector<bool> arr(n + 1, false);
	for (int i = 2; i <=n; i++) {
		for (int j = i; j <=n; j += i) {
			if (!arr[j]) {
				arr[j] = true;
				cnt++;
			}
			if (cnt == k) {
				cout << j << endl;
				return 0;
			} 
		}
	}
}