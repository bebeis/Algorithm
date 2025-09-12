import java.io.*;
import java.util.*;

public class Main {

    public static int[] failure(String s) {
        int[] f = new int[s.length()];
        int j = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = f[j - 1];
            }

            if (s.charAt(i) == s.charAt(j)) {
                f[i] = ++j;
            }
        }
        return f;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String p = br.readLine();

        int[] f = failure(p);
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != p.charAt(j)) {
                j = f[j - 1];
            }
            if (s.charAt(i) == p.charAt(j)) j++;
            if (j == p.length()) {
                System.out.print(1);
                return;
            }
        }
        System.out.print(0);
    }
}
