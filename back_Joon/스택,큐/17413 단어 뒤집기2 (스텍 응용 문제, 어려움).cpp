/*
tag�ȿ� �ִ��� ���� -> ���ÿ� �ִ´� -> ���� ������ ���δ� ��
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