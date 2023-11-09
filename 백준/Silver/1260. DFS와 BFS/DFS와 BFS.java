import java.awt.geom.QuadCurve2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static void dfs(int vertex)
    {
        System.out.print(vertex+" ");
        visited[vertex]= true;

        for(int i = 0 ;i<N+1;i++)
        {
            if(graph[vertex][i]==1 && !visited[i])
            {
                dfs(i);
            }
        }

    }
    static Queue<Integer> q = new LinkedList<>();

    static void bfs(int vertex)
    {
        q.add(vertex);
        System.out.print(vertex+" ");
        visited[vertex] = true;

        while(!q.isEmpty())
        {

            int cur = q.remove();

            for(int i=0;i<N+1;i++)
            {
                if(graph[cur][i]==1 && !visited[i])
                {
                    System.out.print(i+" ");
                    visited[i] = true;
                    q.add(i);
                }


            }
        }

    }
    static int N,M,V;
    static int[][]graph;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];


        graph = new int[N+1][N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex = Integer.parseInt(st.nextToken());
            int edge = Integer.parseInt(st.nextToken());
            graph[vertex][edge] = 1;
            graph[edge][vertex] = 1;

        }


        dfs(V);
        System.out.println();
        for(int i=0;i<N+1;i++)
            visited[i]=false;
        bfs(V);





    }

}