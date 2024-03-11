#include <iostream>
#include <algorithm>
using namespace std;

int main(void) {
    int arr[3];
    while (cin >> arr[0] >> arr[1] >> arr[2]) {
        if (!(arr[0] || arr[1] || arr[2])) {
            break;
        }
        sort(arr, arr + 3);
        if (arr[2] >= (arr[1] + arr[0])) {
            cout << "Invalid" << '\n';
        }
        else if ((arr[0] == arr[1]) && (arr[1] == arr[2])) {
            cout << "Equilateral" << '\n';
        }
        else if ((arr[0] == arr[1]) || (arr[1] == arr[2]) || (arr[0] == arr[2])) {
            cout << "Isosceles" << '\n';
        }
        else {
            cout << "Scalene" << '\n';
        }
    }
}