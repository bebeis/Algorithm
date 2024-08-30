#include <bits/stdc++.h>
using namespace std;

int n, m;
unordered_map<string, int> hm;
string name[1001];
vector<int> adj[1001];
priority_queue<int, vector<int>, greater<int>> child[1001];
int indeg[1001];

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n;
    for (int i = 0; i < n; i++) cin >> name[i];
    sort(name, name + n);
    for (int i = 0; i < n; i++) hm[name[i]] = i;
    cin >> m;
    while (m--) {
        string s1, s2;
        cin >> s1 >> s2;
        adj[hm[s2]].push_back(hm[s1]);
        indeg[hm[s1]]++;
    }

    deque<int> root;
    for (int i = 0; i < n; i++) if (indeg[i] == 0) root.push_back(i);
    sort(root.begin(), root.end());
    cout << root.size() << '\n';
    for (int idx : root) cout << name[idx] << ' ';
    cout << '\n';

    while (!root.empty()) {
        int cur = root.front(); root.pop_front();
        for (int nxt : adj[cur]) {
            indeg[nxt]--;
            if (indeg[nxt] == 0) {
                child[cur].push(nxt);
                root.push_back(nxt);
            }
        }
    }

    for (int i = 0; i < n; i++) {
        cout << name[i] << ' ' << child[i].size() << ' ';
        while (!child[i].empty()) {
            cout << name[child[i].top()] << ' ';
            child[i].pop();
        }
        cout << '\n';
    }
}