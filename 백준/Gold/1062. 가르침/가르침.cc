#include <bits/stdc++.h>
using namespace std;

int n, k, MAX = 0;
string words[51];
int status[51];
// antic
// 특정 알파벳을 가르쳤음을 비트를 통해서 표현할 수 있다. (최대 2^26)
// antic은 무조건 가르쳐야 하므로 나머지 21개만 계산하자. 2^21 --> 약 n = 200만이므로 1초안에 통과 가능

void backtracking(int cur, int cnt, int pos) {
    if (cnt == k) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            if ((status[i] & cur) == status[i]) result++;
        }
        MAX = max(result, MAX);
        return;
    }

    for (int i = pos; i < 26; i++) {
        if ((cur & (1 << i)) != 0) continue;
        cur |= (1 << i);
        backtracking(cur, cnt + 1, i + 1);
        cur &= ~(1 << i);
    }
}

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n >> k;
    for (int i = 0; i < n; i++) {
        cin >> words[i];
        for (int j = 0; j < words[i].length(); j++) {
            status[i] |= (1 << (words[i][j] - 'a'));
        }
    }

    if (k >= 5) {
        int init = 1;
        init |= (1 << ('c' - 'a'));
        init |= (1 << ('n' - 'a'));
        init |= (1 << ('i' - 'a'));
        init |= (1 << ('t' - 'a'));
        backtracking(init, 5, 1);
    }


    cout << MAX;
}