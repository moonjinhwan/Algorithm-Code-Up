/*
tag안에 있는지 구분 -> 스택에 넣는다 -> 공백 만나면 전부다 팝
*/
#include<iostream>
#include<stack>
#include<string>
using namespace std;
int main() {
	string s;
	getline(cin, s);
	bool tag = false;
	stack<char> stack;
	for (int i = 0; i < s.size(); i++) {
		if (s[i] == '<') {
			tag = true;
			while (!stack.empty()) {
				cout << stack.top();
				stack.pop();
			}
			cout << '<';
			continue;
		}
		else if (s[i] == '>') {
			tag = false;
			cout << '>';
			continue;
		}
		if (tag) {
			cout << s[i];
		}
		else {
			if (s[i] == ' ') {
				while (!stack.empty()) {
					cout << stack.top();
					stack.pop();
				}
				cout << ' ';
			}
			else {
				stack.push(s[i]);
			}
		}
	}
	while (!stack.empty()) {
		cout << stack.top();
		stack.pop();
	}
}