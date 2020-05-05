#include<iostream>
using namespace std;
string s;
bool con1(string s) {
	for (int i = 0; i < s.size(); i++) {
		if (s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u') {
			return true;
		}
	}
	return false;
}
bool con2(string s) {
	if (s.size() < 3) return true;
	for (int i = 0; i < s.size()-2; i++) {
		int mo = 0,ja=0;
		for (int j = i; j <i+3; j++) {
			if (s[j] == 'a' || s[j] == 'e' || s[j] == 'i' || s[j] == 'o' || s[j] == 'u') {
				mo++;
			}
			else {
				ja++;
			}
		}
		if (mo == 3 || ja == 3) {
			return false;
		}
	}
	return true;
}
bool con3(string s) {
	for (int i = 0; i < s.size()-1; i++) {
		if (s[i] == s[i+1]) {
			if ((s[i] == 'e' && s[i + 1] == 'e') || (s[i] == 'o' && s[i + 1] == 'o')) {
				continue;
			}
			else {
				return false;
			}
		}
	}
	return true;
}
int main() {
	while (1) {
		string s;
		cin >> s;
		if (s == "end") break;
		bool c1,c2,c3;
		c1 = con1(s);
		c2 = con2(s);
		c3 = con3(s);
		//cout << c1 << c2 << c3 << endl;
		if (c1 && c2 && c3) {
			cout <<'<' <<s<<'>';
			printf(" is acceptable.\n");
		}
		else {
			cout << '<' << s << '>';
			printf(" is not acceptable.\n", s);
		}
	}
}