/*
for (int i = 0; i <= s.size(); ++i){
		if (s[i] == '+' || s[i] == '-' || s[i] == '\0'){
			if (m) {
				num -= stoi(tmp);
			}
			else {
				num += stoi(tmp);
			}

			if (s[i] == '-') {
				m = 1;
			}

			tmp = "";
			continue;
		}

		tmp += s[i];
	}
*/
#include<iostream>
#include<string>
using namespace std;
int main() {
	bool tag=false; //-가 나오는지 유무
	string s;
	cin >> s;
	int sum = 0;
	int plus = 0;
	int minus = 0;
	for (int i = 0; i < s.size(); i++) {
		if (s[i] == '+') {
			plus += sum;
			sum = 0;
		}
		else if (s[i] == '-') {
			tag = true;
			plus += sum;
			sum = 0;
			for (int j = i + 1; j < s.size(); j++) {
				if (s[j] == '-' || s[j] == '+') {
					minus += sum;
					sum = 0;
				}
				else {
					sum *= 10;
					sum += (s[j] - '0');
				}
			}
			break;
		}
		else {
			sum *= 10;
			sum += (s[i] - '0');
		}
	}
	if (tag) {
		minus += sum;
	}
	else {
		plus += sum;
	}
	cout << -1 * minus + plus;
}