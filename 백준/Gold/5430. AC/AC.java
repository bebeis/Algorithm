import java.io.*;
import java.util.*;
import java.util.stream.*;

// [10, 20, 30]이라는 문자열을 reverse하면, [03, 02, 01]이 된다. 실수 주의!

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            String commands = br.readLine();
            int n = Integer.parseInt(br.readLine());
            Deque<Integer> deque = new ArrayDeque<>();
            String strings = br.readLine();
            String arr[] = strings.substring(1, strings.length() - 1).split(",");
            for (int i = 0; i < n; i++) {
                deque.offer(Integer.parseInt(arr[i]));
            }

            boolean rvsFlag = false;
            boolean errorFlag = false;
            for (int i = 0; i < commands.length(); i++) {
                if (commands.charAt(i) == 'R') {
                    rvsFlag = !rvsFlag;
                    continue;
                }
                if (deque.isEmpty()) {
                    sb.append("error\n");
                    errorFlag = true;
                    break;
                }
                if (rvsFlag) {
                    deque.pollLast();
                    continue;
                }
                deque.pollFirst();
            }
            if (!errorFlag) {
                sb.append('[');
                List<Integer> list = deque.stream().collect(Collectors.toList());
                if (rvsFlag) Collections.reverse(list);
                sb.append(list.stream().map(x -> String.valueOf(x)).collect(Collectors.joining(",")));
                sb.append("]\n");
            }
        }
        System.out.print(sb);
    }
}
