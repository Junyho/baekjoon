import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {

	
	
	public static void main(String[] args) throws IOException {
		
		Stack<Character> st = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		char[] arr = str.toCharArray();
		int count = 0;
		
		char last = arr[0];
		st.push(last);
		
		for(int i=1;i<arr.length;i++)
		{
			
			if(last=='(')
			{
				if (arr[i] == '(')
					st.push(arr[i]);
				else {
					st.pop();
					count += st.size();
				}
			}
			else {
				
				if (arr[i] == '(')
					st.push(arr[i]);
				else {
					st.pop();
					count += 1;
				}
				
			}
			
			last = arr[i];
			
		
		}
		System.out.println(count);
		
		
		
		
				
	}
}