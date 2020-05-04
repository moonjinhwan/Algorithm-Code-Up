//4칸,6칸,8칸 부터 계속 새로운 타일 만드는게 가능
#include<iostream>
using namespace std;
int d[31];
int main(){
	d[0] = 1;
	d[2] = 3;
	for (int i = 4; i <= 30; i++) {
		if (i % 2 != 0) {
			d[i] = 0;
		}
		else {
			d[i] += d[i - 2] * 3;
			for (int j = 4; j <= i; j+=2) {
				d[i] += d[i - j] * 2;
			}
		}
	}
	int t;
	cin >> t;
	cout << d[t];
}