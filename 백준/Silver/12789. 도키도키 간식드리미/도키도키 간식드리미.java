import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> students = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        int temp, min = 1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            temp = Integer.parseInt(st.nextToken());
            if (temp == min) {
                min += 1;
            }
            else {
                students.push(temp);
            }
            while (!students.empty() && students.peek() == min) {
                students.pop();
                min += 1;
            } 
        }
        if (students.empty()) {
            System.out.print("Nice");
        } else {
            System.out.print("Sad");
        }
    }
}
