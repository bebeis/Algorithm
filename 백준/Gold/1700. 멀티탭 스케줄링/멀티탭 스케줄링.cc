#include <bits/stdc++.h>
using namespace std;

int result = 0;
int tap[101];
int arr[101];

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int n, k;
    queue<int> que[101];
    cin >> n >> k;
    for (int i = 0; i < k; i++) {
        cin >> arr[i];
        que[arr[i]].push(i);
    }
    for (int i = 0; i < k; i++) {
        bool skip = false;
        // 이미 멀티탭에 꽂혀있거나 비어있는 경우
        for (int j = 0; j < n; j++) {
            if (tap[j] == arr[i]) {
                // cout << j << "번째 탭에 이미 " << arr[i] << "가 꽂혀있다.\n";
                que[arr[i]].pop();
                skip = true;
                break;
            } else if (tap[j] == 0) {
                // cout << j << "번째 탭에 " << arr[i] << "를 꽂는다.\n";
                tap[j] = arr[i];
                que[arr[i]].pop();
                skip = true;
                break;
            }
        }
        if (skip) continue;
        // 가장 나중에 등장하는 콘센트를 빼야 함(아에 안나오면 그걸 빼면 됨)
        int far_pos = -1;
        int far_consent = -1;
        for (int j = 0; j < n; j++) {
            if (que[tap[j]].empty()) {
                far_consent = j;
                break;
            }
            else if (que[tap[j]].front() > far_pos) {
                far_consent = j;
                far_pos = que[tap[j]].front();
            }
        }
        // cout << far_consent << "번째 탭에 " << tap[far_consent] << "를 빼고 " << arr[i] << "를 꽂는다.\n";
        tap[far_consent] = arr[i];
        que[arr[i]].pop();
        result++;
    }
    cout << result;
}