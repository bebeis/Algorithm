#include <iostream>
using namespace std;

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int n, count;
    bool arr[246912];
    fill_n(arr, 246912, true); // 모든 원소를 true로 초기화
    for (int i = 2; i * i <= 246912; i++) {
        if (arr[i]) {
            for (int j = i * i; j <= 246912; j += i) { // j의 시작을 i*i로 변경
                arr[j] = false;
            }
        }
    }
    while (1) {
        cin >> n;
        if (n == 0) {
            break;
        }
        count = 0;
        for (int i = n + 1; i <= 2 * n; i++) {
            if (arr[i]) count++;
        }
        cout << count << '\n';
        
    }
}