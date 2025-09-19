import java.io.*;
import java.util.*;

/**
 * 트라이 자료구조
 */

public class Main {

    final static int ROOT = 1;
    final static int MX = 10000 * 500 + 5;

    static int unused = 2;
    static int[][] nxt = new int[MX][26];
    static boolean[] chk = new boolean[MX];

    public static void insert(String s) {
        int cur = ROOT;
        for (int i = 0; i < s.length(); i++) {
            if (nxt[cur][ctoi(s.charAt(i))] == -1) {
                nxt[cur][ctoi(s.charAt(i))] = unused++;
            }
            cur = nxt[cur][ctoi(s.charAt(i))];
        }
        chk[cur] = true;
    }

    public static boolean find(String s) {
        int cur = ROOT;
        for (int i = 0; i < s.length(); i++) {
            if (nxt[cur][ctoi(s.charAt(i))] == -1) {
                return false;
            }
            cur = nxt[cur][ctoi(s.charAt(i))];
        }
        return chk[cur];
    }

    public static int ctoi(char c) {
        return c - 'a';
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        for (int i = 0; i < MX; i++) {
            Arrays.fill(nxt[i], 0, 26, -1);
        }

        while (n-- > 0) {
            insert(br.readLine());
        }

        int cnt = 0;
        while (m-- > 0) {
            if (find(br.readLine())) cnt++;
        }

        System.out.print(cnt);

    }
}