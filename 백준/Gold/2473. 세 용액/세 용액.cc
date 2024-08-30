#include <bits/stdc++.h>
using namespace std;

// 3개의 합 --> 2개 + 1개로 분할해서 생각하자.
// a + b + c => 0에 가장 가깝게 되도록 하는 (a, b)를 찾는다
// c를 순회하면서 a, b 투포인터를 사용하면 O(N^2)에 풀 수 있을 듯

// 틀린 이유 !!!! 주의하자
// long 타입이어도 별도의 타입 캐스팅이 없으면 int 타입 3개를 더할때 반환값이 int 타입으로 값이 반환되어 저장된다.
// 피연산자 중 하나를 캐스탱해주거나, 아니면 배열 자체를 long long으로 설정하자
// 또한, MIN의 초기값을 20억 + 1이 아니라 30억 + 1 이상으로 설정해야 하는데,... 실수했당
int n;
long long MIN = 4e9+1;
long long arr[5001];

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n;
    for (int i = 0; i < n; i++) cin >> arr[i];
    sort(arr, arr + n);
    int result[3];
    for (int c = 0; c < n; c++) {
        // i + j 가 c에 가장 가깝도록 하는 쌍을 찾는다
        int i = 0, j = n - 1;
        if (i == c) i++;
        if (j == c) j--;
        while (i < j) {            
            long long sum = arr[i] + arr[j] + arr[c];
            if (abs(MIN) > abs(sum)) {
                MIN = sum;
                result[0] = arr[i]; result[1] = arr[j]; result[2] = arr[c];
            }
            if (sum < 0) i++;
            else if (sum > 0) j--;
            else break;
            if (i == c) i++;
            if (j == c) j--;
        }
    }
    sort(result, result + 3);
    cout << result[0] << ' ' << result[1] << ' ' << result[2];
}