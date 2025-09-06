import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int x;
    static int y;
    static int[][] maps = new int[22][22];
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { 1, -1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }
/**
 * 지도의 각 칸에 정수
 * 주사위가 이동한 지도 칸에 쓰여잇는 수가 0 -> 주사위 바닥면에 있는 수가 지도 칸에 복사됨
 * 그외는, 지도 칸에 쓰여 있는 수가 주사위 바닥면으로 복사되고, 지도 칸에 쓰여있는 수는 0이됨
 * 지도 바깥으로 이동시켜려고 하는 경우 명령을 무시하고 출력 금지
 * 주사위를 놓은 곳의 좌표 + 이동 명령 -> 이동했을 때마다 상단에 쓰여 있는 값은?
 */

        Dice dice = new Dice();
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        while (k-- > 0) {
            int dir = Integer.parseInt(st.nextToken()) - 1;
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            dice.move(dir);
            x = nx;
            y = ny;
            if (maps[nx][ny] == 0) {
                maps[nx][ny] = dice.getBottomNumber();
            } else {
                dice.setBottomNumber(maps[nx][ny]);
                maps[nx][ny] = 0;
            }
            sb.append(dice.getTopNumber()).append('\n');
        }
        System.out.print(sb);
    }

    /**
 * 1. 이동할 때 마다 주사위 6면의 상태를 유지해야 함
 * 2. 다음 이동 위치에서 어떤 면이 바닥에 닿을 지 판별해야 함
 */

    static class Dice {
        int[][] figure = new int[4][3];

        public int getTopNumber() {
            return figure[1][1];
        }

        public void setBottomNumber(int num) {
            figure[3][1] = num;
        }

        public int getBottomNumber() {
            return figure[3][1];
        }

        public void move(int dir) {
            int tmp = figure[1][1];
            // 동쪽
            if (dir == 0) {
                // (1, 1) -> (1, 2)
                // (1, 2) -> (3, 1)
                // (3, 1) -> (1, 0)
                // (1, 0) -> (1, 1)
                figure[1][1] = figure[1][0];
                figure[1][0] = figure[3][1];
                figure[3][1] = figure[1][2];
                figure[1][2] = tmp;
            } 
            // 서쪽
            else if (dir == 1) {
                /**
                 * (1, 1) -> (1, 0)
                 * (1, 0) -> (3, 1)
                 * (3, 1) -> (1, 2)
                 * (1, 2) -> (1, 1)
                 */
                figure[1][1] = figure[1][2];
                figure[1][2] = figure[3][1];
                figure[3][1] = figure[1][0];
                figure[1][0] = tmp;
            }
            // 북쪽
            else if (dir == 2) {
                /**
                 * (1, 1) -> (0, 1)
                 * (0, 1) -> (3, 1)
                 * (3, 1) -> (2, 1)
                 * (2, 1) -> (1, 1)
                 */
                figure[1][1] = figure[2][1];
                figure[2][1] = figure[3][1];
                figure[3][1] = figure[0][1];
                figure[0][1] = tmp;
            } 
            // 남쪽
            else {
                /**
                 * (1, 1) -> (2, 1)
                 * (2, 1) -> (3, 1)
                 * (3, 1) -> (0, 1)
                 * (0, 1) -> (1, 1)
                 */
                figure[1][1] = figure[0][1];
                figure[0][1] = figure[3][1];
                figure[3][1] = figure[2][1];
                figure[2][1] = tmp;
            }
        }
    }
}