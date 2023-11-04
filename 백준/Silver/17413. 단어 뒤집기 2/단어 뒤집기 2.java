import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {
    public static void main(String[] args) throws IOException {

        Stack<Character> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int select = 0;
        String target = br.readLine();


        for (char ch : target.toCharArray()) {
            if (ch == '<') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                select = 1;
                sb.append(ch);
            } else if (ch == '>') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(ch);
                select = 0;

            } else if (ch == ' ') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(ch);
            } else {
                if (select == 1)
                    sb.append(ch);
                else
                    stack.push(ch);
            }


        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);

    }
}