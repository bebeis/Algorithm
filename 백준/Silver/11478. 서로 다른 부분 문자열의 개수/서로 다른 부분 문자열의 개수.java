import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        HashSet<String> stringSet = new HashSet<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        for (int x = 1; x <= input.length(); x++) { // 부분 문자열의 길이
            for (int i = 0; i < input.length() - x + 1; i++) { // 시작 index
                stringSet.add(input.substring(i, i + x));
            }
        }
        System.out.print(stringSet.size());
    }
}
