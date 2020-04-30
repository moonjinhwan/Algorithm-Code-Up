/*
내 원래 위치 = 기억못하는 작은놈 + 기억 하는 큰놈

즉, 가장 작은 놈부터 배치하면 나 보다 작은 놈은 넘기고
기억하는 큰 놈 수 만큼 이동 하면 내 위치가 나온다.
*/
#include<iostream>
#include<cstring>
using namespace std;
int main() {
	int N;
	cin >> N;
	int input[10];
	int answer[10]={ 0, };
	for (int i = 0; i < N; i++) {
		cin >> input[i];
	}
	for (int i = 0; i < N; i++) {
		int cnt = 0;
		int left = 0;
		while(1) {
			if (answer[left]==0 && cnt == input[i]) {
				answer[left] = i + 1;
				break;
			}
			if (answer[left] == 0) {
				cnt++;
			}
			left++;
		}
	}
	for (int i = 0; i < N; i++) {
		printf("%d ", answer[i]);
	}
}