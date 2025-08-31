import java.io.*;
import java.util.*;

/**
 * 가방 당 보석 하나라는 걸 놓치고 폴어서 처음에 잘못품
 */

public class Main {

    static int n;
    static int k;
    static List<Pair> jewels = new ArrayList<>();
    static TreeMap<Integer, Integer> bags = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewels.add(new Pair(m, v));
        }

        for (int i = 0; i < k; i++) {
            int cap = Integer.parseInt(br.readLine());
            bags.merge(cap, 1, Integer::sum);
        }

        jewels.sort((a, b) -> b.value - a.value);

        long costSum = 0;
        for (Pair jewel : jewels) {
            Integer bag = bags.ceilingKey(jewel.weight);
            if (bag == null) continue;

            costSum += jewel.value;
            if (bags.get(bag) == 1) {
                bags.remove(bag);
            } else {
                bags.put(bag, bags.get(bag) - 1);
            }
        }

        System.out.println(costSum);
    }

    static class Pair {
        int weight;
        int value;

        public Pair(int w, int v) {
            weight = w;
            value = v;
        }
    }
}
