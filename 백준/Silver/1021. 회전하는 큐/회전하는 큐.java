import java.io.*;
import java.util.*;

/**
 * 문제: 원하는 원소를 뽑아내기 위해서 필요한 최소 이동 회수 구하기
 * 시뮬레이션으로 풀기엔 너무 오래 걸림
 * 그리디하게 판단해야 함
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        CustomQueue queue = new CustomQueue(n);

        st = new StringTokenizer(br.readLine());
        int result = 0;
        while (m-- > 0) {
            int target = Integer.parseInt(st.nextToken());
            result += queue.command(target);
        }
        System.out.print(result);
    }

    static class CustomQueue {
        Deque<Integer> queue = new ArrayDeque<>();

        CustomQueue(int size) {
            for (int i = 1; i <= size; i++) queue.offer(i);
        }

        void rotateLeft() {
            int first = queue.pollFirst();
            queue.offerLast(first);
        }

        void rotateRight() {
            int last = queue.pollLast();
            queue.offerFirst(last);
        }

        int command(int target) {
            int idx = findIdx(target);
            int half = queue.size() / 2 + 1;

            Runnable rotator = (idx <= half) ? this::rotateLeft : this::rotateRight;

            int cnt = 0;
            while (queue.peekFirst() != target) {
                rotator.run();
                cnt++;
            }

            queue.pollFirst();
            return cnt;
        }


        int findIdx(int target) {
            int idx = 1;
            for (int x : queue) {
                if (x == target) return idx;
                idx++;
            }
            return -1;
        }
    }
    // 1 2 3 4 5 홀수: size / 2 + 1 까지
    // 1 2 3 4 5 6 짝수: size / 2 + 1 까지

}