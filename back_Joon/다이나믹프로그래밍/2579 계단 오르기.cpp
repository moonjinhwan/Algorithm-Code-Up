#include<iostream>
#include<algorithm>
using namespace std;
int arr[301];
int d[301];
int main(){
	int n;
	cin >> n;
	for (int i = 1; i <= n; i++) {
		cin >> arr[i];
	}
	d[1] = arr[1];
	d[2] = arr[1] + arr[2];
	for (int i = 3; i <= n; i++) {
		d[i]= max(d[i - 3] + arr[i] + arr[i - 1], d[i-2] + arr[i]);
	}
	cout << d[n];
}
/*
마지막 전 게단을 밟은 경우
밟지 않은 경우
d[n] = d[n-3] + list[n] + list[n-1]
d[n] = d[n-2] + list[n]

d[1] = list[1]
d[2] = list[2] + list[1]
for 계단수
	
*/
