import java.io.*;
import java.util.*;

/**
 * 20개의 상태를 나타내기 위해 INT형 4바이트 20개를 사용하는 건 낭비일 수 있다.
 * 비트마스킹을 이용하여 각 비트가 하나의 상태를 나타내도록 하자.
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        int state = 0; // 숫자 20개가 INT 32비트 중 하위 20개를 사용하여 각 비트를 나타냄
        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("add")) {
                int num = Integer.parseInt(st.nextToken());
                state |= (1 << (num - 1));
            } else if (command.equals("remove")) {
                int num = Integer.parseInt(st.nextToken());
                state &= (~(1 << (num - 1)));
            } else if (command.equals("check")) {
                int num = Integer.parseInt(st.nextToken());
                sb.append((state >> (num - 1)) & 1).append('\n');
            } else if (command.equals("toggle")) {
                int num = Integer.parseInt(st.nextToken());
                state ^= (1 << (num - 1));
            } else if (command.equals("all")) {
                state = 0xfffff;
            } else {
                state = 0;
            }
        }
        System.out.print(sb);
    }
}