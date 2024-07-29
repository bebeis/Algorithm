#include <bits/stdc++.h>
using namespace std;

// 가능한 범위 : 1 ~ m
// tree 정렬
// mid로 자른 나무 길이가 원하는 것보다 많으면 low 조절
// 적으면 high 조절, low > high면 탈출

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int n, m, max = -1;
    int tree[1000001];
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        cin >> tree[i];
    }
    sort(tree, tree + n);
    long long low = 0, high = tree[n - 1];
    while (low <= high) {
        long long sum = 0;
        long long mid = (low + high) / 2;
        for (int i = 0; i < n; i++) {
            if (tree[i] - mid > 0) sum += tree[i] - mid;
        }
        if (sum >= m) {
            max = mid;
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    cout << max;
}