#include <iostream>
#include <algorithm>
using namespace std;

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int size; // 배열의 사이즈
    cin >> size; // 입력
    int *arr = new int[size]; // 사이즈 동적할당
    for (int i = 0; i < size; i++) {
      cin >> arr[i]; // 입력
    }
    sort(arr, arr + size);
    for (int i = 0; i < size; i++) {
      cout << arr[i] << '\n'; // 출력
    }
}