#include <bits/stdc++.h>
using namespace std;
typedef unsigned long long ull;

// k로 부터 i, j를 구해내는게 문제
// O(n^2)로는 못품. O(nlogn)이하 풀이를 찾아보자
// 문제를 역으로 접근해보자
// k번째 수를 s라고 하고, s를 다시 N x N으로 배치한다면 어떤 좌표로 위치하는지를 찾으면 되지 않을까?
/*
1 2 3 4 5    5
2 4 6 8 10   2
3 6 9 12 15  1
4 8 12 16 20 1
5 10 15 20 25 1

1 22 33 444 55 66 88 9 10 10 12 12 15 15 16 20 20 25

idea : 각 행에서 S보다 작은 수는 min(s/i, N)이다.
i * j가 S이고, s를 i로 나눈 몫이 j가 되니까
따라서 S이하의 수가 k가 되도록 S를 조절해줘서 찾아보자.
*/

int n, k;

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n >> k;
    int start = 1, end = k;
    int res = 0;
    while (start <= end) { // log(n)
        int mid = (start + end) / 2;
        // s = mid일 때 s 이하의 수 구하기
        int sum = 0;
        for (int i = 1; i <= n; i++) sum += min(mid / i, n);
        if (sum >= k) {
            res = mid;
            end = mid - 1;
        } else start = mid + 1;
    }

    cout << res;
}