import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static long[] state = new long[10];

    static int bitCount(long x) {
        int ret = 0;
        for (int i = 0; i < Math.max(n, m); i++) {
            if (((x >> i) & 1L) == 1L) ret++;
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String list = st.nextToken();

            for (int j = m - 1; j >= 0; j--) {
                state[i] = (state[i] << 1) | (list.charAt(j) == 'Y' ? 1L : 0L);
            }
        }

        int maxSongs = 0;
        int minGuitars = -1;

        for (int mask = 1; mask < (1 << n); mask++) {
            long comb = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    comb |= state[i];
                }
            }
            int songNum = bitCount(comb);
            int guitarNum = bitCount(mask);

            if (maxSongs < songNum) {
                maxSongs = songNum;
                minGuitars = guitarNum;
            } else if (maxSongs == songNum && minGuitars > guitarNum) {
                minGuitars = guitarNum;
            }
        }

        System.out.println(minGuitars);
    }
}
