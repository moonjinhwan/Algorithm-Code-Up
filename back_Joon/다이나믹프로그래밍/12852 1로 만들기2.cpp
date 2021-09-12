#include<iostream>
#include<algorithm>
using namespace std;
int dp[1000001];
int list[1000001];
int main() {
	int n;
	cin >> n;
	for (int i = 2; i <= n; i++) {
		int a = i;
		int b = i;
		int c = i;
		if (i % 3 == 0)
			a = dp[i / 3] + 1;
		if (i % 2 == 0)
			b = dp[i / 2] + 1;
		c = dp[i - 1] + 1;
		int minEle = min({ a,b,c });
		dp[i] = minEle;
		if (minEle == a) {
			list[i] = i / 3;
		}
		else if (minEle == b) {
			list[i] = i / 2;
		}
		else {
			list[i] = i - 1;
		}
	}
	int idx = n;
	printf("%d\n", dp[n]);
	printf("%d ", n);
	while (1) {
		if (list[idx] == 0)
			break;
		printf("%d ", list[idx]);
		idx = list[idx];
	}
}
/*
list
dp변수
for 2부터 n까지
	if 현재%3==0
		a = 최소연산[현재/3]+1
	if 현재%2==0
		b = 최소연산[현재/2]+1
	c = dp[cur-1]+1
	if(a<b){
		if(a<c){
			dp[cur] = a
			list = cur/3
		}else
			dp[cur] = c
			list = cur-1
	}else{
		if(b<c)
			dp[cur] =b
			list = cur/2
		else
			dp[cur] =c
			list = cur-1
	}
int idx=n
print n
while 1
	if list[idx] ==0
		break
	print list[idx]
	idx = list[idx]
*/