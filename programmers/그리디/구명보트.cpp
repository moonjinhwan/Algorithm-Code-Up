#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
bool cmp(int a, int b) {
	return a > b;
}
int solution(vector<int> p, int l) {
	sort(p.begin(), p.end(),cmp);
	int ans=0;
	int left = 0;
	int right = p.size() - 1;
	while (left <= right) {
		if (left == right) {
			ans++;
			break;
		}
		if (p[left] + p[right] > l) {
			left++;
		}
		else {
			left++;
			right--;
		}
		ans++;
	}
	cout << ans;
	return ans;
}
int main() {
	solution({ 70,50,80 }, 100);
}
/*
정렬
left = 0 right =size-1
while 1
	IF left == right
		cnt++
		break
	IF left데이터 + right데이터 > 제한
		left++
	else
		left++
		right--
	cnt++
*/