import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int order;
        Stack<Integer> inst = new Stack<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            order = Integer.parseInt(st.nextToken());
            switch (order) {
                case 1:
                    inst.push(Integer.parseInt(st.nextToken()));
                    break;
                case 2:
                    if (inst.empty()) {
                        sb.append(-1).append("\n");
                    }
                    else {
                        sb.append(inst.pop()).append("\n");
                    }
                    break;
                case 3:
                    sb.append(inst.size()).append("\n");
                    break;
                case 4:
                    if (inst.empty()) {
                        sb.append(1).append("\n");
                    }
                    else {
                        sb.append(0).append("\n");
                    }
                    break;
                case 5:
                    if (inst.empty()) {
                        sb.append(-1).append("\n");
                    }
                    else {
                        sb.append(inst.peek()).append("\n");
                    }
                    break;
            }
        }
        System.out.print(sb);
    }
}
