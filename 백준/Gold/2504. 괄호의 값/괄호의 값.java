import java.io.*;
import java.util.*;

/**
 * 문제 : 괄호의 수식 치환
 * 구하고자 하는 것: 수식의 결과 (입력이 올바르지 못하면 0)
 * 입력 조건: 길이는 1이상 30이하
 * 출력 조건: X
 */
//
/**
 * 가능한 케이스
 * 열린 괄호: push
 * 닫힌 괄호:
 *  앞에 아무것도 없음: error
 *  앞에 닫힌 괄호: error (그 전에 에러처리됨)
 *  앞에 열린 괄호: 
 *    일치하는 쌍: conv() and add()
 *    일치하지 않는 쌍: error
 *  앞에 숫자:
 *    그 앞에 일치 안함: error 
 *    그 앞에 일치함: mul() and add()
 */

/**
 * 종료 시:
 *   값이 비어있지 않음: error
 *   값이 비어있음: 결과 출력
 */

class Main {

    static Deque<String> stack = new ArrayDeque<>();
    
    public static void main(String[] args) throws IOException {
        String input = new BufferedReader(new InputStreamReader(System.in)).readLine();
        int result = 0;

        for (int i = 0; i < input.length(); i++) {
            String c = input.substring(i, i + 1);
            if (c.equals("(") || c.equals("[")) {
                stack.push(c);
                continue;
            }

            if (stack.isEmpty()) {
                result = 0;
                break;
            }

            int tmp = 1;
            // 닫힌 괄호만 올 수 있음
            if (isDigit(stack.peek())) {
                tmp = Integer.parseInt(stack.pop());
            }

            if (!isMatch(stack.peek(), c)) {
                result = 0;
                break;
            }
            
            int val = getConvertValue(c);
            int added = val * tmp;
            stack.pop();
            if (stack.isEmpty()) {
                result += (added);
            } else {
                if (isDigit(stack.peek())) {
                    added += Integer.parseInt(stack.pop());
                }
                stack.push(String.valueOf(added));
            }
        }

        if (!stack.isEmpty()) result = 0;

        System.out.print(result);
    }

    static boolean isDigit(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) return false;
        }
        return true;
    }

    static int getConvertValue(String c) {
        if (c.equals(")")) return 2;
        else return 3;
    }

    static boolean isMatch(String front, String rear)  {
        if (front.equals("(") && rear.equals(")")) return true;
        if (front.equals("[") && rear.equals("]")) return true;
        return false;
    }
}