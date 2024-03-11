#include <iostream>
#include <stack>
using namespace std;

int main(void) {
    int n, b, x, y, temp;
    stack<int> data;
    cin >> n >> b;
    while (n != 0) {
        x = n / b;
        y = n % b;
        data.push(y);
        n = x;
    }
    while (!data.empty()) {
        temp = data.top();
        data.pop();
        if (temp >= 10) {
            cout << char(temp + 55);
        }
        else {
            cout << temp;
        }
    }
}