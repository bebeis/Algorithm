import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        String temp;
        String last = "";
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            temp = st.nextToken();
            switch (temp) {
                case "push":
                last = st.nextToken();
                queue.add(Integer.parseInt(last));
                break;

                case "pop":
                if (queue.isEmpty()) {
                    sb.append(-1).append("\n");
                }
                else {
                    sb.append(queue.poll()).append("\n");
                }
                break;

                case "size":
                sb.append(queue.size()).append("\n");
                break;

                case "empty":
                if (queue.isEmpty()) {
                    sb.append(1).append("\n");
                }
                else {
                    sb.append(0).append("\n");
                }
                break;

                case "front":
                if (queue.isEmpty()) {
                    sb.append(-1).append("\n");
                }
                else {
                    sb.append(queue.peek()).append("\n");
                }
                break;

                case "back":
                if (queue.isEmpty()) {
                    sb.append(-1).append("\n");
                }
                else {
                    sb.append(last).append("\n");
                }
                break;
            }
        }
        System.out.print(sb);
    }
}
