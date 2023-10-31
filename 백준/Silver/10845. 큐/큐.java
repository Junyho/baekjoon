
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
		
		Queue<Integer> q = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i=0;i<N;i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if(cmd.equals("push"))
			{
				int num = Integer.parseInt(st.nextToken());
				q.add(num);
			}
			else if(cmd.equals("pop"))
			{
				if(!q.isEmpty())
					System.out.println(q.remove());
				else {
					System.out.println("-1");
				}
			}
			else if(cmd.equals("size"))
			{
				System.out.println(q.size());
			}
			else if(cmd.equals("empty"))
			{
				if(q.isEmpty())
					System.out.println("1");
				else {
					System.out.println("0");
				}
			}
			else if(cmd.equals("front"))
			{
				if(q.isEmpty())
					System.out.println("-1");
				else {
					System.out.println(q.element());
				}
			}
			else if(cmd.equals("back"))
			{
				int tmp = -1;
				if (q.isEmpty()) {
					System.out.println("-1");
				}
				else {
					Queue<Integer> q2 = new LinkedList<>();
					while(!q.isEmpty())
						{
						tmp = q.remove();
						q2.add(tmp);
						}
					System.out.println(tmp);
					q = q2;
				}
			}
		}

	}

}
