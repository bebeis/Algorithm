#include <bits/stdc++.h>
using namespace std;


struct Point {
    int x, y;
};

vector<Point> pointsX; // x좌표 기준 정렬
int n;

inline int getDistance(const Point& lhs, const Point& rhs) {
    return (lhs.x - rhs.x) * (lhs.x - rhs.x) + (lhs.y - rhs.y) * (lhs.y - rhs.y);
}

int closestPair(int start, int end) {
    // 점 하나의 거리는 없으니 최대값 리턴
    if (start == end) {
        return INT_MAX;
    }
    
    // 점이 두 개 남으면 사이의 거리 리턴
    if (end - start == 1) {
        return getDistance(pointsX[start], pointsX[end]);
    }

    int mid = (start + end) / 2;
    int minDist = min(closestPair(start, mid), closestPair(mid + 1, end));
    
    // x축 기준으로 후보 점들을 찾는다.
    vector<Point> targetPoints;
    for (int i = start; i <= end; ++i) {
        if ((pointsX[mid].x - pointsX[i].x) * (pointsX[mid].x - pointsX[i].x) < minDist) {
            targetPoints.push_back(pointsX[i]);
        }
    }

    // y축 기준 정렬
    sort(targetPoints.begin(), targetPoints.end(), [](const Point& a, const Point& b) {
        return a.y < b.y;
    });

    int t = targetPoints.size();
    for (int i = 0; i < t - 1; ++i) {
        for (int j = i + 1; j < t; ++j) {
            if ((targetPoints[j].y - targetPoints[i].y) * (targetPoints[j].y - targetPoints[i].y) < minDist) {
                minDist = min(minDist, getDistance(targetPoints[i], targetPoints[j]));
            } else {
                break;
            }
        }
    }

    return minDist;
}

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    
    cin >> n;
    pointsX.resize(n);
    for (int i = 0; i < n; ++i) {
        cin >> pointsX[i].x >> pointsX[i].y;
    }
    
    // x축 기준 정렬
    sort(pointsX.begin(), pointsX.end(), [](const Point& a, const Point& b) {
        return a.x < b.x;
    });
    
    cout << closestPair(0, n - 1);
}
