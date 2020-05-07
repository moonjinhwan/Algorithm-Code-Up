#include <string>
#include <vector>
#include<iostream>
#include<algorithm>
using namespace std;

bool cmp(string a, string b) {
    return a + b > b + a;
}
string solution(vector<int> v) {
    string answer = "";
    vector<string> s;
    int cnt = 0;
    for (int i = 0; i < v.size(); i++) {
        if (v[i] == 0) cnt++;
        s.push_back(to_string(v[i]));
    }
    if (cnt == v.size()) {
        answer = "0";
        return answer;
    }
    sort(s.begin(), s.end(), cmp);
    for (auto p : s) {
        answer += p;
    }
    return answer;
}
int main() {
    vector<int> v = {0,0,0,0,0 };
    solution(v);
}
/*
정렬
순열 구하기

*/