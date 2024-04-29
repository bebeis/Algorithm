#include <iostream>
using namespace std;

int count;

int recursion(string &s, int l, int r){
    ::count++;
    if(l >= r) return 1;
    else if(s[l] != s[r]) return 0;
    else return recursion(s, l+1, r-1);
}

int isPalindrome(string &s){
    return recursion(s, 0, s.length() - 1);
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int n, k;
    string temp;
    cin >> n;
    while (n--) {
        ::count = 0;
        cin >> temp;
        cout << isPalindrome(temp) << " " << ::count << '\n';
    }
}