#include <bits/stdc++.h>
using namespace std;

// 임의의 두 도시 사이에 길이 있는지 체크 --> 같은 집합에 속해있는지 확인하면 된다.
// 1트 틀린 이유 : for (int i = 1; i <= n; i++) parent[i] = i; 초기화 과정을 누락함

int n, m;
int parent[201];
int road[1001];

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

bool SameParent(int a, int b) {
    a = GetParent(a);
    b = GetParent(b);

    if (a == b) return 1;
    else return 0;
}



int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n >> m;
    for (int i = 1; i <= n; i++) parent[i] = i;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            int connect;
            cin >> connect;
            if (connect) UnionParent(i, j);
        }
    }
    for (int i = 0; i < m; i++) cin >> road[i];
    for (int i = 1; i < m; i++) {
        if (!SameParent(road[i - 1], road[i])) {
            cout << "NO";
            return 0;
        }
    }
    cout << "YES";
}