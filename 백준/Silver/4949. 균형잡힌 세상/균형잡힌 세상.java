import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static Stack<Character> stack = new Stack<>();


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        while(!str.equals("."))
        {
            int balance=1;
            for(char ch: str.toCharArray())
            {
                if(ch=='(')
                    stack.push(ch);
                else if(ch==')')
                {
                    if(!stack.isEmpty()&&stack.peek().equals('(')) {
                        stack.pop();
                    }
                    else{
                        System.out.println("no");
                        balance = 0;
                        break;
                    }

                }
                else if(ch=='[')
                    stack.push(ch);
                else if(ch==']')
                {
                    if(!stack.isEmpty()&&stack.peek().equals('[')) {
                        stack.pop();
                    }
                    else{
                        System.out.println("no");
                        balance=0;
                        break;
                    }

                }
                else continue;
            }
            if(!stack.isEmpty() && balance==1)
            {
                balance=0;
                System.out.println("no");
            }

            while(!stack.isEmpty())
                stack.pop();

            if(balance==1)
                System.out.println("yes");

            str = br.readLine();

        }



    }


}