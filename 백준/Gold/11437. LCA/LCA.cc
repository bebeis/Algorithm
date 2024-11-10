#include <bits/stdc++.h>
using namespace std;

int n, m;
int ancestor[17][50001]; // 2^16 = 65536. 점프는 아무리 커도 2^16 보단 작음
vector<int> adj[50001];
int depth_node[50001];

// m의 케이스가 주어질 때 마다 탐색 -> O(mn) = 500 000 000 -> TLE
// 처음에 노드 정보를 받을 때 LCA를 저장해둬야 할까? 모든 쌍을 저장받으려면 1억 크기 배열 -> 불가능
// 그러면 탐색을 선형이 아니라 log 스케일로 해야한다. 분할 정복이나 이분 탐색을 사용해야 한다.
// 루트로 부터 오름차순으로 리프 노드까지 이어진다는 점을 이용해서 이분 탐색을 할 수 있지 않을까?
// 두 노드의 깊이를 동일하게 맞춰주면, 같은 깊이만큼 올라가면 LCA를 만날 수 있다
// 모든 숫자는 2^n의 합으로 나타낼 수 있다.
// 2^n 단위로 움직이자.
// 2^3으로 올라갔는데 같다 -> 2^2 ~ 2^3 사이에 존재한다는 뜻
// log 스케일로 줄일 수가 있다.
// 그래서 2^n 높이 위에 어떤 노드가 위치하는지를 기록해야 한다

void dfs(int v, int parent_v) {
    ancestor[0][v] = parent_v;
    for (auto &u : adj[v]) {
        if (u != parent_v) {
            depth_node[u] = depth_node[v] + 1;
            dfs(u, v);
        }
    }
}

void preprocess() {
    for(int k = 1; k < 16; k++) {
        for(int v = 1; v <= n; v++) {
            if(ancestor[k-1][v] != -1)
                ancestor[k][v] = ancestor[k-1][ancestor[k-1][v]];
            else
                ancestor[k][v] = -1;
        }
    }
}

int lca(int u, int v) {
    // 알고리즘 일관성을 위해서 u가 일단 더 높은 깊이라고 설정
    if (depth_node[u] < depth_node[v]) swap(u, v);

    // ex. 11이라면 8 + 2 + 1 요런식이라서, 지수가 큰 것 부터 순회한다.
    // depth도 로그 스케일로 순회하는 것

    for (int k = 15; k >= 0; k--){
        if (depth_node[u] - (1 << k) >= depth_node[v]){
            u = ancestor[k][u];
        }
    }

    if (u == v) return u;

    for (int k = 15; k >= 0; k--) {
        if (ancestor[k][u] != -1 && ancestor[k][u] != ancestor[k][v]) {
            u = ancestor[k][u];
            v = ancestor[k][v];
        }
    }

    return ancestor[0][u];
}

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    
    cin >> n;
    for (int i = 1; i <= n - 1; i++) {
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    memset(ancestor, -1, sizeof(ancestor));
    depth_node[1] = 0;
    dfs(1, -1);
    preprocess();

    cin >> m;
    while (m--) {
        int u, v;
        cin >> u >> v;
        cout << lca(u, v) << '\n';
    }
}