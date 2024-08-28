#include <bits/stdc++.h>
using namespace std;

bool d[4000001];
int n;
int cnt = 0;
vector<int> primeArr;

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n;
    if (n == 1) {
        cout << 0;
        return 0;
    }
    for (int i = 2; i <= n; i++) d[i] = 1;
    for (int i = 2; i <= n; i++) {
        if (d[i] == 0) continue; // 이 전에 소수가 아님을 판별함
        
        for (int j = 2 * i; j <= n; j+= i) {
            d[j] = 0;
        }
    }
    for (int i = 2; i <= n; i++) {
        if (d[i]) primeArr.push_back(i);
    }
    // 투 포인터
    int ed = 0, sum = primeArr[0];
    for (int st = 0; st < primeArr.size(); st++) {
        while (ed < primeArr.size() && sum < n) {
            ed++;
            if (ed != primeArr.size()) sum += primeArr[ed];
        }
        if (ed == primeArr.size()) break;
        if (sum == n) cnt++;
        sum -= primeArr[st];
    }
    cout << cnt;
}