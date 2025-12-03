import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> inputs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            inputs.add(br.readLine());
        }

        Collections.sort(inputs, (s1, s2) -> {
            // 1.
            if (s1.length() != s2.length()) {
                return s1.length() - s2.length();
            }

            // 2. 
            int s1Val = getVal(s1);
            int s2Val = getVal(s2);
            if (s1Val != s2Val) {
                return s1Val - s2Val;
            }

            // 3.
            return s1.compareTo(s2);
        });

        StringBuilder sb = new StringBuilder();
        inputs.forEach(s -> sb.append(s).append('\n'));
        System.out.print(sb);
    }

    private static int getVal(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                sum += (c - '0');
            }
        }
        return sum;
    }
}