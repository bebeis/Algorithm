import java.io.*;
import java.util.*;

public class Main {

    // 21억번 나누는 것도 어려움. O(B)을, log scale로 낮춰서 O(logB)로 해결해보자.
    // 짝수: a ^ b % c = ((a^(b/2) % c) * (a^(b/2) % c)) % c
    // 홀수: a ^ b % c = ((a^(b/2) % c) * (a^(b/2) % c) * a) % c
    // (x^2 % c)  = (x % c)^2 % c
    // 2 ^ 7 % 5 == 3 ==  ((2 ^ 3) % 5) ^ 2 * 2 % c


    public static long calculate(long a, long b, long c) {
        if (b == 1) {
            return a % c;
        }
        if (b % 2 == 0) {
            long sub = calculate(a, b / 2, c);
            return (sub * sub) % c;
        }
        
        long sub = calculate(a, b / 2, c);
        return (((sub * sub) % c) * (a % c)) % c;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        long a = Long.parseLong(strings[0]);
        long b = Long.parseLong(strings[1]);
        long c = Long.parseLong(strings[2]);
        System.out.print(calculate(a, b, c));

    }
}
