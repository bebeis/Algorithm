import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] ids = new int[500002];
    static int[] prev = new int[1000002];
    static int[] next = new int[1000002];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ids[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            int curId = ids[i];
            int prevId = ids[(i - 1 + n) % n];
            int nextId = ids[(i + 1) % n];
            prev[curId] = prevId;
            next[curId] = nextId;
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("BN")) {
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                int nextNodeId = next[i];
                sb.append(nextNodeId).append('\n');
                prev[j] = i;
                next[j] = nextNodeId;
                next[i] = j;
                prev[nextNodeId] = j;
            } else if (command.equals("BP")) {
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                int prevNodeId = prev[i];
                sb.append(prevNodeId).append('\n');
                prev[j] = prevNodeId;
                next[j] = i;
                next[prevNodeId] = j;
                prev[i] = j;
            } else if (command.equals("CN")) {
                int i = Integer.parseInt(st.nextToken());
                int closedNodeId = next[i];
                sb.append(closedNodeId).append('\n');
                int nextNodeId = next[closedNodeId];
                next[i] = nextNodeId;
                prev[nextNodeId] = i;
            } else {
                int i = Integer.parseInt(st.nextToken());
                int closedNodeId = prev[i];
                sb.append(closedNodeId).append('\n');
                int prevNodeId = prev[closedNodeId];
                next[prevNodeId] = i;
                prev[i] = prevNodeId;
            }
        }

        System.out.print(sb);
    }
}
