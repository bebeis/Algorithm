import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int i = 1; i <= n; i++) list.add(i);
        int cur = m - 1;
        while (!list.isEmpty()) {
            cur %= list.size();
            int tmp = list.remove(cur);
            sb.append(tmp);
            if (!list.isEmpty()) sb.append(", ");
            cur += m - 1;
        }
        sb.append(">");
        System.out.print(sb);
    }
}