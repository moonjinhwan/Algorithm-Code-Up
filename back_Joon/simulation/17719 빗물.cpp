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
		//����
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
�� ���� �� ���� ĭ�� ���� �ؾ��Ѵ�.
�� �� �� ���� ������ ���� ���̸� ���ָ� �ȴ�.
for 1 ~ w-2����
	//����
	for 0~cur-1����
		if cur<����
			left = ����
	//������
	for cur~w-1����
		fi cur<������
			right = ������
	if left==0 right ==0 continue
	mx = right,left
	sum+=mx-cur
	left = 0
	right = 0
*/