import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push":
                    queue.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if (queue.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(queue.poll()).append('\n');
                    break;
                case "size":
                    sb.append(queue.size()).append('\n');
                    break;
                case "empty":
                    sb.append(queue.isEmpty() ? 1 : 0).append('\n');
                    break;
                case "front":
                    if (queue.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(queue.peek()).append('\n');
                    break;
                case "back":
                    if (queue.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(queue.peekLast()).append('\n');
                    break;
            }
        }

        System.out.print(sb);
    }
}
