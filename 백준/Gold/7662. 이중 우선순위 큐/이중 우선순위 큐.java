import java.io.*;
import java.util.*;

/**
 * 방법 1: TreeMap 하나로 keySet()으로 우선순위 파악해서 풀이
 * 방법 2: 우선순위 큐 두 개 두고 풀이
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            DualQueue dq = new DualQueue();
            while (k-- > 0) {
                String[] parts = br.readLine().split(" ");
                if (parts[0].equals("I")) {
                    dq.insert(Integer.parseInt(parts[1]));
                } else if (parts[1].equals("1")) {
                    dq.deleteMax();
                } else {
                    dq.deleteMin();
                }
            }

            if (dq.isEmpty()) {
                sb.append("EMPTY\n");
                continue;
            }

            sb.append(dq.maxValue()).append(' ').append(dq.minValue()).append('\n');
        }
        System.out.print(sb);
    }

    static class DualQueue {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        void insert(int val) {
            map.merge(val, 1, Integer::sum);
        }

        void deleteMax() {
            if (map.isEmpty()) return;
            map.compute(map.lastKey(), (k, v) -> v == 1 ? null : v - 1);
        }

        void deleteMin() {
            if (map.isEmpty()) return;
            map.compute(map.firstKey(), (k, v) -> v == 1 ? null : v - 1);
        }

        boolean isEmpty() {
            return map.isEmpty();
        }

        int maxValue() {
            return map.lastKey();
        }

        int minValue() {
            return map.firstKey();
        }
    }
}
