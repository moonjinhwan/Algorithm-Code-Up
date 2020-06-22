#include<iostream>
#include<algorithm>
using namespace std;
bool use[16];
char arr[16];
char res[16];
int l, c;
bool check() {
	int mo=0,ja=0;
	for (int i = 0; i < l; i++)
	{
		if (res[i] == 'a' || res[i] == 'i' || res[i] == 'u' || res[i] == 'e' || res[i] == 'o') {
			mo++;
		}
		else {
			ja++;
		}
	}
	if (mo >= 1 && ja >= 2) {
		return true;
	}
	else
		return false;
}

void go(int idx,int st) {
	if (idx == l) {
		if (check()) {
			for (int i = 0; i < l; i++)
			{
				cout << res[i];
			}
			cout << '\n';
		}
	}
	for (int i = st; i < c; i++)
	{
		if (use[i]) continue;
		use[i] = true;
		res[idx] = arr[i];
		go(idx + 1, i+1);
		use[i] = false;
	}
}
int main() {
	cin >> l >> c;
	for (int i = 0; i < c; i++)
	{
		cin >> arr[i];
	}
	sort(arr, arr + c);
	go(0,0);
	/*for (int i = 0; i < c; i++)
	{
		cout << arr[i];
	}*/
}