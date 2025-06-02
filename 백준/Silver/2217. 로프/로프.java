import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] arr = new int[100002];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr, 0, n);
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i] * (n - i));
        }
        System.out.print(max);
    }
}
