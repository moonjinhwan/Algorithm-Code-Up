#include<iostream>
#include<algorithm>
using namespace std;
int list[9];
int N;
int score[50][9];
bool use[9];
int ans = 0;
void playGame() {
    int sum = 0, num = 0;
    for (int i = 0; i < N; i++) {
        int out = 0, runner[3] = { 0 };
        do {
            if (score[i][list[num]] == 0) {
                out += 1;
            }
            else if (score[i][list[num]] == 1) {
                sum += runner[2];
                runner[2] = runner[1];
                runner[1] = runner[0];
                runner[0] = 1;
            }
            else if (score[i][list[num]] == 2) {
                sum = sum + runner[2] + runner[1];
                runner[2] = runner[0];
                runner[1] = 1;
                runner[0] = 0;
            }
            else if (score[i][list[num]] == 3) {
                sum = sum + runner[2] + runner[1] + runner[0];
                runner[2] = 1;
                runner[1] = 0;
                runner[0] = 0;
            }
            else if (score[i][list[num]] == 4) {
                sum = sum + runner[2] + runner[1] + runner[0] + 1;
                runner[2] = 0;
                runner[1] = 0;
                runner[0] = 0;
            }
            num = (num + 1) % 9;
        } while (out < 3);
    }

    ans = max(ans, sum);
}

void pick(int idx) {
	if (idx == 9) {
		playGame();
		return;
	}
	if (idx == 3) {
		list[idx] = 0;
		pick(idx + 1);
		return;
	}
	for (int i = 1; i < 9; i++) {
		if (use[i] == false) {
			use[i] = true;
			list[idx] = i;
			pick(idx + 1);
			use[i] = false;
			list[idx] = -1;
		}
	}
}
int main() {
	cin >> N;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < 9; j++) {
			cin >> score[i][j];
		}
	}
	pick(0);
    cout << ans;
}