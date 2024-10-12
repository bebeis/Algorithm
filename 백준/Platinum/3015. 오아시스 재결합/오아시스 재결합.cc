#include <bits/stdc++.h>
using namespace std;

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0);
    
    int n;
    cin >> n;
    long long height;
    long long cnt = 0;
    stack<pair<long long, long long>> S; // (height, count)
    
    for(int i = 0; i < n; i++) {
        cin >> height;
        long long same = 1;
        
        while(!S.empty() && S.top().first < height) {
            cnt += S.top().second;
            S.pop();
        }
        
        if(!S.empty() && S.top().first == height) {
            cnt += S.top().second;
            same = S.top().second + 1;
            if(S.size() >= 2) cnt +=1;
            S.pop();
        }
        else if(!S.empty()) {
            cnt +=1;
        }
        
        S.push({height, same});
    }
    
    cout << cnt;
}
