import java.io.*;
import java.util.*;


public class Main {

    final static int ROOT = 1;
    static int unused = 2;
    final static int MX = 10000 * 500 + 5;
    static boolean[] check = new boolean[MX];
    static int[][] nxt = new int[MX][26];

    public static int ctoi(char c) {
        return c - 'a';
    }

    public static void insert(String s) {
        int cur = ROOT;
        for (int i = 0; i < s.length(); i++) {
            if (nxt[cur][ctoi(s.charAt(i))] == -1) {
                nxt[cur][ctoi(s.charAt(i))] = unused++;
            }
            cur = nxt[cur][ctoi(s.charAt(i))];
        }
    }

    public static boolean find(String s) {
        int cur = ROOT;
        for (int i = 0; i < s.length(); i++) {
            if (nxt[cur][ctoi(s.charAt(i))] == -1) {
                return false;
            }
            cur = nxt[cur][ctoi(s.charAt(i))];
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] params = br.readLine().split(" ");
        int n = Integer.parseInt(params[0]);
        int m = Integer.parseInt(params[1]);
        for (int i = 0; i < MX; i++) {
            Arrays.fill(nxt[i], 0, 26, -1);
        }

        int cnt = 0;
        while (n-- > 0) {
            insert(br.readLine());
        }

        while (m-- > 0) {
            if (find(br.readLine())) cnt++;
        }

        System.out.print(cnt);
    }
}