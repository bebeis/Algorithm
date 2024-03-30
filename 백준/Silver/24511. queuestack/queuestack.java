import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Deque<Integer> queue = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        int temp;
        for (int i = 0; i < n; i++) {
            temp = Integer.parseInt(st.nextToken());
            if (arr[i] == 0) {
                queue.add(temp);
            }
        }

        int m = Integer.parseInt(br.readLine());
        // st = new StringTokenizer(br.readLine());
        int queueSize = queue.size();
        if (queueSize == 0) {
            System.out.print(br.readLine());
            return;
        }
        else if (m > queueSize) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < queueSize; i++) {
                bw.write(queue.pollLast() + " ");
            }
            for (int i = 0; i < m - queueSize; i++) {
                bw.write(st.nextToken() + " ");
            }
        }
        else if (m == queueSize) {
            for (int i = 0; i < queueSize; i++) {
                bw.write(queue.pollLast() + " ");
            }
        }
        else {
            for (int i = 0; i < m; i++) {
                bw.write(queue.pollLast() + " ");
            }
        }
        bw.flush();
        bw.close();
    }
}