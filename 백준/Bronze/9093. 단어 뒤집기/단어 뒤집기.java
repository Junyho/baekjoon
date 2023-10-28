
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {
	
	
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		Stack<Character> stack = new Stack<>();
		
		
		for(int i=0;i<T;i++)
		{
			StringBuilder sb = new StringBuilder();
				String a = br.readLine();
				for (char c: a.toCharArray())
				{
					
					if(c==' '||c=='\n')
					{
						while(!stack.isEmpty())
							sb.append(stack.pop());
						sb.append(' ');
					}
					else {
						stack.add(c);
					}
				}
				while(!stack.isEmpty())
					sb.append(stack.pop());
				sb.append(' ');
				
				System.out.println(sb);
		}
		
		
		
		
		
	}
}

