import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        HashMap<String, String> nameKey = new HashMap<>(); 
        HashMap<String, String> numberKey = new HashMap<>(); 
        StringBuilder sb = new StringBuilder();
        String temp;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (Integer i = 1; i <= n; i++) {
            temp = br.readLine();
            nameKey.put(temp, i.toString());
            numberKey.put(i.toString(), temp);
        }
        for (int i = 0; i < m; i++) {
            temp = br.readLine();
            if (nameKey.containsKey(temp)) {
                sb.append(nameKey.get(temp)).append("\n");
            }
            else {
                sb.append(numberKey.get(temp)).append("\n");
            }
        }
        System.out.print(sb);
    }
}
