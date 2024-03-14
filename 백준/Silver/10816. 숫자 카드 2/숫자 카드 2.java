import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        HashMap<Integer, Integer> cards = new HashMap<>(); 
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer temp;
        for (int i = 0; i < n; i++) {
            temp = Integer.parseInt(st.nextToken());
            if (!cards.containsKey(temp)) {
                cards.put(temp, 1);
            }
            else {
                cards.put(temp, cards.get(temp) + 1);
            }
        }
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            temp = cards.get(Integer.parseInt(st.nextToken()));
            if (temp == null) {
                sb.append("0 ");
            }
            else {
                sb.append(temp + " ");
            }
        }
        System.out.print(sb);
    }
}