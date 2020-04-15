#include<iostream>
using namespace std;
int main() {
	int s; cin >> s;
	string n; cin >> n;
	for (int h = 0; h < 2*s + 3; h++) {
		for (int i = 0; i < n.size(); i++) {
			if (h == 0) {//맨위
				if (n[i] == '2' || n[i] == '3' || n[i] == '7' || n[i] == '5' || n[i] == '6' || n[i] == '8' || n[i] == '9' || n[i] == '0') {
					cout << ' ';
					for (int j = 0; j < s; j++) cout << '-';
					cout << ' ';
				}
				else {
					for (int j = 0; j < s + 2; j++) cout << ' ';
				}
				cout << ' ';
			}
			else if(1<=h && h<=s){//중간 위
				if (n[i] == '1' || n[i] == '2'|| n[i] == '3' || n[i] == '7') {
					for (int j = 0; j < s + 1; j++) cout << ' ';
					cout << '|';
				}
				else if (n[i] == '5' || n[i] == '6') {
					cout << '|';
					for (int j = 0; j < s + 1; j++) cout << ' ';
				}
				else if (n[i] == '4' || n[i] == '8' || n[i] == '9' || n[i] == '0') {
					cout << '|';
					for (int j = 0; j < s; j++) cout << ' ';
					cout << '|';
				}
				cout << ' ';
			}
			else if (h == s + 1) {//중간
				if (n[i] == '1' || n[i] == '7' || n[i] == '0') {
					
					for (int j = 0; j < s + 2; j++) cout << ' ';
				}
				else {
					cout << ' ';
					for (int j = 0; j < s; j++) cout << '-';
					cout << ' ';
				}
				cout << ' ';
			}
			else if (h > s + 1 && h < 2 * s + 2) {//중간 밑
				if (n[i] == '1' || n[i] == '3' || n[i] == '4' || n[i] == '5' || n[i] == '7' || n[i] == '9') {
					for (int j = 0; j < s + 1; j++) cout << ' ';
					cout << '|';
				}
				else if (n[i] == '2') {
					cout << '|';
					for (int j = 0; j < s + 1; j++) cout << ' ';
				}
				else if(n[i] == '6' || n[i] == '8' || n[i] == '0'){
					cout << '|';
					for (int j = 0; j < s; j++) cout << ' ';
					cout << '|';
				}
				cout <<' ';
			}
			else if (h == (2 * s + 2)) {//밑
				if (n[i] == '1' || n[i] == '4' || n[i] == '7') {
					for (int j = 0; j < s + 2; j++) cout << ' ';
				}
				else {
					cout << ' ';
					for (int j = 0; j < s; j++) cout << '-';
					cout << ' ';
				}
				cout << ' ';
			}
		}
		cout << endl;
	}
}