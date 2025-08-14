import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int p;
    static char[][] board = new char[1002][1002];
    static int[] s = new int[10];
    static int[] castle = new int[10];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= p; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j);
                if (Character.isDigit(board[i][j])) {
                    castle[board[i][j] - '0']++;
                }
            }
        }

        Queue<int[]>[] queues = new Queue[p + 1];
        for (int i = 1; i <= p; i++) queues[i] = new ArrayDeque<>();
    
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (Character.isDigit(board[i][j])) {
                    int player = board[i][j] - '0';
                    queues[player].offer(new int[]{i, j});
                }
            }
        }

        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] != '.') visited[i][j] = true;
            }
        }

        boolean anyMove;
        do {
            anyMove = false;
            for (int player = 1; player <= p; player++) {
                if (queues[player].isEmpty()) continue;

                Queue<int[]> curQueue = new ArrayDeque<>();
                Queue<int[]> nextQueue = new ArrayDeque<>();
                curQueue.addAll(queues[player]);
                queues[player].clear();

                int moveLimit = s[player];
                for (int move = 0; move < moveLimit && !curQueue.isEmpty(); move++) {
                    int size = curQueue.size();
                    for (int k = 0; k < size; k++) {
                        int[] pos = curQueue.poll();
                        int x = pos[0], y = pos[1];

                        for (int dir = 0; dir < 4; dir++) {
                            int nx = x + dx[dir];
                            int ny = y + dy[dir];

                            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                            if (visited[nx][ny] || board[nx][ny] != '.') continue;

                            visited[nx][ny] = true;
                            board[nx][ny] = (char)(player + '0');
                            castle[player]++;
                            nextQueue.offer(new int[]{nx, ny});
                        }
                    }
                    curQueue.addAll(nextQueue);
                    nextQueue.clear();
                }

                if (!curQueue.isEmpty()) {
                    queues[player].addAll(curQueue);
                    anyMove = true;
                }
            }
        } while (anyMove);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= p; i++) sb.append(castle[i]).append(' ');
        System.out.print(sb);
    }
}
