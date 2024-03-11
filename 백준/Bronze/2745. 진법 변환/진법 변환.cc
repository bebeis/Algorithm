#include <iostream>
#include <cmath>
using namespace std;

int main(void) {
    string input;
    int n, sum = 0;
    cin >> input >> n;
    // A의 아스키 코드 : 65, A는 10
    for (int i = 0; i < input.length(); i++) {
        if (input[i] >= 65) {
            sum += (input[i] - 55) * pow(n, input.length() - 1 - i);
        }
        else {
            sum += (input[i] - 48) * pow(n, input.length() - 1 - i);
        }
    }
    cout << sum;
}