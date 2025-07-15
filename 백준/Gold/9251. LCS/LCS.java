import java.io.*;
import java.util.*;

// O(n^2)까지 가능

public class Main {

    static String f;
    static String s;
    static int d[][] = new int[1002][1002]; // first가 i이고, second가 j일 때 최대 수열 길이

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        f = br.readLine();
        s = br.readLine();

        for (int i = 1; i <= f.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                if (f.charAt(i - 1) == s.charAt(j - 1)) {
                    d[i][j] = d[i - 1][j - 1] + 1;
                } else {
                    d[i][j] = Math.max(d[i - 1][j], d[i][j - 1]);
                }
            }
        }

        System.out.print(d[f.length()][s.length()]);
    }
}