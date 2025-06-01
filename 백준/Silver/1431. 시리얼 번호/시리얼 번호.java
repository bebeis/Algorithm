import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> words = new ArrayList<>();
        while (n-- > 0) {
            words.add(br.readLine());
        }
        Collections.sort(words, (s1, s2) -> {
            if (s1.length() == s2.length()) {
                int sum1 = s1.chars().filter(Character::isDigit).map(c -> (c - '0')).sum();
                int sum2 = s2.chars().filter(Character::isDigit).map(c -> (c - '0')).sum();
                if (sum1 != sum2) {
                    return sum1 - sum2;
                } else {
                    return s1.compareTo(s2);
                }
            } else {
                return s1.length() - s2.length();
            }
        });
        words.forEach(System.out::println);
    }
}
