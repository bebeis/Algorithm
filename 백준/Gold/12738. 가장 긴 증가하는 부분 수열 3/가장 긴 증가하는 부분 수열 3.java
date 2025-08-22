import java.io.*;
import java.util.*;


/**
 * 기존 방법 : i번째에서, a[i] > a[k]를 만족하는 k 중, d[k]가 최대인 것을 찾았다.
 * d[k]를 찾는 과정에서, O(n)이 소요됨 -> 총 O(n^2)
 * 이 문제는, n <= 1,000,000 -> O(nlogn)이하로 풀이해야 함
 * d[k]를 찾는 과정을 O(logn)으로 처리해야 함.
 * 최댓값을 기록하는 자료구조가 정렬된 상태를 유지하면서, 이분탐색을 이용하는 경우 O(logn) 가능
 * 
 * 1. 어떻게 정렬된 상태로 저장할 것인가? (상태 유지) -> 모노톤 스택? 덱? 배열?
 * 2. 최댓값을 어떻게 찾을 것인가 -> 이분 탐색
 * 10 -> 20 -> 30 -> ... => 1 2 3 
 * 10 -> 20 -> 30 -> 15 -> 20 -> 25
 * d의 key를 길이로 사용
 * d[1] = 10, d[2] = 20, d[3] = 30, d[2] = 15, ...
 * d의 마지막 원소보다 크면 그 뒤에 대입, 그렇지 않으면 이분탐색한 위치에 넣기
 * 시간복잡도 : 최악의 경우 O(nlogn) 
 * 중간에 덮어 쓰더라도, 뒤에있는 d 배열은 이미 기록되어있기 때문에 괜찮다.
 */

public class Main {

    static int n;
    static int[] a = new int[1000002];
    static int[] d = new int[1000002];
    static int length = 1;
    
    // FFFFFTTTT F : d[lo] < target
    public static int lowerBound(int target) {
        int st = 0;
        int ed = length;

        while (st + 1 < ed) {
            int mid = (st + ed) / 2;
            if (d[mid] < target) st = mid;
            else ed = mid;
        }

        return ed;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        d[1] = a[1];
        for (int i = 2; i <= n; i++) {
            if (d[length] < a[i]) {
                d[++length] = a[i];
            } else {
                d[lowerBound(a[i])] = a[i];
            }
        }

        System.out.print(length);

    }
}
