#include<iostream>
using namespace std;
int main() {
	int L, P, V;
	int idx = 1;
	while (1) {
		cin >> L >> P >> V;
		if (L == 0 && P == 0 && V == 0)
			break;
		int mok = V / P;
		int na = V % P;
		int result = mok * L;
		if (na <= L) {
			result += na;
		}
		else {
			result += L;
		}
		printf("Case %d: %d\n",idx, result );
		idx++;
	}
}