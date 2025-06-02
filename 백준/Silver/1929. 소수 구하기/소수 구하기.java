import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static boolean[] state = new boolean[1000002];

    public static void main(String[] args) throws IOException {
        String[] parts = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
        m = Integer.parseInt(parts[0]);
        n = Integer.parseInt(parts[1]);
        for (int i = 2; i * i <= n; i++) {
            if (state[i]) continue;
            for (int j = i * i; j <= n; j += i) {
                state[j] = true;
            }
        }
        state[1] = true;
        List<Integer> result = new ArrayList<>();
        for (int i = m; i <= n; i++) {
            if (!state[i]) result.add(i);
        }
        result.forEach(System.out::println);
    }
}
