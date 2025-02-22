#include <bits/stdc++.h>
using namespace std;

int arr[1002];
unordered_map<int, int> i2i;
unordered_map<int, int> init;

bool cmp(int x, int y) {
    if (i2i[x] == i2i[y]) return init[x] < init[y];
    return i2i[x] > i2i[y];
}

int main(void) {
    cin.tie(0)->sync_with_stdio(false);

    int n, c; cin >> n >> c;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
        if (i2i.find(arr[i]) == i2i.end()) {
            i2i[arr[i]] = 1;
            init[arr[i]] = i;
        } else {
            i2i[arr[i]]++;
        }
    }

    sort(arr, arr + n, cmp);
    for (int i = 0; i < n; i++) cout << arr[i] << ' ';
}