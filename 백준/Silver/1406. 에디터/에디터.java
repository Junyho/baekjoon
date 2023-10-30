
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = Integer.parseInt(br.readLine());
		
		Stack<String> left = new Stack<>();
		Stack<String> right = new Stack<>();
		
		String[] arr = str.split("");
		
		for(String s: arr)
			left.push(s);
		
		
		for(int i=0;i<N;i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			
			if(cmd.equals("P"))
			{
				String ch = st.nextToken();
				left.push(ch);
				
			}
			else if(cmd.equals("L"))
			{
				if(!left.isEmpty())
					right.push(left.pop());
				
			}
			else if(cmd.equals("D"))
			{
				if(!right.isEmpty())
					left.push(right.pop());
			}
			else if(cmd.equals("B"))
			{
				if(!left.isEmpty())
					left.pop();
				
			}
			
			
			
		}
		while(!left.isEmpty())
			right.push(left.pop());
		
		StringBuilder sb = new StringBuilder();
		
		while(!right.isEmpty())
			sb.append(right.pop());
	
		System.out.println(sb);
		
		

	}

}
