import java.io.*;
import java.util.*;

/**
 * 문제: 수열에서 연속된 수의 부분합이 S이상이 되는 것 중 가장 짧은 것의 길이 구하기
 * - 모든 쌍을 브루트포스로 풀면 시간 초과 O(nlogn) 이하로 풀이해야 함
 * - 연속된 수 -> 정렬은 불가능하지만, "구간"을 다룰 수 있음
 * - 이전 구간의 정보를 다음 구간에 재활용할 수 있다는 점 -> 슬라이딩 윈도우로 해결
 */
class Main {

    static int n;
    static int s;
    final static int INF = 100002;
    static int[] arr = new int[INF];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(solve());
    }

    public static int solve() {
        int minLength = 100002;
        int head = 0, tail = 0;
        int sum = arr[0];
        while (head < n && tail < n) {
            if (head == tail && sum >= s) {
                return 1;
            }

            if (sum >= s) {
                minLength = Math.min(minLength, head - tail + 1);
                sum -= arr[tail++];
            } else {
                head++;
                if (head < n) {
                    sum += arr[head];
                }
            }
        }
        return minLength == INF ? 0 : minLength;
    }
}