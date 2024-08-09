#include <bits/stdc++.h>
using namespace std;

// 상덕이는 가방을 K개 가지고 있고, 각 가방에 담을 수 있는 최대 무게는 Ci이다
// 상덕이가 훔칠 수 있는 보석의 최대 가격 구하기
// 가방에는 보석을 1개만 넣을 수 있다.
// O(nlogn), o(nlogc), o(clogc)이하로 풀어야 함
// 처음에 문제 푸는 아이디어는 옳았다.
// 시간초과 난 이유 : while (idx < k && bag_object[idx] != 0) idx++;인 듯한데
// 값을 대입한 인덱스 자체를 리스트에서 삭제 해주면 굉장히 빠르게 처리가 가능하다.
// --> bag_object 대신 multiset 사용

int bag[300001];

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int n, k, m, v;
    priority_queue<pair<int, int>, vector<pair<int, int>>, less<pair<int, int>>> pq;
    cin >> n >> k;
    for (int i = 0; i < n; i++) {
        cin >> m >> v;
        pq.push({v, m});
    }
    for (int i = 0; i < k; i++) cin >> bag[i];
    sort(bag, bag + k);
    multiset<int> available_bags(bag, bag + k);
    long long sum = 0;
    while (!pq.empty()) {
        auto [price, weight] = pq.top(); pq.pop();
        auto it = available_bags.lower_bound(weight);
        if (it != available_bags.end()) {
            sum += price;
            available_bags.erase(it);
        }
    }
    cout << sum;
}