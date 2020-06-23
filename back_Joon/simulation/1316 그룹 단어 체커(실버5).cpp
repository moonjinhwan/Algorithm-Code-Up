#include<iostream>
#include<vector>
using namespace std;
int main() {
	int n;
	cin >> n;
	int gr = 0;
	while(n--)
	{
		string s;
		cin >> s;
		bool flag = true;
		vector<int> arr(26, 0);
		for (int i = 0; i < s.size(); i++)
		{
			int tmp = s[i] - 'a';
			if (arr[tmp] == 0) {
				arr[tmp]++;
			}
			else if (arr[tmp] != 0 && s[i - 1] - 'a' == tmp) {
				arr[tmp]++;
			}
			else {
				flag = false;
			//	cout << i<<'\n';
				break;
			}
		}
		if (flag)
		{
			gr++;
		}
	}
	printf("%d", gr);
}