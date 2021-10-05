/*
끝 , 시작 작은 순으로 정렬
end
for i
	if end <= list[i].start 
		end = list[i].end
		answer++
*/
#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
struct LIST {
	int star, en;
};
vector<LIST> v;
bool cmp(LIST a, LIST b) {
	if (a.en == b.en) {
		return a.star < b.star;
	}
	return a.en < b.en;
}
int main() {
	int N;
	cin >> N;
	for (int i = 0; i < N; i++) {
		int a, b;
		cin >> a >> b;
		v.push_back({ a,b });
	}
	sort(v.begin(), v.end(), cmp);
	int en = v[0].en;
	int answer = 1;
	for (int i = 1; i < N; i++) {
		//printf("%d %d\n", v[i].star, v[i].en);
		if (en <= v[i].star) {
			en = v[i].en;
			answer++;
		}
	}
	cout << answer;
}