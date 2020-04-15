/*
1. �ϵ��ڵ� �ϸ� �ȵȴ�.
2. (()()) ���� ��� (2+2) * 2�� �ƴ� (2*2) + (2*2)�� ����Ѵ�
	�̸� ���� tmp�� res ������ ����Ѵ�
3. �Ұ����� ��츦 �����Ѵ�
	1) [())  ->  ¦�� ���� ���� ���
	2) [  ->  �ݺ��� �����µ� ������ �� �� �� ���
	3) ]  ->  ���ÿ� �ƹ��͵� ���� ���

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
for Ȯ��
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
