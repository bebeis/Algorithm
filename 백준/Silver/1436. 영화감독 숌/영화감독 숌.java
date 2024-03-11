import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0, temp = 665;
        while (count != n) {
            temp++;
            if (Integer.toString(temp).contains("666")) {
                count++;
            }
        }
        System.out.print(temp);
    }
}
