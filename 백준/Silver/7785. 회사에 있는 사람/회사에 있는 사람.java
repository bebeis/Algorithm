import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        HashSet<String> nameSet = new HashSet<>(); 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        String name, status;
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            name = st.nextToken();
            status = st.nextToken();
            if (status.equals("enter")) {
                nameSet.add(name);
            }
            else {
                nameSet.remove(name);
            }
        }
        String[] arr = nameSet.toArray(new String[0]);
        Arrays.sort(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]).append("\n");
        }
        System.out.print(sb);
    }
}
