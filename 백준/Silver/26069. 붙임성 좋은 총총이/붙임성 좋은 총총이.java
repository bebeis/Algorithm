import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> hashSet = new HashSet<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        String a, b;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a = st.nextToken();
            b = st.nextToken();
            if (hashSet.contains("ChongChong")) {
                if (hashSet.contains(a)) {
                    hashSet.add(b);
                }
                else if (hashSet.contains(b)) {
                    hashSet.add(a);
                }
            }
            else if (a.equals("ChongChong") || b.equals("ChongChong")) {
                hashSet.add(a);
                hashSet.add(b);
            }
        }
        System.out.print(hashSet.size());
    }
}