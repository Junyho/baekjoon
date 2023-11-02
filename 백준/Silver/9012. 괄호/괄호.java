import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {

	
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i=0;i<n;i++)
		{
			Stack<Character> st = new Stack<>();
			String str = br.readLine();
			int flag=0;
			
			for(char ch:str.toCharArray())
			{
				if(ch=='(')
				{
					st.push(ch);
				}
				else {
					if(st.isEmpty())
						{
						flag=1;
						break;
						}
					else {
						st.pop();
					}
					
				}
			}
			if (st.isEmpty() && flag==0)
				System.out.println("YES");
			else {
				System.out.println("NO");
			}
		}
		
		
		
		
				
	}
}