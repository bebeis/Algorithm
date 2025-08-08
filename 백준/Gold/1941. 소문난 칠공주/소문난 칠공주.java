import java.io.*;
import java.util.*;

/**
 * 7명은 반드시 인접해 있어야 한다.
 * 반드시 이다솜파 학생일 필요는 없음 but 이다솜파가 반드시 우위를 점해야 함.(4명이상)
 */

public class Main {

    public static char[] seat = new char[25];
    static int result = 0;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[] visited = new boolean[25];

    public static boolean isAdjusted() {
        boolean[] check = new boolean[25];
        int count = 1;

        Queue<Integer> queue = new ArrayDeque<>();
        int start = 0;
        for (int i = 0; i < 25; i++) {
            if (visited[i]) {
                start = i;
                break;
            }
        }
        queue.offer(start);
        check[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int cx = cur / 5;
            int cy = cur % 5;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;

                int nextPos = 5 * nx + ny;

                if (visited[nextPos] && !check[nextPos]) {
                    check[nextPos] = true;
                    queue.offer(nextPos);
                    count++;
                }
            }
        }

        return count == 7;
    }

    public static void backtracking(int totalCnt, int yCnt, int before) {
        if (totalCnt == 7) {
            if (isAdjusted()) {
                result++;
                return;
            }
        }

        for (int i = before + 1; i < 25; i++) {
            int nyCnt = yCnt + (seat[i] == 'Y' ? 1 : 0);
            if (nyCnt >= 4) continue;

            visited[i] = true;
            backtracking(totalCnt + 1, nyCnt, i);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            for (int j = 0; j < 5; j++) {
                seat[5 * i + j] = line.charAt(j);
            }
        }
        backtracking(0, 0, -1);
        System.out.print(result);
    }
}