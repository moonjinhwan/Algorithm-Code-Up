#include <string>
#include <vector>
#include<stack>
#include<iostream>
using namespace std;

vector<int> solution(vector<int> p, vector<int> s) {
    vector<int> ans;
    vector<int> day;
    for (int i = 0; i < p.size(); i++) {
        int tmp = 100 - p[i];
        if (tmp%s[i] == 0) {
            day.push_back(tmp / s[i]);
        }
        else {
            day.push_back(tmp / s[i]+1);
        }
    }
    int maxx = day[0];
    stack<int> st;
    st.push(day[0]);
    for (int i = 1; i < day.size(); i++) {
        if (maxx < day[i]) {
            ans.push_back(st.size());
            while (!st.empty()) {
                st.pop();
            }
            maxx = day[i];
            st.push(day[i]);
        }
        else {
            st.push(day[i]);
        }
    }
    if (!st.empty()) {
        ans.push_back(st.size());
    }
    /*for (auto p : ans) {
        cout << p;
    }*/
    return ans;
}
int main() {
    vector<int> p = { 93,30,55 };
    vector<int> s = { 1,30,5 };
    solution(p, s);
}
/*
7 70 45 ������ 
7 3 9
1) �� ���� maxx���� ũ�� size�� ��ȯ�Ѵ�
2) ���� �迭�� ���Ѵ�
3) stack�� �־�� Ȯ���Ѵ�

for progress.size
    temp = 100-pro / speed == 0
    if temp ==0
        v.push tmp
    else
        v.push tmp+1
maxx = v[0]
for tmp.size
    if maxx < v[i]
        �� ���� answer�� ������ �߰�
        maxx = v[i]
    else
        ���ÿ� �ֱ�


*/