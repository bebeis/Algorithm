import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < number.length(); i++) {
            arr.add(number.charAt(i) - '0');
        }
        Collections.sort(arr);
        Collections.reverse(arr);
        for (int a : arr) {
            System.out.print(a);
        }
    }
}
