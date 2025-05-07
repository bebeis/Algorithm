import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
        int max = -1 * 0x3f3f3f3f;
        int min = 0x3f3f3f3f;
        String[] strings = s.split(" ");
        for (String number : strings) {
            int num = Integer.parseInt(number);
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        return min + " " + max;
    }
}