#include <bits/stdc++.h>
using namespace std;

// O(N), O(Nlogn)으로 풀이
// for문 내에서 O(1)로 처리가 되야 함. O(L)이면 망함
// for문을 지날 때 최소값의 상태를 유지시켜주면서, 빠지는 값, 들어오는 값만 비교하면 O(1)로 처리가 가능하다.
// 어떤 자료구조를 쓸거냐인데, 나는 덱을 사용하겠다. 프론트에다가 최소값을 유지시킨다고 해보자.
// 먼저 현재 상태에서 프론트에 최소값이 있고 이제 그 다음 상태로 넘어갈건데, for문이 바뀌기 전에, 
// 범위로 벗어나고 && 그 값이 최솟값이면 pop_front를 한다. 
// 1 5 2인데, 5, 2가 되는거다.
// 여기서 새로 들어오는 수가 x라고 할 때, x보다 앞에 있는게 x보다 크면 아무런 영향을 주지 않는다.
// 그래서 x가 3이면 5를 pop해버린다. 그래서 x보다 큰 것이 올때 && 덱이 비어있지 않을 때 까지 pop을 하고
// push_back을 해준다. 이러면 O(N)이다~
// 이런 문제의 핵심은, for문 상태 당 O(1) 이런게 아니라, 모든 프로세스를 합쳤을 때 원소가 한 번씩만 pop되면 된다는 점이다.

// 1트 틀렸던 부분
// 반례 : 4 3
// 1 3 2 4
// front() 다음에서 최소값이 유지되지 않아서, front()가 빠졌을 때 다음 for문에서 front()가 최소가 아닌 문제 발생
// push_back 하기 전에 나보다 작은 건 먼저 pop_back을 또 해주고 push해준다.

int n, l;
int arr[5000001];

int main(void) {
    cin.tie(0) -> sync_with_stdio(false);

    deque<pair<int, int>> deq; // {index, value}
    cin >> n >> l;
    for (int i = 1; i <= n; i++) cin >> arr[i];
    for (int lastIdx = 1; lastIdx <= n; lastIdx++) {
        int firstIdx = lastIdx - l + 1;

        // Step 1
        while (!deq.empty() && deq.front().second >= arr[lastIdx]) deq.pop_front();
        while (!deq.empty() && deq.back().second >= arr[lastIdx]) deq.pop_back(); // 한 번 틀리고 나서 추가
        deq.push_back({lastIdx, arr[lastIdx]});

        // Step 2
        cout << deq.front().second << ' ';

        // Step 3
        if (firstIdx <= 0) continue;
        if (firstIdx == deq.front().first) deq.pop_front();
    }
}