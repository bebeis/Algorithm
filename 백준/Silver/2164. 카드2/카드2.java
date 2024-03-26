import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException { 
        Queue<Integer> queue = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            queue.add(i + 1);
        }
        while (queue.size() > 1) {
            queue.poll();
            queue.add(queue.poll());
        }
        System.out.print(queue.peek());
    }
}
