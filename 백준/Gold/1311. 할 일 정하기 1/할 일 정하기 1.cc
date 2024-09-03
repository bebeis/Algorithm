#include <bits/stdc++.h>
using namespace std;

// 가능한 모든 경우의 수를 brute force로 계산 --> 20! ==> 1초안에 불가능
// n<=20 이므로 2^n == 1 000 000 --> 2^n * n 풀이를 떠올려보자
// 브루트포스 순열 20!에는 바로 순서가 존재한다. 우리는 순서가 필요없다.
// 브루트 포스라면 visited 배열로 지나온 경로를 구현했을 것임
// 지금까지 정한 상태를 부분집합으로 나타낼 수 있다. 집합은 순서가 상관없다.
// 집합에 존재 or 존재 X 로 2^n가지, 그리고 현재 정한 것이 n가지.. --> O(2^n) * n

int n;
int arr[21][21];
int d[(1 << 20) + 10];

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n;
    
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) cin >> arr[i][j];
    }

    fill(d, d + (1 << n), INT_MAX);
    d[0] = 0;
    
    for (int mask = 0; mask < (1 << n); mask++) {
        int i = __builtin_popcount(mask); // 현재 선택된 작업의 개수 == 현재 처리해야 할 사람의 번호
        for (int j = 0; j < n; j++) {
            if (!(mask & (1 << j))) { // j번째 작업이 선택되지 않았을 때
                d[mask | (1 << j)] = min(d[mask | (1 << j)], d[mask] + arr[i][j]);
            }
        }
    }
    
    cout << d[(1 << n) - 1];
}