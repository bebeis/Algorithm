import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Pair> stack = new ArrayDeque<Pair>();
        stack.push(new Pair(100000001, 0));
        for (int i = 1; i <= n; i++) {
            int input =  Integer.parseInt(st.nextToken());

            while (stack.peek().x < input) {
                stack.pop();
            }

            sb.append(stack.peek().y).append(' ');
            stack.push(new Pair(input, i));
        }

        System.out.println(sb);
    }

    public static class Pair {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}