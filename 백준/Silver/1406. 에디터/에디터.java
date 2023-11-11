import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static Stack<Character> stack1 = new Stack<>();
    static Stack<Character> stack2 = new Stack<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        for(char ch : str.toCharArray())
            stack1.push(ch);
        int M = Integer.parseInt(br.readLine());
        for(int i=0;i<M;i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if(cmd.equals("L"))
            {
                if(!stack1.isEmpty())
                    stack2.push(stack1.pop());
            }
            else if(cmd.equals("D"))
            {
                if(!stack2.isEmpty())
                    stack1.push(stack2.pop());

            }
            else if(cmd.equals("B"))
            {
                if(!stack1.isEmpty())
                    stack1.pop();
            }
            else if(cmd.equals("P"))
            {
                char p = st.nextToken().charAt(0);
                stack1.push(p);
            }

        }
        while(!stack1.isEmpty())
            stack2.push(stack1.pop());

        StringBuilder sb= new StringBuilder();
        while(!stack2.isEmpty())
            sb.append(stack2.pop());


        System.out.println(sb);

    }
}