import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        HashSet<String> listenSet = new HashSet<>();
        ArrayList<String> commonArr = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String buffer;
        for (int i = 0; i < n; i++) {
            listenSet.add(br.readLine());
        }
        for (int i = 0; i < m; i++) {
            buffer = br.readLine();
            if (listenSet.contains(buffer)) {
                commonArr.add(buffer);
            }
        }
        Collections.sort(commonArr);
        sb.append(commonArr.size()).append("\n");
        for (String a : commonArr) {
            sb.append(a).append("\n");
        }
        System.out.print(sb);
    }
}
