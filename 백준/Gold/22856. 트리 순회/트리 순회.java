import java.io.*;
import java.util.*;

/**
 * 유사 중위 순회
 * - 왼쪽 자식 노드가 있고 방문하지 않았다면 왼쪽으로 이동
 * - 그렇지 않으면 오른쪽 자식 노드가 있고 방문하지 않았다면 오른쪽
 * - 유사 현재 노드가 유사 중위 순회 끝이라면 종료
 * - 그렇지 않고 부모 노드가 존재하면 부모 노드로 이동
 * 
 * 유사 중위 순회를 하면서 이동한 횟수??
 * 
 * 유사 중위 순회의 끝을 판별하는 기준 -> 지금까지 방문한 노드의 수 == 총 노드의 개수 -> 잘못된 판단
 */

public class Main {

    static int n;
    static int[] lc = new int[100002];
    static int[] rc = new int[100002];
    static int[] p = new int[100002];
    static boolean[] visited = new boolean[100002];
    static int lastNode = 0;
    static boolean finished = false;
    static int moveCnt = 0;

    public static void inOrder(int cur) {
        if (lc[cur] != 0) inOrder(lc[cur]);
        lastNode = cur;
        if (rc[cur] != 0) inOrder(rc[cur]);
    }

    public static void simInOrder(int cur) {
        visited[cur] = true;

        if (lc[cur] != 0 && !visited[lc[cur]]) {
            moveCnt++;
            simInOrder(lc[cur]);
        }

        
        if (rc[cur] != 0 && !visited[rc[cur]]) {
            moveCnt++;
            simInOrder(rc[cur]);
        } 

        if (finished) return;
        
        if (lastNode == cur) {
            finished = true;
            return;
        }

        moveCnt++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (b != -1) {
                lc[a] = b;
                p[b] = a;
            }
            if (c != -1) {
                rc[a] = c;
                p[c] = a;
            }
        }

        inOrder(1);
        simInOrder(1);
        System.out.print(moveCnt);
    }
}