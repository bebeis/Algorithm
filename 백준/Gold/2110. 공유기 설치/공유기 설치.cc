#include <bits/stdc++.h>
using namespace std;

vector<int> input;

// 분할 정복에서 서로 다른 부문제가 각각에 영향을 주면 안됨
// 단순히 쪼개기만 하는 건 의미가 없다.
// 나눌 때 조건을 추가해 부문제간 서로 영향을 주지 않도록 설계


int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int n, c, max = 0;
    cin >> n >> c;
    input.resize(n);
    for (int i = 0; i < n; i++) {
        cin >> input[i];
    }
    sort(input.begin(), input.end());
    // 이론상 넘을 수 없는 최대 거리
    int high = input[n - 1] - input[0];
    int low = 0;
    while (low <= high) {
        int cnt = 0;
        int mid = (low + high) / 2;
        int i = 0;
        for (int j = 1; j < n; j++) {
            if (input[j] - input[i] >= mid) {
                cnt++;
                i = j;
            }
        }
        if (cnt >= (c - 1)) { // 거리를 더 늘려도 되는 경우
            max = mid;
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    cout << max;
}
