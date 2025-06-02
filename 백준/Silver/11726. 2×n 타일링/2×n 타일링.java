import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] d = new int[1002];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        // d[n] = d[n - 1] + d[n - 2]
        d[0] = 1;
        d[1] = 1;
        for (int i = 2; i <= n; i++) {
            d[i] = (d[i - 1] + d[i - 2]) % 10007;
        }
        System.out.print(d[n]);
    }
}
