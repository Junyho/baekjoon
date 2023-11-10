import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {




    public static void main(String[] args) throws IOException {

       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       Stack<Character> stack = new Stack<>();

       int N = Integer.parseInt(br.readLine());
       int count = 0;
       for (int i=0;i<N;i++)
       {
           String word = br.readLine();
           if(word.length()%2==1)
               continue;
           else{
               for(char ch : word.toCharArray()){
                   if(stack.isEmpty())
                       stack.push(ch);
                   else{
                       if(stack.peek().equals(ch))
                           stack.pop();
                       else
                           stack.push(ch);
                   }
               }
           }

           if(stack.isEmpty())
               count+=1;

           while(!stack.isEmpty())
               stack.pop();



       }
       System.out.println(count);







    }

}