#include <string>
#include <vector>
#include<iostream>
#include<algorithm>
using namespace std;

int solution(vector<int> c) {
	sort(c.begin(), c.end());
	int answer = 0;
	
	for (int i = c.size(); i>=0; i--)//h편
	{
		int p=0, m=0;
		for (int j = 0; j < c.size(); j++)//논문 탐색
		{
			if (i <= c[j]) {//h번 이상 인용 갯수 확인
				p++;
			}
			else if (i >= c[j]) {//h번 이하 인용 갯수 확인
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