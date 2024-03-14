import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        HashSet<String> words = new HashSet<>(); 
        int count = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            words.add(br.readLine());
        }
        for (int i = 0; i < m; i++) {
            if (words.contains(br.readLine())) {
                count++;
            }
        }
        System.out.print(count);
    }
}
