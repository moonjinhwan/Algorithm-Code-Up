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