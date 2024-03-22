import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {

    public static boolean checkMatching(final String line) {
        Stack<Character> bracket = new Stack<>();
        char ch, open_ch;
        for (int i = 0; i < line.length(); i++) {
            ch = line.charAt(i);
            switch (ch) {
                case '(' :
                case '[' : 
                case '{' :
                    bracket.push(ch);
                    break;
                case ')' :
                case ']' :
                case '}' :
                    if (bracket.empty()) {
                        return false;
                    }
                    else {
                        open_ch = bracket.pop();
                        if ((open_ch == '(' && ch != ')') || (open_ch == '[' && ch != ']') || (open_ch == '{' && ch != '}')) {
                            return false;
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        if (!bracket.empty()) {
            return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;
        while(true) {
            line = br.readLine();
            if (line.charAt(0) == '.') {
                break;
            }
            if (checkMatching(line) == true) {
                sb.append("yes").append("\n");
            }
            else {
                sb.append("no").append("\n");
            }
        }
        System.out.print(sb);
    }
}
