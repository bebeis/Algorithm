import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int r;
    static int c;

    public static int recursive(int cx, int cy, int cn) {
        if (cn == 0) {
            return 1;
        }
        int halfLength = (int) Math.pow(2, cn - 1);
        int quarterSize = (int) Math.pow(2, 2 * cn - 2);
        // cx + 2 ^ (n - 1)
        // cy + 2 ^ (n - 1)

        if (r < cx + halfLength && c < cy + halfLength) {
            return recursive(cx, cy, cn - 1);
        } else if (r < cx + halfLength && c >= cy + halfLength) {
            return recursive(cx, cy + halfLength, cn - 1) + quarterSize;
        } else if (r >= cx + halfLength && c < cy + halfLength) {
            return recursive(cx + halfLength, cy, cn - 1) + 2 * quarterSize;
        } else {
            return recursive(cx + halfLength, cy + halfLength, cn - 1) + 3 * quarterSize;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        n = Integer.parseInt(parts[0]);
        r = Integer.parseInt(parts[1]);
        c = Integer.parseInt(parts[2]);
        System.out.print(recursive(0, 0, n) - 1);
    }
}
