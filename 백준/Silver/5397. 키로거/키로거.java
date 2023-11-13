import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {



    static Stack<Character>stack1 = new Stack<>();
    static Stack<Character>stack2 = new Stack<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++)
        {
            String tmp = br.readLine();
            password(tmp);
        }

    }

    static void password(String tmp){

        for(char ch : tmp.toCharArray())
        {
            if(ch=='<')
            {
                if(!stack1.isEmpty())
                    stack2.push(stack1.pop());

            }
            else if(ch=='>')
            {
                if(!stack2.isEmpty())
                    stack1.push(stack2.pop());
            }
            else if(ch=='-')
            {
                if(!stack1.isEmpty())
                    stack1.pop();
            }
            else
            {
                stack1.push(ch);
            }
        }
        while(!stack1.isEmpty())
            stack2.push(stack1.pop());

        StringBuilder sb = new StringBuilder();
        while(!stack2.isEmpty())
            sb.append(stack2.pop());

        System.out.println(sb);
    }




}