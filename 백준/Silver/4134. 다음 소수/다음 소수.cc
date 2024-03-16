#include <iostream>

using namespace std;

bool isPrime(long long num) 
{
    if (num <= 1) 
        return false;

    if (num == 2 || num == 3) 
        return true;

    if (num % 2 == 0 || num % 3 == 0)
        return false;

    for (long long i = 5; i * i <= num; ++i) 
    {
        if (num % i == 0 || num % (i + 2) == 0) 
            return false;
    }

    return true;
}

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int x;
    long long n;
    cin >> x;
    for (int i = 0; i < x; i++) {
        cin >> n;
        while (!isPrime(n)) { n++; }
        cout << n << '\n';
    }
}