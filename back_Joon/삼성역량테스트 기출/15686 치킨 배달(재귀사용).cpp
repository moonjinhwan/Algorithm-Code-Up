#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
int n, m;
int map[50][50];
vector<pair<int, int>> shop;
vector<pair<int, int>> pickShop;
vector<pair<int, int>> house;
int answer=987654321;
void countDist() {
	int res=0;
	for (int i = 0; i < house.size(); i++) {
		int tmp = 987654321;
		for (int j = 0; j < pickShop.size(); j++) {
			int dist=abs(house[i].first - pickShop[j].first) +
				abs(house[i].second - pickShop[j].second);
			tmp=min(dist, tmp);
		}
		res += tmp;
	}
	answer=min(res, answer);
}
void selectShop(int idx) {
	if (pickShop.size() == m) {
		countDist();
		return;
	}
	if (idx == shop.size()) {
		return;
	}
	pickShop.push_back({ shop[idx].first, shop[idx].second });
	selectShop(idx + 1);
	pickShop.pop_back();
	selectShop(idx + 1);
}
int main() {
	scanf("%d%d", &n, &m);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			scanf("%d", &map[i][j]);
			if (map[i][j] == 2)
				shop.push_back({ i,j });
			else if (map[i][j] == 1)
				house.push_back({ i,j });
		}
	}
	selectShop(0);
	cout << answer;
}
/*
재귀로 치킨집 구하고, 집에서 치킨집 까지 거리를 구함.
countDist
	for house
		for shop
			dist min dist,shop i,j -house i,j
		sum+=dist
selectShop idx
	if idx == 3 
		countDist
		return
	push 
	selectShop idx+1
	pop
*/