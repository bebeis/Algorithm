#include <iostream>
using namespace std;

int main(void) {
    int n, v;
    int arr[201] = { 0, };
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> v;
        arr[v + 100]++;
    }
    cin >> v;
    cout << arr[v + 100];
}