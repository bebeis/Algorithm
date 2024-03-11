#include <iostream>
#include <vector>
using namespace std;

int main(void) {
    int n, sum, i;
    vector<int> data;
    while (1) {
        cin >> n;
        if (n == -1) {
            break;
        }
        data.clear();
        sum = 0;
        i = 0;
        while (n != ++i) {
            if (n % i == 0) {
                sum += i;
                data.push_back(i);
            }
        }
        if (n != sum) {
            cout << n << " is NOT perfect.";
        }
        else {
            cout << n << " = 1";
            for (int k = 1; k < data.size(); k++) {
                cout << " + " << data[k]; 
            }
        }
        cout << '\n';
    }
}