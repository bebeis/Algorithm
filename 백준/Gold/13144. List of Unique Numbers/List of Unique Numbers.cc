#include <bits/stdc++.h>
using namespace std;

int n;
int arr[100002];
bool vis[100002];

// 1 continue
// 12 123 23 231 31 312 12

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n;
    for (int i = 0; i < n; i++) cin >> arr[i];
    long long ans = 0;
    int en = 0;
    vis[arr[0]] = 1;
    
    for (int st = 0; st < n; st++) {
        while (en < n - 1 && !vis[arr[en + 1]]) {
            en++;
            vis[arr[en]] = 1;
        }
        ans += (en - st + 1);
        vis[arr[st]] = 0;
    }
    cout << ans;
}