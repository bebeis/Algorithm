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
                    int cur = tree.getOrDefault(val, 0);
                    tree.put(val, cur + 1);
                } else if (tree.isEmpty()) {
                    continue;
                } else {
                    int key = 0;
                    if (parts[1].equals("-1")) {
                        key = tree.firstKey();
                    } else {
                        key = tree.lastKey();
                    }
                    int val = tree.get(key);
                    if (val == 1) {
                        tree.remove(key);
                    } else {
                        tree.put(key, val - 1);
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
