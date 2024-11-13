#include <bits/stdc++.h>
using namespace std;

// brute - force : 2^30 -> 10억
// 무게 별로 선형 탐색 -> 10억.
// 어쨌든 log 스케일로 줄여야 한다.
// 이분탐색/분할정복을 사용해야 한다.
// a + b = c이다. 우리는 c를 알고 있다.
// 따라서 a만 정해주면 b는 알아서 따라온다.
// 반띵을 해서 모든 합의 경우의 수를 찾아놓자.
// 쓰레기 같은 문제임. 문제가 말이 안됨


int n, c;
int weight[31];
long long result = 0;
vector<long long> leftList;
vector<long long> rightList;

void combine(int Left, int Right, vector<long long>& Set, long long sum) {
    if(Left > Right) {
        Set.push_back(sum);
        return;
    }

    combine(Left + 1, Right, Set, sum);
    combine(Left + 1, Right, Set, sum + weight[Left]);
}
int main(void) {
    cin.tie(0)->sync_with_stdio(false);

    cin >> n >> c;
    
    for (int i = 0; i < n; i++) cin >> weight[i];

    combine(0, n / 2, leftList, 0);
    combine(n / 2 + 1, n - 1, rightList, 0);
    
    sort(rightList.begin(), rightList.end());
    for (auto leftVal : leftList) {
        result += upper_bound(rightList.begin(), rightList.end(), c - leftVal) - rightList.begin();
    }
    cout << result;
}