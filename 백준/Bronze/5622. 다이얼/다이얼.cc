#include <bits/stdc++.h>
using namespace std;

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    string a;
    cin >> a;
    int time[] = {3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 10, 10, 10, 10};
    int result = 0; 
    for (int i = 0; a[i] != NULL; i++) result += time[a[i] - 'A'];
    cout << result;
}