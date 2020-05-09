#include<iostream>
#include<vector>
#include<map>
using namespace std;
vector<int> solution(int n, vector<string> w) {
	map<string, int> m;
	vector<int> ans(2,0);
	int tag = false;
	for (int i = 0; i < w.size(); i++) {
		m[w[i]]++;
		if (m[w[i]] == 2) {
			int num = i % n + 1;
			int turn = i / n + 1;
			ans[0] = num; ans[1] = turn;
			tag = true;
			break;
		}
	}
	if (tag) {
		//cout << ans[0] << ans[1];
		return ans;
	}
	for (int i = 1; i < w.size(); i++) {
		int preLen = w[i - 1].size();
		if (w[i][0] != w[i - 1][preLen-1]) {
			int num = i % n + 1;
			int turn = i / n + 1;
			ans[0] = num; ans[1] = turn;
			break;
		}
	}
	//cout << ans[0] << ans[1];
	return ans;
}
int main() {
	int n=2;
	vector<string> words = { {"hello", "one", "even", "never", "now", "world", "draw"} };
	solution(n, words);
}
/*
FOR i<size-1
	IF ����� �ܾ����� �� use["�ܾ�"] == 2 ��
	IF ���糡 ����ù ��
	index = 4
	n=2
	ó���� ��ȣ
	�ι�°�� ���° ��
*/