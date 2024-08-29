#include <bits/stdc++.h>
using namespace std;

// postorder의 마지막은 항상 루트 노드!

int n;

int idx[100001];
int inorder[100001];
int postorder[100001];

void PreOrder(int inStart, int inEnd, int postStart, int postEnd) {
    if (inStart > inEnd || postStart > postEnd) return;
    
    // inorder에서 루트에 해당하는 인덱스
    int rootIdx = idx[postorder[postEnd]];
    int leftSize = rootIdx - inStart;
    int rightSize = inEnd - rootIdx;
    cout << inorder[rootIdx] << ' ';

    PreOrder(inStart, rootIdx - 1, postStart, postStart + leftSize - 1);
    PreOrder(rootIdx + 1, inEnd, postStart + leftSize, postEnd - 1);
}

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n;
    for (int i = 1; i <= n; i++) {
        cin >> inorder[i];
        idx[inorder[i]] = i;
    }
    for (int i = 1; i <= n; i++) cin >> postorder[i];
    PreOrder(1, n, 1, n);

}