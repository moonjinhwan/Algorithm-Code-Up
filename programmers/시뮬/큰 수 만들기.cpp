/*
에라토스테네스의 체
재귀사용해서 3개 선택하기
FOR 2부터 s까지
	IF 방문 안해야됨
		FOR 시작점부터 배수로 증가
			방문체크
IF visit[s]방문 안했으면 소수
*/

#include<iostream>
#include<vector>
#include<cstring>
using namespace std;
int ans;
bool isCheck(int s) {
	vector<bool> visit(s + 1, false);
	for (int i = 2; i <=s; i++) {
		if (!visit[i]) {
			for (int j = i*i; j <=s; j+=i) {
				visit[j] = true;
			}
		}
	}
	if (!visit[s]) {
		return true;
	}
	return false;
}
void go(int idx,int pick ,int sum,vector<int> n) {
	if (pick == 3) {
		if (isCheck(sum)) {
			ans++;
		}
		return;
	}
	if (idx == n.size())	
		return;
	go(idx + 1, pick + 1, sum + n[idx],n);
	go(idx + 1, pick, sum,n);

}
int solution(vector<int> n) {
	go(0, 0,0,n);
	//cout << ans;
	return ans;
}
int main() {
	vector<int> n = { 1,2,3};
	solution(n);
}