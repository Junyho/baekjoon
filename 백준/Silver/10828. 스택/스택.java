
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {
	
	
	
	public static void main(String[] args) throws IOException{
		
		Stack<Integer> stack=new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		
		for(int i=0;i<N;i++)
		{
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			
			if(cmd.equals("push"))
			{
				int X = Integer.parseInt(st.nextToken());
				stack.push(X);
			}
			else if(cmd.equals("pop"))
			{
				if(stack.isEmpty())
					System.out.println("-1");
				else {
					System.out.println(stack.pop());
				}
				
			}
			else if(cmd.equals("size"))
			{
				System.out.println(stack.size());
			}
			else if(cmd.equals("empty"))
			{
				if(stack.isEmpty())
					System.out.println("1");
				else {
					System.out.println("0");
				}
			}
			else if(cmd.equals("top"))
			{
				if (stack.isEmpty())
					System.out.println("-1");
				else {
					int top = stack.pop();
					stack.push(top);
					System.out.println(top);
					
				}
			}
		}
		
		
	}
}

