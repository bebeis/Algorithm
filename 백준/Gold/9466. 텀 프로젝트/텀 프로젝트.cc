#include <bits/stdc++.h>
using namespace std;

// O(nlogn) 이하로 풀이
// 틀린 이유 : 오타때문에 틀림 ㅠㅠ
int arr[100001];
int fix[100001];
int vis[100001];

// 1 2 3 4
// 3 3 4 2

void DFS(int start, int no) {
    stack<int> S;
    S.push(start);
    vis[start] = no;
    while (!S.empty()) {
        auto cur = S.top();
        if (fix[arr[cur]] == 1 || fix[arr[cur]] == -1) {
            while (!S.empty()) {
                fix[S.top()] = -1;
                S.pop();
            }
            return;
        } else if (vis[arr[cur]] == no) {
            fix[arr[cur]] = 1;
            while (S.top() != arr[cur]) {
                int x = S.top();
                fix[x] = 1;
                S.pop();
            }
            S.pop();
            while (!S.empty()) {
                int x = S.top();
                fix[x] = -1;
                S.pop();
            }
            return;
        } else {
            S.push(arr[cur]);
            vis[arr[cur]] = no;
        }
    }
}

int main(void) {
    cin.tie(0)->sync_with_stdio(false);

    int t; cin >> t;
    while (t--) {
        int n; cin >> n;
        int no = 1;
        int result = 0;
        memset(fix, 0, sizeof(fix));
        memset(vis, 0, sizeof(vis));
        for (int i = 1; i <= n; i++) {
            cin >> arr[i];
            if (arr[i] == i) fix[i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            if (fix[i] == 0) {
                DFS(i, ++no);
            }
        }
        for (int i = 1; i <= n; i++) {
            if (fix[i] == -1) result++;
        }
        cout << result << '\n';
    }
}