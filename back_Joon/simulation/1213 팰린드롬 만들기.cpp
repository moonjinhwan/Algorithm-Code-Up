#include<iostream>
using namespace std;
int arr[26];
char res[50];
int main() {
	string s;
	cin >> s;
	for (int i = 0; i < s.size(); i++) {
		arr[s[i] - 'A']++;
	}
	int oddCnt = 0;
	int oddIdx = 0;
	int idx = 0;
	for (int i = 0; i < 26; i++) {
		if (arr[i]!=0 && arr[i] % 2 == 0) {
			for (int j = 0; j < arr[i]/2; j++) {
				res[idx++] = i + 'A';
			}
		}
		else if(arr[i]%2==1){
			for (int j = 0; j < arr[i] / 2; j++) {
				res[idx++] = i + 'A';
			}
			oddCnt++;
			oddIdx = i;
		}
		 
	}
	if (oddCnt >= 2) {
		printf("I'm Sorry Hansoo");
		exit(0);
	}
	int temp = arr[oddIdx] - (arr[oddIdx] / 2) * 2;
	if (oddCnt == 1) {
		for (int i = 0; i < temp; i++) {//��� Ȧ�� �ֱ�
			res[idx++] = oddIdx + 'A';
		}
	}
	for (int i = 25; i>=0; i--) {
		if (arr[i] != 0 && arr[i] % 2 == 0) {
			for (int j = 0; j < arr[i] / 2; j++) {
				res[idx++] = i + 'A';
			}
		}
		else if (arr[i] % 2 == 1) {
			for (int j = 0; j < arr[i] / 2; j++) {
				res[idx++] = i + 'A';
			}
		}
	}

	//���
	for (int i = 0; i < 50; i++) {
		if (res[i] != NULL) {
			printf("%c", res[i]);
		}
	}
}
/*
Ȧ���� �ΰ� ���� �Ǵ�
���ݾ� �ִ´�
������ ���ݾ� �ִ´�
Ȧ���� �߾ӿ� ��ġ�Ѵ�
aabbc
abcba
for 26
	if arr[i] %2 ==0
		ans[idx++]= arr[i]/2
		arr[i]/=2
Ȧ���� �ֱ�
�ڿ��� ���� �ֱ�
*/