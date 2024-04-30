#include <iostream>
using namespace std;

string fullString;
int count;

void hanoi(int bottom, int source, int dest) {
    int new_dest;
    for (int i = 1; i <= 3; i++) {
        if (source != i && dest != i) {
            new_dest = i;
        }
    }
    if (bottom < 2) {
        fullString += (to_string(source) + " " + to_string(dest) + '\n');
        ::count++;
        return;
    }
    hanoi(bottom - 1, source, new_dest);
    fullString += (to_string(source) + " " + to_string(dest) + '\n');
    ::count++;
    hanoi(bottom - 1, new_dest, dest);
}

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    ::count = 0;
    ::fullString = "";
    int n;
    cin >> n;
    hanoi(n, 1, 3);
    cout << ::count << '\n';
    cout << ::fullString;
}