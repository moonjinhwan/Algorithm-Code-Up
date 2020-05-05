#include<iostream>
#include<string>
using namespace std;
string s[1000];
int main() {
	int n;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> s[i];
	}
	int len = s[0].size();
	int idx = 0;
	while (1) {
		bool tag = true;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (len - idx >= 0) {
					string temp1 = s[i].substr(len-1 - idx, len);
					string temp2 = s[j].substr(len-1 - idx, len);
					
					if (temp1 == temp2) {
						tag = false;
						break;
					}
				}
			}
			if (!tag) break;
		}
		if (tag) break;
		idx++;
	}

	cout << idx+1;
}