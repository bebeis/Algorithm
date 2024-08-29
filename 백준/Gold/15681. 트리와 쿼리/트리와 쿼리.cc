#include <bits/stdc++.h>
using namespace std;

vector<int> adj[100001];
int p[100001];
int siz[100001];
int n, r, q;

// DFS 기반 트리 구성
void MakeTree(int cur, int parent) {
    for (int nxt : adj[cur]) {
        if (nxt == parent) continue;
        p[nxt] = cur;
        MakeTree(nxt, cur);
    }
}

// 각 노드의 서브트리 노드 개수를 재귀적으로 계산
void CountSubTreeNodes(int cur) {
    siz[cur] = 1;
    for (int nxt : adj[cur]) {
        if (nxt == p[cur]) continue;
        CountSubTreeNodes(nxt);
        siz[cur] += siz[nxt];
    }
}

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n >> r >> q;
    for (int i = 0; i < n - 1; i++) {
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }
    MakeTree(r, -1);
    CountSubTreeNodes(r);
    while (q--) {
        int sr;
        cin >> sr;
        cout << siz[sr] << '\n';
    }
}