#include <bits/stdc++.h>
using namespace std;

// time limit : 1s, 반복 횟수 n <= 100,000 --> O(NlogN) 이하로 해결
// for문을 돌면서 1~n까지 구성할 수 있는 rectangle의 넓이를 구하는 풀이 --> O(N) * O(N) = O(N^2)
// 특정 구간의 높이 최솟값을 O(N)보다 빠르게 구할 수 있어야 함 --> 세그먼트 트리 이용
// 구간을 1~n으로 반복하는게 아니라, 최소 높이를 갖는 지점을 기준으로 divide하여 넓이의 최대를 구한다.
int init(vector<int> &square, vector<int> &tree, int node, int start, int end) {
    if (start == end) return tree[node] = start;
    else {
        int left_idx = init(square, tree, node * 2, start, (start + end) / 2);
        int right_idx = init(square, tree, node * 2 + 1, (start + end) / 2 + 1, end);
        return tree[node] = (square[left_idx] <= square[right_idx]) ? left_idx : right_idx;
    }
}

int query(vector<int> &square, vector<int> &tree, int node, int start, int end, int left, int right) {
    if (right < start || end < left) return -1;

    if (left <= start && end <= right) return tree[node];
    
    int left_idx = query(square, tree, node * 2, start, (start + end) / 2, left, right);
    int right_idx = query(square, tree, node * 2 + 1, (start + end) / 2 + 1, end, left, right);

    if (left_idx == -1) return right_idx;
    if (right_idx == -1) return left_idx;
    return (square[left_idx] <= square[right_idx]) ? left_idx : right_idx;
}

long long getMaxArea(vector<int> &square, vector<int> &tree, int start, int end) {
    if (start > end) return 0;
    int min_idx = query(square, tree, 1, 0, square.size() - 1, start, end);
    long long area = (long long)square[min_idx] * (end - start + 1);
    if (min_idx > start) area = max(area, getMaxArea(square, tree, start, min_idx - 1));
    if (min_idx < end) area = max(area, getMaxArea(square, tree, min_idx + 1, end));
    return area;
}

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    while (true) {
        int n;
        cin >> n;
        if (n == 0) break;
        vector<int> square(n);
        for (int i = 0; i < n; i++) {
            cin >> square[i];
        }
        int h = (int)ceil(log2(n));
        int tree_size = (1 << (h + 1));
        vector<int> tree(tree_size);
        init(square, tree, 1, 0, n - 1);
        cout << getMaxArea(square, tree, 0, n - 1) << '\n';
    }

    return 0;
}
