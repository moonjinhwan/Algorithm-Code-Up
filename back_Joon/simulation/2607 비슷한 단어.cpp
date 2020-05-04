#include<iostream>
#include<cstring>
#include<algorithm>
using namespace std;
int info[26];
int input[26];
int ans;
int main() {
	int n;
	cin >> n;
	string s;
	cin >> s;
	for (int i = 0; i < s.size();i++) {
		info[s[i] - 'A']++;
	}
	n--;
	while (n--) {
		int plus = 0;
		int min = 0;
		int chg = 0;
		memset(input, 0, sizeof(input));
		cin >> s;
		for (int i = 0; i < s.size(); i++) {
			input[s[i] - 'A']++;
		}
		int cnt = 0;
		bool tag = false;
		for (int i = 0; i < 26; i++)
		{
			if (abs(info[i] - input[i]) > 1) {
				tag = true;
				break;
			}
			else if (info[i] > input[i]) {
				min++;
			}
			else if (info[i] < input[i]) {
				plus++;
			}
			if (min > 1 || plus > 1) {
				tag = true;
				break;
			}
		}
		if (tag) continue;
		ans++;
	}

	printf("%d", ans);
}