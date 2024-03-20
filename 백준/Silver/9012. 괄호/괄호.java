import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String temp1;
        Boolean status;
        Stack<String> bracket;
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            bracket = new Stack<>();
            temp1 = br.readLine();
            status = true;
            for (int j = 0; j < temp1.length(); j++) {
                if (temp1.charAt(j) == '(') {
                    bracket.push("(");
                }
                else {
                    if (bracket.empty()) {
                        status = false;
                        break;
                    }
                    else {
                        bracket.pop();
                    }
                }
            }
            if (bracket.empty() && status == true) {
                sb.append("YES").append("\n");
            }
            else {
                sb.append("NO").append("\n");
            }
        }
        System.out.print(sb);
    }
}
