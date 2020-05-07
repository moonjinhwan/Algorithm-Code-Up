#include<iostream>
#include<string>
using namespace std;
string cmd1[6] = { "CM", "CD", "XC", "XL", "IX", "IV" };
char cmd2[7] = { 'M', 'D', 'C', 'L', 'X', 'V', 'I' };
int num1[6] = { 900,400,90,40,9,4 };
int num2[7] = { 1000,500,100,50,10,5,1 };
int num3[13] = { 1000,900,500,400,100,90,50,40,10,9,5,4,1 };
string cmd3[13] = { "M","CM", "D","CD", "C","XC", "L","XL", "X","IX", "V","IV","I" };
int main() {
	string s[2];
	cin >> s[0] >> s[1];
	int res = 0;
	for (int i = 0; i < 2; i++) {//입력값

		for (int  j = 0; j < s[i].size(); j++){//입력값 한개
			bool tag = false;
			for (int k = 0; k < 6; k++) {//2
				if (s[i].substr(j, 2) == cmd1[k]) {
					res += num1[k];
					j++;
					tag = true;
					break;
				}
			}
			if (tag) continue;
			for (int k = 0; k < 7; k++) {
				if (s[i][j] == cmd2[k]) {
					res += num2[k];
					break;
				}
			}
		}
	}
	cout << res<<endl;
	string ans;
	while (1) {//숫자 -> 로마 변환
		if (res == 0) break;
		for (int i = 0; i < 13; i++) {
			if (res / num3[i] != 0) {
				ans += cmd3[i];
				res -= num3[i];
				break;
			}
		}
	}
	cout << ans;
}