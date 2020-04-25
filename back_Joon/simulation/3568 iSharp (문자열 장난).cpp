#include<iostream>
#include<vector>
using namespace std;
string type;
vector<pair<string, string>> v;
void init() {
	cin >> type;
	bool turnOff = true;
	while (turnOff) {
		string name="", cmd="";
		string temp;
		cin >> temp;
		for (int i = 0; i < temp.size(); i++) {
			if ((temp[i] >= 'a' && temp[i] <= 'z') ||
				(temp[i] >= 'A' && temp[i] <= 'Z')) {
				name += temp[i];
			}
			else if (temp[i] == '&' || temp[i] == '[' || temp[i] == ']'
				|| temp[i] == '*') {
				cmd += temp[i];
			}
			else if (temp[i] == ';') {
				turnOff = false;
				break;
			}
		}
		v.push_back({ name, cmd });
	}
}
void print() {
	for (int i = 0; i < v.size(); i++) {
		cout << type;
		for (int j = v[i].second.size() - 1; j >= 0; j--) {
			if (v[i].second[j] == ']') { 
				cout << '['; 
				continue;
			}
			else if (v[i].second[j] == '[') { 
				cout << ']'; 
				continue;
			}
			cout << v[i].second[j];
		}
		cout << ' '<<v[i].first<<';'<<endl;
	}
}
int main() {
	init();
	print();
}