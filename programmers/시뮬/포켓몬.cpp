#include<iostream>
#include<vector>
#include<set>
using namespace std;
int solution(vector<int> nums) {
	int ans = -1;
	set<int> s;
	for (int i = 0; i < nums.size(); i++) {
		s.insert(nums[i]);
	}
	int len = s.size();
	if (len <= nums.size() / 2) {
		ans = len;
	}
	else {
		ans = nums.size() / 2;
	}
	//cout << ans;
	return ans;
}
int main() {
	vector<int> nums = { 3,1,2,3 };
	solution(nums);
}