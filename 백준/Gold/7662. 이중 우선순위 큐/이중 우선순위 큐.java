import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            TreeMap<Integer, Integer> tree = new TreeMap<>();
            int k = Integer.parseInt(br.readLine());

            while (k-- > 0) {
                String[] parts = br.readLine().split(" ");
                if (parts[0].equals("I")) {
                    int val = Integer.parseInt(parts[1]);
                    tree.merge(val, 1, Integer::sum);
                } else if (!tree.isEmpty()) {
                    if (parts[1].equals("-1")) {
                        tree.compute(tree.firstKey(), (k1, v) -> (v == 1) ? null : v - 1);
                    } else {
                        tree.compute(tree.lastKey(), (k1, v) -> (v == 1) ? null : v - 1);
                    }
                }
            }
            if (tree.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                sb.append(tree.lastKey()).append(' ').append(tree.firstKey()).append('\n');
            }
        }
        
        System.out.print(sb);
    }
}
