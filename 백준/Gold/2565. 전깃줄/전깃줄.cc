#include <bits/stdc++.h>
using namespace std;

// 정렬한 상태에서 LIS의 최대 길이를 구하면 제거할 전기줄 수의 최솟값을 구할 수 있다.
int n;
pair<int, int> lines[101];

vector<int> LIS;

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n;
    for (int i = 0; i < n; i++) cin >> lines[i].first >> lines[i].second;
    sort(lines, lines + n);
    // lines.second가 오름차순이 되도록 하기 위해 제거해야 할 Line의 최소 구하기
    LIS.push_back(lines[0].second);
    for (int i = 1; i < n; i++) {
        if (LIS.back() < lines[i].second) LIS.push_back(lines[i].second);
        else *lower_bound(LIS.begin(), LIS.end(), lines[i].second) = lines[i].second;
    }
    cout << n - LIS.size();
}