#include<iostream>
#include<string>
#include<vector>
#include<algorithm>
using namespace std;
int n, m,t;
string s1,s2;

vector<pair<char, int>> ant; // 0 ¿À¸¥ÂÊ, 1¿ÞÂÊ
void init() {
	cin >> n >> m;
	cin >> s1 >> s2>>t;
	reverse(s1.begin(), s1.end());
	for (int i = 0; i < s1.size(); i++) {
		ant.push_back({ s1[i], 0 });
	}
	for (int i = 0; i < s2.size(); i++) {
		ant.push_back({ s2[i], 1 });
	}
}
void go() {
	for (int k = 0; k < t; k++) {
		for (int i = 0; i < ant.size() - 1; i++) {
			if (ant[i].second==0 && ant[i].second != ant[i + 1].second) {
				swap(ant[i], ant[i + 1]);
				i++;
			}
		}
		/*cout << "==============\n";
		for (int i = 0; i < ant.size(); i++) {
			printf("%c %d\n", ant[i].first, ant[i].second);
		}*/
	}
}
void print() {
	for (int i = 0; i < ant.size(); i++) {
		cout << ant[i].first;
	}
}
int main() {
	init();
	go();
	print();
}