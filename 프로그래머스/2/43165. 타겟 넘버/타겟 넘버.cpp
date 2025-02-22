#include <string>
#include <vector>

using namespace std;

void dfs(int cur, int sum, int& answer, vector<int> &numbers, int target) {
    if (cur == numbers.size() ) {
        if (sum == target) answer++;
        return;
    }
    dfs(cur + 1, sum - numbers[cur], answer, numbers, target);
    dfs(cur + 1, sum + numbers[cur], answer, numbers, target);
}

int solution(vector<int> numbers, int target) {
    int answer = 0;
    dfs(0, 0, answer, numbers, target);
    return answer;
}