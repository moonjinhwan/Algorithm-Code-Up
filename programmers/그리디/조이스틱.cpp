#include <string>
#include <vector>
#include<iostream>
#include<algorithm>
using namespace std;
bool visit[20];
int solution(string name) {
    int ans = 0;
    int cnt = 0;
    for (int i = 0; i < name.size(); i++) {
        if (name[i] != 'A' && i != 0) { cnt++; visit[i] = true; }
        int a = name[i] - 'A';
        int b = 'Z' + 1 - name[i];
        ans += min(a, b);
       
    }
    int cur = 0;
    while (cnt > 0) {
        int rd=0, ld=0;
        int ridx=0, lidx=0;
        for (int i = cur+1; i <= name.size(); i++) {//¿À¸¥ÂÊ
            if (i == name.size()) { i = 0; }
            rd++;
            if (visit[i]) {
                ridx = i;
                break;
            }
        }
        for (int i = cur-1; i >= -1; i--) {//¿ÞÂÊ
            if (i == -1) { i = name.size() - 1; }
            ld++;
            if (visit[i]) {
                lidx = i;
                break;
            }
        }
        if (rd <= ld) {
            ans += rd;
            cur = ridx;
            visit[cur] = false;
        }
        else {
            ans += ld;
            cur = lidx;
            visit[cur] = false;
        }
        cnt--;
    }
    cout << ans;
    return ans;
}
int main() {
    solution("JEROEN");
}
