#include<iostream>
#include<algorithm>
using namespace std;
int info[500];
int main() {
	int n, m;
	cin >> n >> m;
	int left = 0,right=0,sum=0;
	for (int j = 0; j < m; j++) {
		cin >> info[j];
	}
	for (int cur = 1; cur < m - 1; cur++) {
		//왼쪽
		left = info[cur];
		right = info[cur];
		for (int le = cur-1; le>=0 ; le--) {
			if (info[le] > left) {
				left = info[le];
			}
		}
		for (int ri = cur + 1; ri < m; ri++) {
			if (info[ri] >= left) {
				right = info[ri];
				break;
			}
			else {
				right = max(right, info[ri]);
			}
		}
		int temp = min(right, left);
		sum += temp - info[cur];
	}
	cout << sum;
}
/*
양 옆에 더 높은 칸이 존재 해야한다.
그 중 더 낮은 값에서 현재 높이를 빼주면 된다.
for 1 ~ w-2포함
	//왼쪽
	for 0~cur-1포함
		if cur<왼쪽
			left = 왼쪽
	//오른쪽
	for cur~w-1포함
		fi cur<오른쪽
			right = 오른쪽
	if left==0 right ==0 continue
	mx = right,left
	sum+=mx-cur
	left = 0
	right = 0
*/