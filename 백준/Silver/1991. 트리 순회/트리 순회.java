import java.io.*;
import java.util.*;
import java.util.stream.*;

// 문제: 이진 트리에서의 전위/중위/후위 순회를 구현

class Main {
    static final int END = -1;

    static int[] lc = new int[28];
    static int[] rc = new int[28];
    static StringBuilder sb = new StringBuilder();

    private static void preOrder(int cur) {
        sb.append(toChar(cur));
        if (lc[cur] != END) preOrder(lc[cur]);
        if (rc[cur] != END) preOrder(rc[cur]);
    }

    private static void inOrder(int cur) {
        if (lc[cur] != END) inOrder(lc[cur]);
        sb.append(toChar(cur));
        if (rc[cur] != END) inOrder(rc[cur]);
    }

    private static void postOrder(int cur) {
        if (lc[cur] != END) postOrder(lc[cur]);
        if (rc[cur] != END) postOrder(rc[cur]);
        sb.append(toChar(cur));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            List<Integer> parts = Arrays.stream(br.readLine().split(" "))
                .map(Main::toInt)
                .collect(Collectors.toList());

            lc[parts.get(0)] = parts.get(1);
            rc[parts.get(0)] = parts.get(2);
        }

        preOrder(0);
        sb.append('\n');
        inOrder(0);
        sb.append('\n');
        postOrder(0);

        System.out.print(sb);
    }

    private static int toInt(String s) {
        if (s.equals(".")) return END;
        return s.charAt(0) - 'A';
    }

    private static char toChar(int x) {
        return (char) ('A' + x);
    }
}