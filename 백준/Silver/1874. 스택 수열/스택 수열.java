import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {

	
	
	public static void main(String[] args) throws IOException {
		
		Stack<Integer> st = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int order = 0;
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<n;i++)
		{
			int num = Integer.parseInt(br.readLine());
			
			if(num > order)
			{
				for(int j=order+1;j<=num;j++)
				{
					st.push(j);
					sb.append('+').append('\n');
				}
				order = num;
			}
			else if(st.peek() != num){
				System.out.println("NO");
				return;
			}
			
			st.pop();
			sb.append('-').append('\n');
			
			
			
		}
		System.out.println(sb);
		
		
				
	}
}