import java.io.*;
import java.util.*;

public class Main {

    /*
     * DP 문제는
1. 먼저 DP 문제임을 파악해야 한다. 중복되는 부문제 구조를 갖고 있는지를 확인한다.
2. 이후, 구하고자 하는 바를 파악한다. 문제의 최종 출력(답)을 생각한 후, 그 답을 만들기 위해 어떤 정보가 필요할지 고민하자. 필요한 최소만의 정보를 상태로 도출하여 테이블, 그래프…로 표현한다.
3. DP 문제는 상태 전이를 결정하는 것이 무엇인지 파악하는게 중요하다. 그래야 점화식을 세울 수 있다. 현재 상태가 되기 위해 어떤 선택지를 고려할 수 있을지 생각하자. 이 과정에서 상태를 다시 수정할 수도 있다.
4. 이 방식으로 접근되지 않으면, 탑 다운으로 문제를 쪼개서 어떻게 답이 구성되는지 생각해보자.

    1. 브루트 포스 ->최대 2^1000. 중복되는 부문제 구조 있음 -> DP로 복잡도를 낮추자.
    2. 구하고자 하는 것: 카드를 N개 구매했을 때 금액의 최댓값. {구매한 개수, 금액}
    해당 개수에서의 최대 금액을 유지해보자.
    3. 점화식 세우기: d[i] = max(d[i], d[i - k] + p[k]) (i, k에 대한 2중 for문)
     */

    static int n;
    static int[] p = new int[1002];
    static int[] d = new int[1002];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }

        // O(N^2)
        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= i; k++) {
                d[i] = Math.max(d[i], d[i - k] + p[k]);
            }
        }

        System.out.print(d[n]);

    }
}