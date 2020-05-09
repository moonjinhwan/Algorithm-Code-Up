#include<iostream>
#include<string>
#include<vector>
using namespace std;

string solution(string number, int k) {
	int st = 0;
	string ans;
	for (int i = 0; i < number.size() - k; i++) {
		int maxx = number[st];
		int temp=st;
		for (int j = st; j <= i + k; j++) {
			if (maxx < number[j]) {
				maxx = number[j];
				temp = j;
			}
		}
		st = temp+1;
		ans += maxx;
	}
	return ans;
}
int main() {
	string number = "1231234";
	int k = 3;
	solution(number, k);
}
/*
FOR 비교 시작할 수 있는 index
	최대값
	시작값
	FOR 시작값 ~ 탐색범위
		IF 최대값 < number
			최대값 갱신
			시작값 갱신
	답 += 최대값
*/