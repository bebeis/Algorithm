import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException { 
        Deque<Integer> deque = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int temp;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            temp = Integer.parseInt(st.nextToken());
            switch (temp) {
                case 1:
                deque.addFirst(Integer.parseInt(st.nextToken()));
                break;
                case 2:
                deque.add(Integer.parseInt(st.nextToken()));
                break;
                case 3:
                if (deque.isEmpty()) {
                    sb.append(-1).append("\n");
                }
                else {
                    sb.append(deque.poll()).append("\n");
                }
                break;
                case 4:
                if (deque.isEmpty()) {
                    sb.append(-1).append("\n");
                }
                else {
                    sb.append(deque.pollLast()).append("\n");
                }
                break;
                case 5:
                sb.append(deque.size()).append("\n");
                break;
                case 6:
                if (deque.isEmpty()) {
                    sb.append(1).append("\n");
                }
                else {
                    sb.append(0).append("\n");
                }
                break;
                case 7:
                if (deque.isEmpty()) {
                    sb.append(-1).append("\n");
                }
                else {
                    sb.append(deque.peek()).append("\n");
                }
                break;
                case 8:
                if (deque.isEmpty()) {
                    sb.append(-1).append("\n");
                }
                else {
                    sb.append(deque.peekLast()).append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}
