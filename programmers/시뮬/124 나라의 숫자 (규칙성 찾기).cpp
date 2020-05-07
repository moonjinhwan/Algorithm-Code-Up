#include <string>
#include <vector>

using namespace std;

string solution(int n) {
	string s = "";
	while (1) {
		if (n == 0) break;
		if (n % 3 == 0) {
			s.insert(0, "4");
			n /= 3;
			n--;
		}
		else {
			s.insert(0, to_string(n % 3));
			n /= 3;
		}
	}
	return s;
}
/*
10 -> 3-> 0   41
9 -> 3*3+0  24
8-> 3*2 + 2  22
7 -> 3*2 + 1  21
6 -> 3*2 +0  (2-1)4
3) �������� 1->1 2->2 0->4
���� �� �տ� �ִ´�
3���� ���� ������ 0�� ���
	
�ƴ� ���
�׳� ��Ģ�� ã�� ����
*/