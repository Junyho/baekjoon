import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int n,m;
    static int[][] friend_graph;

    static boolean[] visited;

    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        m=Integer.parseInt(br.readLine());
        friend_graph = new int[n + 1][n + 1];
        visited = new boolean[n+1];
        visited[1] = true;


        for(int i=0;i<m;i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int f1 = Integer.parseInt(st.nextToken());
            int f2 = Integer.parseInt(st.nextToken());
            friend_graph[f1][f2]=1;
            friend_graph[f2][f1]=1;

        }
        System.out.println(check());

    }
    static int check(){

        int count =0;

        for(int i=0;i<n+1;i++) {
            if (friend_graph[1][i] == 1) {
                q.add(i);
                count+=1;
                visited[i]=true;
            }
        }
        while(!q.isEmpty())
        {
            int cur = q.remove();
            for(int i=0;i<n+1;i++)
            {
                if(friend_graph[cur][i]==1 && !visited[i])
                {
                    visited[i]=true;
                    count+=1;
                }
            }
        }
        return count;

    }

}