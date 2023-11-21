import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int T,M,N,K;
    static int [][] graph;
    static boolean [][] visited;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++)
        {
            int count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            graph = new int[M][N];
            visited = new boolean[M][N];

            for(int j=0; j<K; j++)
            {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph[u][v] = 1;
            }

            for(int k=0; k<M; k++)
            {
                for(int l=0; l<N; l++)
                {
                    if(graph[k][l]==0)
                        visited[k][l]=true;
                }
            }
            for(int k=0; k<M; k++)
            {
                for(int l=0; l<N; l++)
                {
                    if(!visited[k][l])
                    {
                        count+=1;
                        DFS(k,l);
                    }

                }
            }
            System.out.println(count);

        }


    }

    static void DFS(int k, int l)
    {
        visited[k][l] = true;
        if (k > 0 && !visited[k - 1][l])
            DFS(k - 1, l);
        if (k < M-1 && !visited[k + 1][l])
            DFS(k + 1, l);
        if (l > 0 && !visited[k][l - 1])
            DFS(k, l - 1);
        if (l < N - 1 && !visited[k][l + 1])
            DFS(k, l + 1);
    }


}