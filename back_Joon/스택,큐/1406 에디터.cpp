#include<iostream>
#include<stack>
#include<string>
using namespace std;
void solve() {
	string s;
	cin >> s;
	int n;
	cin >> n;
	stack<int> st;
	for (int i = 0; i < n; i++) {
		char cmd;
		cin >> cmd;
		if (cmd == 'P') {
			char temp; cin >> temp;
			s.push_back(temp);
		}
		else if(cmd=='L'){
			if (s.size() != 0) {
				st.push(s.back());
				s.pop_back();
			}
		}
		else if (cmd == 'D') {
			if (!st.empty()) {
				s.push_back(st.top());
				st.pop();
			}
		}
		else if(cmd=='B'){
			if (s.size() != 0) {
				s.pop_back();
			}
		}
	}
	while (!st.empty()) {
		s.push_back(st.top());
		st.pop();
	}
	for (int i = 0; i < s.size(); i++) {
		cout << s[i];
	}
}
int main() {
	solve();
}
/*
 
*/