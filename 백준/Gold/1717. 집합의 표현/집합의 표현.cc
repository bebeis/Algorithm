#include <bits/stdc++.h>
using namespace std;

// 합집합 연산 + 두 원소가 같은 집합인지 => Union-Find

int n, m;

int parent[1000001];

int GetParent(int x) {
    if (x == parent[x]) return x;
    return parent[x] = GetParent(parent[x]);
}

void UnionParent(int a, int b) {
    a = GetParent(a);
    b = GetParent(b);
    if (a < b) parent[b] = a;
    else parent[a] = b;
}

void SameParent(int a, int b) {
    a = GetParent(a);
    b = GetParent(b);

    if (a == b) cout << "YES\n";
    else cout << "NO\n";
}

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n >> m;
    for (int i = 1; i <= n; i++) parent[i] = i;
    while (m--) {
        int inst, a, b;
        cin >> inst >> a >> b;
        if (inst) SameParent(a, b);
        else UnionParent(a, b);
    }
}