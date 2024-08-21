#include <bits/stdc++.h>
#define MAX 19
using namespace std;

// time limit 1초 --> O(n^6)까지 가능할 듯
// 왼쪽부터 출력해야 하는 조건을 빼먹어서 반례검사에서 한 번 걸림
// case 1. - , case 2. | , case 3. \ , case 4. /
int arr[MAX + 1][MAX + 1];
pair<int ,int> initPos;

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    for (int i = 1; i <= MAX; i++) {
        for (int j = 1; j <= MAX; j++) {
            cin >> arr[i][j];
        }
    }
    
    // 가로로 연속 5개가 존재하는지 체크 (흑돌)
    for (int i = 1; i <= MAX; i++) {
        int cnt = 0;
        for (int j = 1; j <= MAX; j++) {
            if (arr[i][j] == 1) {
                if (cnt == 0) initPos = {i, j};
                cnt++;
            } else if (cnt == 5) {
                cout << "1\n" << initPos.first << ' ' << initPos.second;
                return 0;
            } else if (cnt > 0) cnt = 0;
        }
        if (cnt == 5) {
            cout << "1\n" << initPos.first << ' ' << initPos.second;
            return 0;
        }
    }

    // 가로로 연속 5개가 존재하는지 체크 (백돌)
    for (int i = 1; i <= MAX; i++) {
        int cnt = 0;
        for (int j = 1; j <= MAX; j++) {
            if (arr[i][j] == 2) {
                if (cnt == 0) initPos = {i, j};
                cnt++;
            } else if (cnt == 5) {
                cout << "2\n" << initPos.first << ' ' << initPos.second;
                return 0;
            } else if (cnt > 0) cnt = 0;
        }
        if (cnt == 5) {
            cout << "2\n" << initPos.first << ' ' << initPos.second;
            return 0;
        }
    }
    // 세로로 연속 5개가 존재하는지 체크 (흑돌)
    for (int i = 1; i <= MAX; i++) {
        int cnt = 0;
        for (int j = 1; j <= MAX; j++) {
            if (arr[j][i] == 1) {
                if (cnt == 0) initPos = {j, i};
                cnt++;
            } else if (cnt == 5) {
                cout << "1\n" << initPos.first << ' ' << initPos.second;
                return 0;
            } else if (cnt > 0) cnt = 0;
        }
        if (cnt == 5) {
            cout << "1\n" << initPos.first << ' ' << initPos.second;
            return 0;
        }
    }

    // 세로로 연속 5개가 존재하는지 체크 (백돌)
    for (int i = 1; i <= MAX; i++) {
        int cnt = 0;
        for (int j = 1; j <= MAX; j++) {
            if (arr[j][i] == 2) {
                if (cnt == 0) initPos = {j, i};
                cnt++;
            } else if (cnt == 5) {
                cout << "2\n" << initPos.first << ' ' << initPos.second;
                return 0;
            } else if (cnt > 0) cnt = 0;
        }
        if (cnt == 5) {
            cout << "2\n" << initPos.first << ' ' << initPos.second;
            return 0;
        }
    }
    // i = j + k
    // 대각선 \ 로 연속 5개가 존재하는지 체크 (흑돌)
    for (int k = 0; k <= 14; k++) {
        int cnt = 0;
        for (int j = 1; j <= MAX - k; j++) {
            int i = j + k;
            if (arr[i][j] == 1) {
                if (cnt == 0) initPos = {i, j};
                cnt++;
            } else if (cnt == 5) {
                cout << "1\n" << initPos.first << ' ' << initPos.second;
                return 0;
            } else if (cnt > 0) cnt = 0;
        }
        if (cnt == 5) {
            cout << "1\n" << initPos.first << ' ' << initPos.second;
            return 0;
        }
    }
    // i = j - k (k: 1 ~ 14) 
    for (int k = 1; k <= 14; k++) {
        int cnt = 0;
        for (int i = 1; i <= MAX - k; i++) {
            int j = i + k;
            if (arr[i][j] == 1) {
                if (cnt == 0) initPos = {i, j};
                cnt++;
            } else if (cnt == 5) {
                cout << "1\n" << initPos.first << ' ' << initPos.second;
                return 0;
            } else if (cnt > 0) cnt = 0;
        }
        if (cnt == 5) {
            cout << "1\n" << initPos.first << ' ' << initPos.second;
            return 0;
        }
    }
    // i = j + k
    // 대각선 \ 로 연속 5개가 존재하는지 체크 (백돌)
    for (int k = 0; k <= 14; k++) {
        int cnt = 0;
        for (int j = 1; j <= MAX - k; j++) {
            int i = j + k;
            if (arr[i][j] == 2) {
                if (cnt == 0) initPos = {i, j};
                cnt++;
            } else if (cnt == 5) {
                cout << "2\n" << initPos.first << ' ' << initPos.second;
                return 0;
            } else if (cnt > 0) cnt = 0;
        }
        if (cnt == 5) {
            cout << "2\n" << initPos.first << ' ' << initPos.second;
            return 0;
        }
    }
    // i = j - k (k: 1 ~ 14) 
    for (int k = 1; k <= 14; k++) {
        int cnt = 0;
        for (int i = 1; i <= MAX - k; i++) {
            int j = i + k;
            if (arr[i][j] == 2) {
                if (cnt == 0) initPos = {i, j};
                cnt++;
            } else if (cnt == 5) {
                cout << "2\n" << initPos.first << ' ' << initPos.second;
                return 0;
            } else if (cnt > 0) cnt = 0;
        }
        if (cnt == 5) {
            cout << "2\n" << initPos.first << ' ' << initPos.second;
            return 0;
        }
    }

    // 대각선 / 로 연속 5개가 존재하는지 체크 (흑돌)
    // i + j = k(k: 6 ~ 20)
    for (int k = 6; k <= 20; k++) {
        int cnt = 0;
        for (int j = 1; j < k; j++) {
            int i = k - j;
            if (arr[i][j] == 1) {
                if (cnt == 0) initPos = {i, j};
                cnt++;
            } else if (cnt == 5) {
                cout << "1\n" << initPos.first << ' ' << initPos.second;
                return 0;
            } else if (cnt > 0) cnt = 0;
        }
        if (cnt == 5) {
            cout << "1\n" << initPos.first << ' ' << initPos.second;
            return 0;
        }
    }
    // k: 21 ~ 34
    for (int k = 21; k <= 34; k++) {
        int cnt = 0;
        for (int j = k - MAX; j <= MAX; j++) {
            int i = k - j;
            if (arr[i][j] == 1) {
                if (cnt == 0) initPos = {i, j};
                cnt++;
            } else if (cnt == 5) {
                cout << "1\n" << initPos.first << ' ' << initPos.second;
                return 0;
            } else if (cnt > 0) cnt = 0;
        } 
        if (cnt == 5) {
            cout << "1\n" << initPos.first << ' ' << initPos.second;
            return 0;
        }
    }

    // 대각선 / 로 연속 5개가 존재하는지 체크 (백돌)
    // i + j = k(k: 6 ~ 20)
    for (int k = 6; k <= 20; k++) {
        int cnt = 0;
        for (int j = 1; j < k; j++) {
            int i = k - j;
            if (arr[i][j] == 2) {
                if (cnt == 0) initPos = {i, j};
                cnt++;
            } else if (cnt == 5) {
                cout << "2\n" << initPos.first << ' ' << initPos.second;
                return 0;
            } else if (cnt > 0) cnt = 0;
        }
        if (cnt == 5) {
            cout << "2\n" << initPos.first << ' ' << initPos.second;
            return 0;
        }
    }
    // k: 21 ~ 34
    for (int k = 21; k <= 34; k++) {
        int cnt = 0;
        for (int j = k - MAX; j <= MAX; j++) {
            int i = k - j;
            if (arr[i][j] == 2) {
                if (cnt == 0) initPos = {i, j};
                cnt++;
            } else if (cnt == 5) {
                cout << "2\n" << initPos.first << ' ' << initPos.second;
                return 0;
            } else if (cnt > 0) cnt = 0;
        } 
        if (cnt == 5) {
            cout << "2\n" << initPos.first << ' ' << initPos.second;
            return 0;
        }
    }

    cout << 0;
}