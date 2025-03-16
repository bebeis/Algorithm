import java.io.*;
import java.util.*;

// 며칠 동안 무궁화호, ITX-새마을, ITX-청춘은 무료
// S-Train과 V-Train은 50% 할인된 가격으로 이용할 수 있습니다
// KTX나 지하철, 또는 다른 교통수단에 대해서는 할인이 적용되지 않음

// 내일로를 구매했을 경우, (최소비용 + 내일로) 값과, 내일로를 구매하지 않은 경우 값을 비교하여 판단

public class Main {

    static int n, r, m, k;
    static Map<String, Integer> nameMap = new HashMap<>();
    static int[] targets = new int[203];
    static int[][][] adj = new int[2][102][102];
    static final int INF = 0x3f3f3f3f;

    public static int getDiscountInfo(String transfortation) {
        if (transfortation.equals("Mugunghwa") 
        || transfortation.equals("ITX-Saemaeul")
        || transfortation.equals("ITX-Cheongchun")) {
            return 2;
        } else if (transfortation.equals("S-Train") || transfortation.equals("V-Train")) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        r *= 2;
        int citycnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adj[1][i][j] = INF;
                adj[0][i][j] = INF;
            }
            adj[1][i][i] = 0;
            adj[0][i][i] = 0;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nameMap.putIfAbsent(st.nextToken(), citycnt++);
        }

        m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            targets[i] = nameMap.get(st.nextToken());
        }

        k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            String t = st.nextToken();
            int s = nameMap.get(st.nextToken());
            int e = nameMap.get(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            c *= 2;
            c = Math.min(adj[0][s][e], c);
            adj[0][s][e] = adj[0][e][s] = c;

            int code = getDiscountInfo(t);
            if (code == 1) c /= 2;
            else if (code == 2) c = 0;

            c = Math.min(adj[1][s][e], c);
            adj[1][s][e] = adj[1][e][s] = c;
        }

        for (int q = 0; q < citycnt; q++)
            for (int i = 0; i < citycnt; i++)
                for (int j = 0; j < citycnt; j++)
                    for (int z = 0; z < 2; z++) adj[z][i][j] = Math.min(adj[z][i][j], adj[z][i][q] + adj[z][q][j]);
    
        for (int i = 1; i < m; i++) {
            int s = targets[i - 1];
            int e = targets[i];
            r -= adj[0][s][e];
            r += adj[1][s][e];
        }

        if (r < 0) System.out.print("Yes");
        else System.out.print("No");
    }
    
}