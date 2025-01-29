#include <bits/stdc++.h>
using namespace std;

int n, k;
int dist[100001];

inline int moveLeft(int x) {return x - 1;}
inline int moveRight(int x) {return x + 1;}
inline int teleport(int x) {return x * 2;}
bool isValidIndex(int x) {
    if (x < 0) return false;
    if (x > 100000) return false;
    return true;
}

int (*fp[3])(int) = {moveLeft, moveRight, teleport};

int main(void) {
    cin.tie(0)->sync_with_stdio(false);

    cin >> n >> k;
    if (n == k) {
        cout << 0;
        return 0;
    }
    queue<int> Q;
    Q.push(n);
    while (!Q.empty()) {
        int cur = Q.front();
        Q.pop();
        for (auto func : fp) {
            int nxt = func(cur);
            if (nxt == k) {
                cout << dist[cur] + 1;
                return 0;
            }
            if (isValidIndex(nxt) && dist[nxt] == 0) {
                Q.push(nxt);
                dist[nxt] = dist[cur] + 1;
            }
        }
    }
}