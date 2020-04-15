/*
https://sorious77.tistory.com/m/73
ť�� �� ���� ���ͷθ� Ǭ �ڵ�. ��û ������
*/
#include<iostream>
#include<string>
#include<queue>
using namespace std;
int main() {
	int T;
	cin >> T;
	for (int t = 0; t < T; t++) {
		string cmd; cin >> cmd;
		int num; cin >> num;
		string str; cin >> str;
		deque<int> dq;
		string tmp;
		bool terminate = false;
		//�迭�� ��Ҹ� �����Ѵ�
		for (int i = 1; i < str.size(); i++) {
			if (str[i] != ',' && str[i]!=']') {
				tmp += str[i];
			}
			else if(str[i]==','|| str[i]==']'){
				if (tmp == "") break;
				dq.push_back(stoi(tmp));
				tmp = "";
			}
		}
		//��ɾ� ó���Ѵ�
		bool left = true;
		for (int i = 0; i < cmd.size(); i++) {
			if (cmd[i] == 'R') {
				if (left)
					left = false;
				else
					left = true;
			}
			else if(cmd[i]=='D') {
				if (dq.empty()) {
					cout << "error" << '\n';
					terminate = true;
					break;
				}
				if (left)
					dq.pop_front();
				else
					dq.pop_back();
			}
		}
		if (terminate) continue;
		//����� �Ѵ�
		if (dq.empty()) {
			cout << "[]" << '\n';
		}
		else {
			cout << '[';
			int size = dq.size();
			for (int i = 0; i < size;i++) {
				if (left) {
					cout << dq.front();
					dq.pop_front();
				}
				else {
					cout << dq.back();
					dq.pop_back();
				}
				if (i != size-1) {
					cout << ',';
				}
				
			}
			cout << ']'<<'\n';
		}
	}
}
