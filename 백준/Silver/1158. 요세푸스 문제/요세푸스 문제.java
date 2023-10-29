
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=0;i<N;i++)
		{
			q.add(i+1);
		}
		StringBuilder sb = new StringBuilder();
		sb.append('<');
		for(int i=0;i<K-1;i++)
		{
			q.add(q.remove());
		}
		sb.append(q.remove());
		while(!q.isEmpty())
		{
			sb.append(',');
			sb.append(' ');
			for(int i=0;i<K-1;i++)
			{
				q.add(q.remove());
			}
			sb.append(q.remove());
			
			
		}
	
		sb.append('>');
		System.out.println(sb);

	}

}
