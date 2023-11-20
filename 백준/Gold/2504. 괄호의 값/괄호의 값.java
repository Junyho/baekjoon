import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int result = 0;
        int multi = 1;

        char last = ' ';

        for(char ch : str.toCharArray()) {
            
            if (ch == '(')
            {
                stack.push(ch);
                multi *= 2;
            }
            else if(ch == '[')
            {
                stack.push(ch);
                multi *= 3;
            }
            else if (ch == ')')
            {
                if(stack.isEmpty() || !stack.peek().equals('('))
                {
                    result = 0;
                    break;
                }
                else
                {
                    if(last == '(')
                        result += multi;
                    stack.pop();
                    multi/=2;

                }
            }
            else if (ch == ']')
            {
                if(stack.isEmpty() || !stack.peek().equals('['))
                {
                    result = 0;
                    break;
                }
                else
                {
                    if(last == '[')
                        result += multi;
                    stack.pop();
                    multi/=3;
                }
            }
            last = ch;
        }

        System.out.println(!stack.isEmpty() ? 0 : result);
    }
}