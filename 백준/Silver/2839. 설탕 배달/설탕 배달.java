import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int min = 1667;
        int bag5 = n / 5;
        int rest, bag3;
        while (bag5 >= 0) {
            rest = n - 5 * bag5;
            if ((rest % 3) == 0) {
                bag3 = rest / 3;
                if ((bag5 + bag3) < min) {
                    min = bag5 + bag3;
                }
            }
            bag5--;
        }
        if (min == 1667) {
            min = -1;
        }
        System.out.print(min);
    }
}
