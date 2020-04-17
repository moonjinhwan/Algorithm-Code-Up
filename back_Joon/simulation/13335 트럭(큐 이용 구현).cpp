#include<iostream>
#include<queue>
using namespace std;
int main() {
	int n, w, l;
	cin >> n >> w >> l;//트럭수, 다리길이, 하중
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
				else {//무게 여유 있음
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