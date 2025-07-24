import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    static int n;
    static int m;
    static Node[] nodes = new Node[1000002]; // 고유 번호 I 노드
    static int[] ids = new int[500002];

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

        Arrays.setAll(nodes, i -> new Node());

        for (int i = 0; i < n; i++) {
            int curId = ids[i];
            int prevId = ids[Math.floorMod((i - 1), n)];
            int nextId = ids[Math.floorMod((i + 1), n)];
            nodes[curId].prevId = prevId;
            nodes[curId].nextId = nextId;
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("BN")) {
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                int nextNodeId = nodes[i].nextId;
                sb.append(nextNodeId).append('\n');
                nodes[j].prevId = i;
                nodes[j].nextId = nextNodeId;

                nodes[i].nextId = j;
                nodes[nextNodeId].prevId = j;
            } else if (command.equals("BP")) {
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                int prevNodeId = nodes[i].prevId;
                sb.append(prevNodeId).append('\n');
                nodes[j].prevId = prevNodeId;
                nodes[j].nextId = i;

                nodes[prevNodeId].nextId = j;
                nodes[i].prevId = j;
            } else if (command.equals("CN")) {
                int i = Integer.parseInt(st.nextToken());
                int closedNodeId = nodes[i].nextId;
                sb.append(closedNodeId).append('\n');
                int nextNodeId = nodes[closedNodeId].nextId;

                nodes[i].nextId = nextNodeId;
                nodes[nextNodeId].prevId = i;
            } else {
                int i = Integer.parseInt(st.nextToken());
                int closedNodeId = nodes[i].prevId;
                sb.append(closedNodeId).append('\n');
                int prevNodeId = nodes[closedNodeId].prevId;

                nodes[prevNodeId].nextId = i;
                nodes[i].prevId = prevNodeId;
            }
        }
        System.out.print(sb);
    }

    static class Node {
        int prevId;
        int nextId;

        public Node() {}

        public Node(int prev, int next) {
            this.prevId = prev;
            this.nextId = next;
        }
    }
}