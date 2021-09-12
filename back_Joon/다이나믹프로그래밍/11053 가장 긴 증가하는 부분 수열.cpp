#include<iostream>
#include<cstring>
#include<algorithm>
using namespace std;
int arr[1001];
int d[1001];
int main() {
	int n;
	cin >> n;
	for (int i = 1; i <= n; i++) {
		cin >> arr[i];
	}
	d[1] = 1;
	for (int i = 2; i <= n; i++) {
		d[i] = 1;
		for (int j = 1; j < i; j++) {
			if (arr[j] > arr[i] && d[j] >= d[i]) {
				d[i]++;
			}
		}
	}
	int ans = *max_element(d, d + n + 1);
	cout << ans;
}