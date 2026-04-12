#include <bits/stdc++.h>
using namespace std;

int n, k;
int arr[102];
int slot[102];
int slotMap[102];

int findEmptySlot() {
    for (int i = 1; i <= n; i++) {
        if (slot[i] == 0) return i;
    }
    return -1;
}

int replace(int curTime) {
    int targetSlot = -1;
    int maxDistance = -1;

    for (int i = 1; i <= n; i++) {
        int item = slot[i];

        int nextUse = 1e9;
        for (int t = curTime + 1; t <= k; t++) {
            if (arr[t] == item) {
                nextUse = t;
                break;
            }
        }

        if (nextUse > maxDistance) {
            maxDistance = nextUse;
            targetSlot = i;
        }
    }

    return targetSlot;
}

int main() {
    cin.tie(0)->sync_with_stdio(false);

    cin >> n >> k;
    for (int i = 1; i <= k; i++) cin >> arr[i];

    int cnt = 0;
    for (int i = 1; i <= k; i++) {
        int cur = arr[i];

        if (slotMap[cur] != 0) continue;

        int emptySlot = findEmptySlot();
        if (emptySlot == -1) {
            int slotId = replace(i);
            slotMap[slot[slotId]] = 0;
            slot[slotId] = cur;
            slotMap[cur] = slotId;
            cnt++;
        } else {
            slot[emptySlot] = cur;
            slotMap[cur] = emptySlot;
        }
    }

    cout << cnt;
}