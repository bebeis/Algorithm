import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.HashMap;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] arr2 = arr.clone();
        Arrays.sort(arr2);
        int temp = 0;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(arr2[i])) {
                map.put(arr2[i], temp);
                temp++;
            }
        }
        for (int i = 0; i < n; i++) {
            sb.append(map.get(arr[i]) + " ");
        }
        System.out.print(sb);
    }
}
