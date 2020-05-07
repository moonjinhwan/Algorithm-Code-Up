#include <string>
#include <vector>
#include<iostream>
#include<map>
using namespace std;

int solution(vector<vector<string>> c) {
    int answer = 1;
    map<string, int> m;
    for (int i = 0; i < c.size(); i++) {
        m[c[i][1]]++;
    }
    for (auto p : m) {
        answer *= (p.second + 1);
    }
    cout << answer - 1;
    return answer-1;
}
int main() {
    vector<vector<string>> c = { {"yellow_hat", "headgear"},
        {"blue_sunglasses", "eyewear"},{"green_turban", "headgear"} };
    solution(c);
}