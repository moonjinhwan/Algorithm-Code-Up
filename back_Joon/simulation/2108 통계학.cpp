#include<iostream>
#include<algorithm>
#include<cmath>
#include<vector>
using namespace std;
int a[2][4001];
int n;
vector<int> v,v2;
void init() {

	cin >> n;
	for (int i = 0; i < n; i++) {
		int t;
		cin >> t;
		if (t < 0) {
			a[0][abs(t)]++;
		}
		else if(t>=0){
			a[1][abs(t)]++;
		}
	}
}
void go() {
	double fir = 0;
	int sec,thr,four;
	int thrmax = 0;
	double sum = 0;
	int fmax = -4000;
	int fmin = 4000;
	for (int i = 4000; i >= 1; i--) {
		if (a[0][i] != 0) {
			for (int j = 0; j < a[0][i]; j++) {
				sum +=  -i;
				v.push_back(-i);
			}
			if (thrmax < a[0][i])
				thrmax = a[0][i];
			if (fmax < -i) {
				fmax = -i;
			}
			if (fmin > -i) {
				fmin = -i;
			}
		}
	}
	for (int i = 0; i <4001; i++) {
		if (a[1][i] != 0) {
			for (int j = 0; j < a[1][i]; j++) {
				sum += i;
				v.push_back(i);
			}
			if (thrmax < a[1][i])
				thrmax = a[1][i];
			if (fmax < i) {
				fmax = i;
			}
			if (fmin > i) {
				fmin = i;
			}
		}
	}
	for (int i = 4000; i >= 1; i--) {
		if (thrmax == a[0][i])
			v2.push_back(-i);
	}
	for (int i = 0; i < 4001; i++) {
		if (thrmax == a[1][i])
			v2.push_back(i);
	}
	sort(v.begin(), v.end());
	fir = sum / double(n);
	sec = v[n / 2];
	if (v2.size() > 1) {
		thr = v2[1];
	}
	else {
		thr = v2[0];
	}
	four = fmax - fmin;
	printf("%.0f\n", fir);
	printf("%d\n%d\n%d\n",sec, thr, four); 
}
int main() {
	init();
	go();
}