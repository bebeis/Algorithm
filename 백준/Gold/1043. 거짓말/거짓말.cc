#include <bits/stdc++.h>
using namespace std;

int n, m, k;
int cnt = 0;
int parent[51];
vector<int> party[51];

int findParent(int x) {
    if (parent[x] == x) return x;
    return parent[x] = findParent(parent[x]);
}

void unionParent(int a, int b) {
    a = findParent(a);
    b = findParent(b);

    if (a == 0) {
        parent[b] = a;
    } else {
        parent[a] = b;
    }
}

int main(void) {
    cin.tie(0)->sync_with_stdio(false);

    cin >> n >> m >> k;
    for (int i = 1; i <= n; i++) parent[i] = i;
    while (k--) {
        int x; cin >> x;
        parent[x] = 0; // 부모가 0번이면 아는 것.
    }
    for (int i = 0; i < m; i++) {
        int memberSize; cin >> memberSize;
        int first; cin >> first;
        party[i].push_back(first);
        for (int j = 1; j < memberSize; j++) {
            int member; cin >> member;
            party[i].push_back(member);
            unionParent(first, member);
        }
    }

    for (int i = 0; i < m; i++) {
        if (findParent(party[i].front()) != 0) cnt++;
    }
    
    cout << cnt;
}