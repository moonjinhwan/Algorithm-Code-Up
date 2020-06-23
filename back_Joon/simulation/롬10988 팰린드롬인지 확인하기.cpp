#include<iostream>

using namespace std;
int main() {
	string s;
	cin >> s;
	int mid = s.size()/2;
	bool flag=true;
	if (s.size() % 2==1) {
		for (int r = mid + 1, l = mid - 1; r < s.size(); l--, r++)
		{
			if (s[r] != s[l]) {
				flag = false;
				break;
			}
		}
	}
	else {
		for (int r = mid, l = mid - 1; r < s.size(); l--, r++)
		{
			if (s[r] != s[l]) {
				flag = false;
				break;
			}
		}
	}
	if (flag) cout << 1;
	else cout << 0;
}
/*
for 중간-1, 중간+1
	if 같은지 확인

*/