/*
1. 하드코딩 하면 안된다.
2. (()()) 같은 경우 (2+2) * 2가 아닌 (2*2) + (2*2)로 계산한다
	이를 위해 tmp와 res 변수를 써야한다
3. 불가능한 경우를 생각한다
	1) [())  ->  짝이 맞지 않은 경우
	2) [  ->  반복이 끝났는데 스택이 다 안 빈 경우
	3) ]  ->  스택에 아무것도 없는 경우

*/

#include<iostream>
#include<stack>
using namespace std;
int main() {
	string s;
	cin >> s;
	stack<char> stk;
	int tmp=1,res=0;
	bool tag = true;
	for (int i = 0; i < s.size(); i++) {
		if (s[i] == '(') {
			tmp *= 2;
			stk.push('(');
		}
		else if (s[i] == '[') {
			tmp *= 3;
			stk.push('[');
		}
		else if (s[i] == ')') {
			if (stk.empty() || stk.top()=='[') {
				tag = false;
				break;
			}
			if (s[i - 1] == '(') res += tmp;
			tmp /= 2;
			stk.pop();
		}
		else if (s[i] == ']') {
			if (stk.empty() || stk.top() == '(') {
				tag = false;
				break;
			}
			if (s[i - 1] == '[') res += tmp;
			tmp /= 3;
			stk.pop();
		}
	}
	if (!stk.empty() || !tag) {
		cout << 0;
		return 0;
	}
	cout << res;
}
/*
for 확인
	s == (
		tmp*=2
		push
	s == [
		tmp *=3
		push
	s == )
		if(stk.empty()) 
			tag=false
			break;
		if s [i-1] == (
			res +=tmp
		tmp/=2
		pop
	s == ]
		if(stk.empty()) 
			tag=false
			break;
		if s[i-1] == [
			res+=tmp
		tmp/=3
		pop
if(!empty || !tag)
	cout 0
*/
