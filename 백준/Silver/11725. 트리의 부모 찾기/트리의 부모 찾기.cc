#include <bits/stdc++.h>
using namespace std;

class Tree {
   public:
    int n;
    vector<vector<int>> adj;
    vector<int> parent;

    Tree(int n) : n(n), adj(n + 1), parent(n + 1, -1) {}

    void addEdge(int u, int v) {
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    void findParents() {
        queue<int> q;
        q.push(1);
        parent[1] = 0;

        while (!q.empty()) {
            int node = q.front();
            q.pop();

            for (int neighbor : adj[node]) {
                if (parent[neighbor] == -1) {
                    parent[neighbor] = node;
                    q.push(neighbor);
                }
            }
        }
    }

    void printParents() {
        for (int i = 2; i <= n; i++) {
            cout << parent[i] << '\n';
        }
    }
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;
    Tree tree(n);

    for (int i = 0; i < n - 1; i++) {
        int x, y;
        cin >> x >> y;
        tree.addEdge(x, y);
    }

    tree.findParents();
    tree.printParents();

    return 0;
}
