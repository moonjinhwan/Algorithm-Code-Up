#include<iostream>
#include<queue>
using namespace std;
int main() {
	int n, w, l;
	cin >> n >> w >> l;//Ʈ����, �ٸ�����, ����
	queue<int> q;
	int count = 0;
	int weightSum = 0;
	while (n--) {
		int input;
		cin >> input;
		while (true) {
			if (q.empty()) {
				q.push(input);
				weightSum += input;
				count++;
				break;
			}
			else if (q.size() == w) {
				weightSum -= q.front();
				q.pop();
			}
			else {
				if (weightSum + input > l) {
					q.push(0);
					count++;
				}
				else {//���� ���� ����
					q.push(input);
					count++;
					weightSum += input;
					break;
				}
			}
		}
	}
	cout<<count+w;
}