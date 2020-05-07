#include<algorithm>
#include<iostream>
using namespace std;

long long solution(int w, int h)
{
	long long answer;
	int maxx = 0;
	for (int i = 1; i <= min(w, h); i++) {
		if (w % i == 0 && h % i == 0) {
			maxx = max(i, maxx);
		}
	}
	long long res = w / maxx + h / maxx - 1;
	answer = (long long)w * h - res * maxx;
	//cout << answer;
	return answer;
}