#include <iostream>
using namespace std;

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    int n, temp, max = 0;
    int count_array[10001] = { 0, };
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> temp;
        if (max < temp) {
            max = temp;
        }
        count_array[temp]++;
    }

    for (int i = 0; i < max + 1; i++) {
        if (count_array[i] != 0) {
            for (int j = 0; j < count_array[i]; j++) {
                cout << i << '\n';
            }
        }
    }
}