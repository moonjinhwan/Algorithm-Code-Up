#include <string>
#include <vector>
#include<iostream>
#include<algorithm>
using namespace std;

int solution(vector<int> c) {
	sort(c.begin(), c.end());
	int answer = 0;
	
	for (int i = c.size(); i>=0; i--)//h��
	{
		int p=0, m=0;
		for (int j = 0; j < c.size(); j++)//�� Ž��
		{
			if (i <= c[j]) {//h�� �̻� �ο� ���� Ȯ��
				p++;
			}
			else if (i >= c[j]) {//h�� ���� �ο� ���� Ȯ��
				m++;
			}
		}
		if (p >= i && m <= i) {
			answer = max(answer, i);
		}
	}
	//cout << answer;
	return answer;
}

int main() {
	vector<int> v(1, 0);
	v = {0};
	solution(v);
}