import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static int gcd(int a, int b) {
        int r;
        while (b != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    public static int gcd_n(int[] arr) {
        int a = arr[0];
        for (int item : arr) {
            a = gcd(a, item);
        }
        return a;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] trees = new int[n];
        trees[0] = Integer.parseInt(br.readLine());
        for (int i = 1; i < n; i++) {
            trees[i] = Integer.parseInt(br.readLine()) - trees[0];
        }
        trees[0] = 0;
        int bcd = gcd_n(trees);
        System.out.print(trees[n - 1] / bcd + 1 - n);
    }
}
