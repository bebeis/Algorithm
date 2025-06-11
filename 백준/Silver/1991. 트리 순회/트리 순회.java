import java.io.*;
import java.util.*;

public class Main {

    static int[] lc = new int[27];
    static int[] rc = new int[27];
    static int n;
    static final int NO_CHILD = '.' - 'A';
    static StringBuilder sb = new StringBuilder();

    public static void preOrder(int cur) {
        sb.append((char) (cur + 'A'));
        if (lc[cur] != NO_CHILD) preOrder(lc[cur]);
        if (rc[cur] != NO_CHILD) preOrder(rc[cur]);
    }

    public static void inOrder(int cur) {
        if (lc[cur] != NO_CHILD) inOrder(lc[cur]);
        sb.append((char) (cur + 'A'));
        if (rc[cur] != NO_CHILD) inOrder(rc[cur]);
    }

    public static void postOrder(int cur) {
        if (lc[cur] != NO_CHILD) postOrder(lc[cur]);
        if (rc[cur] != NO_CHILD) postOrder(rc[cur]);
        sb.append((char) (cur + 'A'));
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            int cur = line.charAt(0) - 'A';
            int left = line.charAt(2) - 'A';
            int right = line.charAt(4) - 'A';
            lc[cur] = left;
            rc[cur] = right;
        }
        preOrder(0);
        sb.append('\n');

        inOrder(0);
        sb.append('\n');

        postOrder(0);
        System.out.print(sb);
    }
}
