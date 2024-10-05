#include <bits/stdc++.h>
using namespace std;

int idx[1000001];
vector<int> preorder;

void postOrder(int preStart, int preEnd) {
    int rootVal = preorder[preStart];
    if (preStart == preEnd) {
        cout << rootVal << '\n';
        return;
    }

    int leftEnd = preStart + 1;
    while (leftEnd <= preEnd) {
        if (preorder[leftEnd] > rootVal) {
            break;
        }
        else leftEnd++;
    }
    leftEnd--;
    if (leftEnd == preStart) {
        postOrder(preStart + 1, preEnd);
    } else {
        postOrder(preStart + 1, leftEnd);
        if (leftEnd < preEnd) postOrder(leftEnd + 1, preEnd);
    }
    cout << rootVal << '\n';
}

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    int val;
    while (cin >> val) {
        preorder.push_back(val);
        idx[val] = preorder.size();
    }

    postOrder(0, preorder.size() - 1);
}