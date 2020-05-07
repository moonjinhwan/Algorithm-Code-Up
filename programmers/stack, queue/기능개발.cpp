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
7 70 45 나누기 
7 3 9
1) 들어갈 값이 maxx보다 크면 size를 반환한다
2) 몫의 배열을 구한다
3) stack에 넣어가며 확인한다

for progress.size
    temp = 100-pro / speed == 0
    if temp ==0
        v.push tmp
    else
        v.push tmp+1
maxx = v[0]
for tmp.size
    if maxx < v[i]
        다 빼고 answer에 사이즈 추가
        maxx = v[i]
    else
        스택에 넣기


*/