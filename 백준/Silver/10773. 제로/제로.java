import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> money = new Stack<>();
        int k = Integer.parseInt(br.readLine());
        int temp;
        int moneySum = 0;
        for (int i = 0; i < k; i++) {
            temp = Integer.parseInt(br.readLine());
            if (temp == 0) {
                money.pop();
            }
            else {
                money.push(temp);
            }
        }
        for (int i = 0; i < money.size(); i++) {
            moneySum += money.get(i);
        }
        System.out.print(moneySum);
    }
}