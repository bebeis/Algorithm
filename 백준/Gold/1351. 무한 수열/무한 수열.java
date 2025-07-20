import java.io.*;
import java.util.*;

// N이 10^12 -> bottom up으로 모든 걸 구하면 불가능
// An = A_n/p + A_n/q 이용 (top-down)
// 10^12만큼 테이블 만드는 것도 불가능 -> 해시

// 틀린 이유 : Long 값 입력받는데, 습관적으로 parseInt 로 읽음
// map.putIfAbsent(key, value) -> key가 존재하지 않은 경우에만 value를 계산하는게 아니라, 호출 시점에 이미 계산되서 넘어감
// 람다 등을 이용해서 계산 지연 하는거 아니면, 쓰면 안됨!

public class Main {

    static Map<Long, Long> map = new HashMap<>();
    static long n;
    static int p;
    static int q;

    public static long dp(long cur) {
        if (cur == 0) return 1;
        if (map.containsKey(cur)) {
            return map.get(cur);
        }
        long res = dp(cur / p) + dp(cur / q);
        map.put(cur, res);
        return res;
    }

    public static void main(String[] args) throws IOException {
        String[] parts = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
        n = Long.parseLong(parts[0]);
        p = Integer.parseInt(parts[1]);
        q = Integer.parseInt(parts[2]);
        System.out.print(dp(n));
    }
}