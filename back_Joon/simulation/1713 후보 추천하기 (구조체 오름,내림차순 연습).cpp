#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
struct INFO {
	int time;
	int type;
	int up;
};
INFO info;
bool cmp(INFO a, INFO b) {
	if (a.up == b.up) {
		return a.time < b.time;
	}
	return a.up > b.up;
}
bool resCmp(INFO a, INFO b) {
	return a.type < b.type;
}
int main() {
	int N;
	cin >> N;
	vector<INFO> v(N);
	int num;
	cin >> num;
	for (int i = 0; i < num; i++) {
		info.time = 0;
		cin>>info.type;
		info.up = 1;
		if (v.size() != N) {
			v.push_back(info);
		}
		else {
			bool tag = false;
			for (int i = 0; i < N; i++) {
				if (v[i].type == info.type) {
					v[i].up++;
					tag = true;
				}
			}
			if (!tag) {
				v[N - 1] = info;
			}
		}
		for (int i = 0; i < v.size(); i++) {
			v[i].time++;
		}
		sort(v.begin(), v.end(), cmp);
	}
	sort(v.begin(), v.end(), resCmp);
	for (auto p : v)
		cout << p.type<<' ';
}
/*
struct info
	time, up, type
vector v
for n
	info
	if v.size != n
		v.push
	else
		for size
			if	v[i].type == info.type
				v[i].up++;
				tag=true
		if !tag
			v[size-1] = info
	sort
for
	cout
*/