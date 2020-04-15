/*
https://sorious77.tistory.com/m/73
큐를 안 쓰고 벡터로만 푼 코드. 엄청 간단함
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
		//배열의 요소를 분해한다
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
		//명령어 처리한다
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
		//출력을 한다
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
